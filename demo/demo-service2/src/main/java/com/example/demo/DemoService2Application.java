package com.example.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;


@MapperScan(value = { "com.example.demo" })
@ComponentScan(value = { "com.example.demo" })
@SpringBootApplication
public class DemoService2Application {

//    /**/public static void main(String[] args) {
//        SpringApplication.run(DemoService2Application.class, args);
//    }
    static {
        System.setProperty("spring.output.ansi.enabled", "ALWAYS");
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoService2Application.class)
                .web(false)
                .run(args);
    }
}
