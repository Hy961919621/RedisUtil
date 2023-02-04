package com.yong.redisutil.controller;

import com.alibaba.fastjson2.JSONObject;
import com.yong.redisutil.util.ResultData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestReceiveController {

    @PostMapping("/receive")
    public ResultData receive(@RequestBody JSONObject jsonObject){

        System.out.println("=========接收到信息=========");
        System.out.println(jsonObject);

        return new ResultData(200,"success",null);
    }

}
