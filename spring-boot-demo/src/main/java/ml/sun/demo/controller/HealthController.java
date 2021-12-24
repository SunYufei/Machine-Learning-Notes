package ml.sun.demo.controller;

import ml.sun.demo.common.CommonResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author sun
 */
@RestController
@RequestMapping("health")
public class HealthController {
    @GetMapping
    @ResponseBody
    public CommonResult<String> health(@RequestParam(value = "content", required = false) String content) {
        return CommonResult.success(content);
    }

    @PostMapping
    @ResponseBody
    public CommonResult<String> post() {
        return CommonResult.success("post");
    }
}
