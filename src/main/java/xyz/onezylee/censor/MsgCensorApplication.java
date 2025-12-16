package xyz.onezylee.censor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xyz.onezylee.censor.mapper")
public class MsgCensorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsgCensorApplication.class, args);
    }

}
