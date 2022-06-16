package cn.mytest.autoconfig;

import cn.mytest.interceptor.SpringMvcConfig;
import cn.mytest.properties.IpProperties;
import cn.mytest.service.IpCountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
//全部的配置类都需要在这里导入一下，该类为总的配置类
@EnableScheduling
//@EnableConfigurationProperties(IpProperties.class)
//EnableConfigurationProperties 注解生成bean的名称和el表达式有冲突
@Import({IpProperties.class, SpringMvcConfig.class})
public class IpAutoConfiguration {
    @Bean
    public IpCountService ipCountService(){
        return new IpCountService();
    }
}
