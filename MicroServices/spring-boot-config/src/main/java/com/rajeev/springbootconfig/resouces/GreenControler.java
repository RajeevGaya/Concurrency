package com.rajeev.springbootconfig.resouces;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajeev.springbootconfig.DbSettings;

@RestController
@RefreshScope
public class GreenControler {

    @Value("${my.greet: default value}")
    private String greetingMsg;
    
    @Value("staic Msg")
    private String staticMsg;

    @Value("${pending.courses.list}")
    private List<String> courseList;

    @Value("#{${carrer}}")
    private Map<String,String> mapVal;

    @Autowired
    private DbSettings dbSettings;

    @Autowired
    private Environment environment;

    @GetMapping("/greet")
    public String getHelloMsg() {
        String[] activeProfiles = environment.getActiveProfiles();
        System.out.println(activeProfiles);
        return dbSettings.getHost()+".."+dbSettings.getConnection()+".."+dbSettings.getPort()+".."+greetingMsg+".."+staticMsg+".."+courseList+".."+mapVal;
    }
    @GetMapping("/env")
    public String envDetails(){
        return  environment.toString();
    }
}
