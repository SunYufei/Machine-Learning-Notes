package ml.sun.demo.controller;

import ml.sun.demo.common.CommonResult;
import ml.sun.demo.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Sun
 * @date 2022/1/27
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private IUserService service;

    @GetMapping("get/{username}")
    public CommonResult<?> getUser(@PathVariable String username) {
        return CommonResult.success(service.getUserByName(username));
    }
}
