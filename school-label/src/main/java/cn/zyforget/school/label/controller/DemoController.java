package cn.zyforget.school.label.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(tags = "测试controller")
public class DemoController {

    @Autowired
    private Environment env;

    @PostMapping("/demo")
    @ApiOperation(value="测试接口", notes="demo")
    public String demo(){
        return "返回数据：" + env.getProperty("school.es");
    }
}
