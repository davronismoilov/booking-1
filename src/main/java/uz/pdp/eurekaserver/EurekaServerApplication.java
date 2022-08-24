package uz.pdp.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
@RestController
@RequestMapping("test")
public class EurekaServerApplication {

    @GetMapping
    public String fun(){
        return "Jenkins";
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
