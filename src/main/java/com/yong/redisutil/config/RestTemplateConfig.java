package com.yong.redisutil.config;

import java.nio.charset.Charset;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @Resource(name="simpleClientHttpRequestFactory") // 在多ClientHttpRequestFactory的时候指定用哪个
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SSL factory = new SSL();
        factory.setReadTimeout(60000);
        factory.setConnectTimeout(30000);//单位为ms
        return factory;
    }

}