package ml.sun.demo.controller;

import ml.sun.demo.common.Result;
import ml.sun.demo.common.ResultCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("health")
    public Result<?> health(@RequestParam(required = false) String param) {
        return param != null ? Result.success(param) : Result.failed(ResultCode.ILLEGAL_ARG, null);
    }
}
