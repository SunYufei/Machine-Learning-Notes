package ml.sun.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@AllArgsConstructor
public enum ResultCode {
    OK(0, null),
    ILLEGAL_ARG(1000, "非法参数");

    private final int code;
    private final String message;
}
