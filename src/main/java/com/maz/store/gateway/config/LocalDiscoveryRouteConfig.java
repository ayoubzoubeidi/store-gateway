package com.maz.store.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalDiscoveryRouteConfig {

    @Bean
    public RouteLocator route(RouteLocatorBuilder builder) {
        return
                builder.routes()

                        //todo add routes for product service, order service and inventory service
                        .route(r -> r.path("product_route", "/api/v1/products/**").uri("lb://product-service"))
                        .route(r -> r.path("inventory_route", "/api/v1/inventory/**").uri("lb://inventory-service"))
                        .route(r -> r.path("order_route", "/api/v1/orders/**").uri("lb://order-service"))

                        .build();
    }

}
