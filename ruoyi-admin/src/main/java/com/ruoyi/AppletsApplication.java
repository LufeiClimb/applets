package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author climbup
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AppletsApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppletsApplication.class, args);
        System.out.println("========= 系统启动成功 ========");
    }
}
