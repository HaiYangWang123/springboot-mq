package hella;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Auth hywang
 * @Email hywang2017@qq.com
 * @Date 2018/3/3
 */
@SpringBootApplication
@Configuration
@EnableAsync
@PropertySource(value = {"/application.properties"}, encoding = "UTF-8")
public class ConsumerAppMain {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerAppMain.class, args);
        System.out.println("ConsumerAppMain Server startup .....");

    }
}
