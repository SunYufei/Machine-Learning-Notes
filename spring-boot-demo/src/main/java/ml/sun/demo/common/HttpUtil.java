package ml.sun.demo.common;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class HttpUtil {
    private static final RestTemplate restTemplate = new RestTemplate();

    public static HttpRequest get(String url) {
        return new HttpRequest(url).method(HttpMethod.GET);
    }

    public static HttpRequest post(String url) {
        return new HttpRequest(url).method(HttpMethod.POST);
    }

    public static class HttpRequest {
        private final String url;
        private final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        private HttpMethod method = HttpMethod.GET;
        private final HttpHeaders headers = new HttpHeaders();
        private final MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        private final Map<String, Object> json = new HashMap<>();
        private String body = null;

        public HttpRequest(@NonNull String url) {
            this.url = url;
        }

        public HttpRequest param(String key, String... value) {
            params.put(key, Arrays.asList(value));
            return this;
        }

        public HttpRequest param(MultiValueMap<String, String> map) {
            params.putAll(map);
            return this;
        }

        public HttpRequest method(HttpMethod method) {
            this.method = method;
            return this;
        }

        public HttpRequest cookie(@NonNull String cookie) {
            headers.set(HttpHeaders.COOKIE, cookie);
            return this;
        }

        public HttpRequest origin(@NonNull String origin) {
            headers.set(HttpHeaders.ORIGIN, origin);
            return this;
        }

        public HttpRequest form(String key, Object... value) {
            headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
            this.form.put(key, Arrays.asList(value));
            return this;
        }

        public HttpRequest json(String key, Object value) {
            headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            this.json.put(key, value);
            return this;
        }

        public HttpRequest json(String json) {
            return body(json, MediaType.APPLICATION_JSON_VALUE);
        }

        public HttpRequest body(String body) {
            return body(body, MediaType.TEXT_PLAIN_VALUE);
        }

        public HttpRequest body(String body, String contentType) {
            headers.set(HttpHeaders.CONTENT_TYPE, contentType);
            this.body = body;
            return this;
        }

        public String execute() {
            return execute(String.class);
        }

        public <T> T execute(Class<T> respType) {
            return executeForEntity(respType).getBody();
        }

        @NonNull
        public <T> ResponseEntity<T> executeForEntity(Class<T> respType) {
            // URI
            var builder = UriComponentsBuilder.fromHttpUrl(url).queryParams(params);
            // entity
            HttpEntity<Object> entity = new HttpEntity<>(body, headers);
            if (!form.isEmpty()) {
                entity = new HttpEntity<>(form, headers);
            }
            if (!json.isEmpty()) {
                entity = new HttpEntity<>(json, headers);
            }
            // request
            return restTemplate.exchange(builder.build().toUri(), method, entity, respType);
        }
    }
}
