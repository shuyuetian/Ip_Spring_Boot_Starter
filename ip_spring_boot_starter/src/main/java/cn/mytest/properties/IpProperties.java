package cn.mytest.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//component 是在service中如果需要使用#{}el表达式的话，需要起名字使用
@Component("ipProperties")
@ConfigurationProperties(prefix = "tools.ip")
public class IpProperties {
    /**
     * 显示日志周期
     */
    private Long cycle=5L;

    /**
     * 是否周期内重置函数
     */
    private Boolean cycleReset = false;

    /**
     * 日志输出模式 ：Detail 详细模式,SIMPLE 极简模式;
     */
    private String model=LogModel.Detail.value;

    public enum LogModel{
        Detail("detail"),
        SIMPLE("simple");
        private String value;
        LogModel(String value){
            this.value=value;
        }

        public String getValue() {
            return value;
        }
    }

    public Long getCycle() {
        return cycle;
    }

    public void setCycle(Long cycle) {
        this.cycle = cycle;
    }

    public Boolean getCycleReset() {
        return cycleReset;
    }

    public void setCycleReset(Boolean cycleReset) {
        this.cycleReset = cycleReset;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
