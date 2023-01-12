package com.ironhack.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()

                // User data Service
                .route(p -> p.path("/user/**")
                        .uri("lb://USER_DATA-SERVICE"))

                // Routine data Service
                .route(p -> p.path("/routine/**")
                        .uri("lb://ROUTINE-DATA-SERVICE"))
                .route(p -> p.path("/blocks/**")
                        .uri("lb://ROUTINE-DATA-SERVICE"))
                .route(p -> p.path("/exercises/**")
                        .uri("lb://ROUTINE-DATA-SERVICE"))
                .route(p -> p.path("/followUp/**")
                        .uri("lb://ROUTINE-DATA-SERVICE"))

                // Routine catalog Service
                .route(p -> p.path("/catalog/**")
                        .uri("lb://ROUTINE-CATALOG-SERVICE"))

                .build();
    }
}
