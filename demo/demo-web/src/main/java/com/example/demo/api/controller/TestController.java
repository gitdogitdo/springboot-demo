package com.example.demo.api.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.web.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/test")
@Api(tags = "功能-测试", value = "测试", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestController {

    @Reference(version = "1.0.0")
    private UserService userService;

    @GetMapping("/")
    @ApiOperation("测试列表")
    @ApiImplicitParams({
    })
    public ResponseMessage getName() {

        List<User> user = userService.selectList();

      return ResponseMessage.ok(user);
    }

    @GetMapping("/{id}")
    @ApiOperation("测试详情")
    @ApiImplicitParams({
    })
    public ResponseMessage detail(@PathVariable("id") String id) {

        User user = userService.selectByPK(id);

        return ResponseMessage.ok(user);
    }


    @PostMapping("/{id}/update")
    @ApiOperation("修改信息")
    @ApiImplicitParams({
    })
    public ResponseMessage update(@RequestBody User user) {

        int i = userService.update(user);
        return ResponseMessage.ok("修改成功");
    }

    @PostMapping("/{id}")
    @ApiOperation("删除信息")
    @ApiImplicitParams({
    })
    public ResponseMessage delete(@PathVariable("id") String id) {

        int i = userService.delete(id);
        return ResponseMessage.ok("删除成功");
    }

}

