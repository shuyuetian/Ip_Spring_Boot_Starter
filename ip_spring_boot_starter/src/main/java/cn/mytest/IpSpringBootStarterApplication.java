package cn.mytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IpSpringBootStarterApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(IpSpringBootStarterApplication.class, args);
        for (String beanDefinitionName : run.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }


}
