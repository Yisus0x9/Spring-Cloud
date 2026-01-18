package com.yisus.client_standalone_yisus_config.clients;

import com.yisus.client_standalone_yisus_config.configuration.YisusLoadBalancerConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("yisus-config")
@LoadBalancerClient(name = "yisus-config",configuration = YisusLoadBalancerConfiguration.class)
public interface Yisus09CharacterClient {

    /*
        No hace falta implementación, es parecido a como trabaja Spring Data
     */
    @GetMapping(  "/application-name")
    public ResponseEntity<String> getApplicationName();
}
