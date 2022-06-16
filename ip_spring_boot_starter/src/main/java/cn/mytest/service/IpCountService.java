package cn.mytest.service;

import cn.mytest.properties.IpProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IpCountService {
    private HashMap<String,Integer> ipCountMap = new HashMap<>();
    @Autowired
    //当前的request对象的注入工作由使用当前starter的工程提供自动装配
    private HttpServletRequest httpServletRequest;
    public void count(){

        //1 获得ip地址
        String ip = httpServletRequest.getRemoteAddr();
//        System.out.println("----------------------------"+ip);
        //2 获得ip对应的count
        Integer count = ipCountMap.get(ip);
        //3 存入map中
        if(count==null){
            //第一次存
            ipCountMap.put(ip,1);
        }else{
            //后续存
            ipCountMap.put(ip,count+1);
        }
    }
    @Autowired
    private IpProperties properties;

    //展示数据 bean的名称+属性
    @Scheduled(cron = "0/#{ipProperties.cycle} * * * * ?")
    public void print(){
        if(properties.getModel().equals(IpProperties.LogModel.Detail.getValue())){
            System.out.println("          Ip访问监控");
            System.out.println("+-----ip-address-----+---num---+");
            Set<Map.Entry<String, Integer>> entries = ipCountMap.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(String.format("|%18s  |%6d   |",key,value));
            }
            System.out.println("+--------------------+---------+");
        }else if(properties.getModel().equals(IpProperties.LogModel.SIMPLE.getValue())){
            System.out.println("      Ip访问监控");
            System.out.println("+-----ip-address-----+");
            Set<Map.Entry<String, Integer>> entries = ipCountMap.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                String key = entry.getKey();
                System.out.println(String.format("|%18s  |",key));
            }
            System.out.println("+--------------------+");
        }
//        System.out.println("|                    |         |");

//        System.out.println("---------------"+properties.getCycleReset());
        if(properties.getCycleReset()){
            ipCountMap.clear();
        }
    }

}
