package com.itrus.contract.demo;

import cn.hutool.core.lang.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author pjw
 * @date 2023/8/14/0024
 */
@SpringBootApplication
@Configuration
public class ContractDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContractDemoApplication.class, args);
        Console.log("======================================================================");
        Console.log("demo启动成功");
        Console.log("======================================================================");
    }

}