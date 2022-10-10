package ml.sun.demo.common;

public record Result<T>(boolean success, int code, String message, T data) {
    public static <T> Result<T> success(T data) {
        return success(ResultCode.OK, data);
    }

    private Result() {
        this(true, ResultCode.OK.code(), ResultCode.OK.message(), null);
    }

    public static <T> Result<T> success(ResultCode code, T data) {
        return new Result<>(true, code.code(), code.message(), data);
    }

    public static <T> Result<T> failed(ResultCode code, T data) {
        return new Result<>(false, code.code(), code.message(), data);
    }
}
