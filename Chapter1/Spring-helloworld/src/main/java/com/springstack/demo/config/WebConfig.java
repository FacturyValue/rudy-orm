package com.springstack.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

//@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    StringHttpMessageConverter converter = null;

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(false);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(responseBodyConverter());
    }

    @Bean
    @Primary
    public HttpMessageConverter<String> responseBodyConverter() {
        // 默认使用UTF-8
        //converter = new StringHttpMessageConverter(Charset.defaultCharset());
        converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }

}
