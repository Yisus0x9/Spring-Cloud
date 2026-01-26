package com.yisus.spring_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class YisusConfig {

        @Bean
        @Profile("localhostRouter-noEureka")
        public RouteLocator configLocalNoEureka(RouteLocatorBuilder builder){

            return builder.routes()
                    .route(r->r.path("/api/v1/dragonball/*").uri("http://localhost:8082"))
                    .route(r->r.path("/api/v1/gameofthrones/*").uri("http://localhost:8083"))
                    .build();
    }

    /*
        Con Eureka no necesitamos definir los puertos, ya que en automatico
        toma la información del registry para hacer el redireccionamiento del tráfico
     */
    @Bean
    @Profile("localhostRouter-Eureka")
    public RouteLocator configLocalEureka(RouteLocatorBuilder builder){

        return builder.routes()
                .route(r->r.path("/api/v1/dragonball/*").uri("lb://yisus-config"))
                .route(r->r.path("/api/v1/gameofthrones/*").uri("lb://yisus-game-of-thrones"))
                .build();
    }

    /*
            En este caso Circuit Breaker se habilita por endpoint, usando filters para añadir un filtro
            de tipo Circuit Breaker, se le da un nombre, se indica la URL a la que se redirigira en caso de que
            la ruta principal falle y se le da un ID a ese forward.
            Nota: la url de forward también se tiene que declarar en el gateway
     */
    @Bean
    @Profile("localhostRouter-Eureka-cb")
    public RouteLocator configLocalEurekaCb(RouteLocatorBuilder builder){

        return builder.routes()
                .route(r->r.path("/api/v1/dragonball/*").
                        filters(f->f.circuitBreaker(
                                c->c.setName("failoverCB")
                                        .setFallbackUri("forward:/api/v1/db-failover/dragonball/characters")
                                        .setRouteId("dbFailover")
                        )).
                        uri("lb://yisus-config"))
                .route(r->r.path("/api/v1/gameofthrones/*").uri("lb://yisus-game-of-thrones"))
                .route(r->r.path("/api/v1/db-failover/dragonball/*").uri("lb://yisusg-failover"))
                .build();
    }
}
