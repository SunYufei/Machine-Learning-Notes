package ml.sun.demo.common;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class HttpUtilTest {
    @Test
    public void httpTest() {
        JSONObject json = HttpUtil.get("http://httpbin.org/get").execute(JSONObject.class);
        log.info("origin: {}", json.getString("origin"));
    }
}
