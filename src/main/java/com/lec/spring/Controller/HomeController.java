package com.lec.spring.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HomeController {
    @Value("${env.info}")
    private String envInfo;

    @GetMapping("/aws/v2")
    public String hello(@RequestParam(defaultValue = "1")Integer num){
        if(num == 1){
            log.info("[" + envInfo +"] /aws/v2 info로그 #######");
        } else if (num == -1) {
            log.info("[" + envInfo +"] /aws/v2 error 로그 ##########");
        } else if (num == 0) {
            log.info("[" + envInfo +"] /aws/v2 warn 로그 ##########");
        }
        return "<h1>AWS v2</h1>";
    }
}
