package ml.sun.demo.common;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class HttpUtilTest {
    @Test
    public void httpTest() {
        var json = HttpUtil.get("http://httpbin.org/get").execute(JsonNode.class);
        log.info("origin: {}", JsonUtil.getText(json, "origin"));
    }
}
