package com.yisus.client_standalone_yisus_config;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.yisus.client_standalone_yisus_config.clients.Yisus09CharacterClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;

import java.util.List;


@SpringBootApplication
@EnableFeignClients
public class ClientStandaloneYisusConfigApplication implements ApplicationRunner {

    private static final Logger log= LoggerFactory.getLogger(ClientStandaloneYisusConfigApplication.class);

     @Autowired
    private EurekaClient eurekaClient;

     @Autowired
     private Yisus09CharacterClient client;

    public static void main(String[] args) {
        SpringApplication.run(ClientStandaloneYisusConfigApplication.class, args);
    }

    /**
     *
     * @param args
     * @throws Exception
     * Implmentacion de cleinte de Eureka
     * @Override
     *     public void run(ApplicationArguments args) throws Exception {
     *         Application application = eurekaClient.getApplication("yisus-config");
     *         log.info("Application name {}",application.getName());
     *         List<InstanceInfo> instances = application.getInstances();
     *         instances.forEach(i->log.info("IP Addres {}:{}",i.getIPAddr(),i.getPort()));
     *     }
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 10; i++) {
            ResponseEntity<String> responseEntity = client.getApplicationName();
            log.info("Status {}",responseEntity.getStatusCode());
            log.info("Body {}",responseEntity.getBody());

        }

    }
}
