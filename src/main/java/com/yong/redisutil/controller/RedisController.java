package com.yong.redisutil.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.yong.redisutil.util.RedisUtil;
import com.yong.redisutil.util.ResultData;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.sql.Array;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/redis")
public class RedisController {

    final RedisUtil redisUtil;
    /**
     * 遍历所有key
     */
    @GetMapping("listKeys")
    public ResultData listKeys(){
        Collection<String> keys = redisUtil.keys("*");
        List<String> lists = new ArrayList<>();
        keys.forEach(x ->{
            lists.add(x);
        });

        return new ResultData(200,"success",lists);


    }

    /**
     * 模糊查询key
     */
    @GetMapping("likeKeys")
    public ResultData likeKeys(){

        //遍历对应的key
        Collection<String> keys = redisUtil.keys("A*");
        //删除key
        keys.forEach(x ->{
            redisUtil.deleteObject(x);
        });
        return new ResultData(200,"success",null);
    }

}
