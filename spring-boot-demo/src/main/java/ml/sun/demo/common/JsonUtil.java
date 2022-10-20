package ml.sun.demo.common;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.lang.NonNull;

public final class JsonUtil {
    public static String getText(@NonNull JsonNode node, String fieldName) {
        return node.get(fieldName).asText();
    }
}
