package ml.sun.demo.exception;

import lombok.extern.slf4j.Slf4j;
import ml.sun.demo.common.Result;
import ml.sun.demo.common.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result<Exception> handler(Exception e) {
        log.error("", e);
        return Result.failed(ResultCode.EXCEPTION, e);
    }
}
