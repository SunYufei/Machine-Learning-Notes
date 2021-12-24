package ml.sun.demo.common;

import lombok.Data;
import lombok.Getter;

/**
 * @author sun
 */
@Data
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;

    CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResultCode.OK.getCode(), ResultCode.OK.getMessage(), data);
    }

    public static <T> CommonResult<T> failed() {
        return CommonResult.failed(null);
    }

    public static <T> CommonResult<T> failed(T data) {
        return new CommonResult<>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), data);
    }

    private enum ResultCode {
        //
        OK(200, "OK"),
        //
        FAILED(500, "FAILED");

        @Getter
        private final int code;
        @Getter
        private final String message;

        ResultCode(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
