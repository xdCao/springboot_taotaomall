package app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by xdcao on 2017/5/23.
 */
@SpringBootApplication
@MapperScan("app.mapper")
public class taotao_app {

    public static void main(String[] args){
        SpringApplication.run(taotao_app.class);
    }



}
