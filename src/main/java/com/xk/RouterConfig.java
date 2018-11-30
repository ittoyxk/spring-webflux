package com.xk;

import com.xk.web.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

/**
 * Description: spring-webflux
 * Created by: hengxiaokang
 * on 2018/10/17 18:45
 */
@Configuration
public class RouterConfig {

    @Autowired
    private TimeHandler timeHandler;

    @Bean
    public RouterFunction<ServerResponse> timerRouter()
    {
        return RouterFunctions.route(GET("/time"), timeHandler::getTime)
                .andRoute(GET("/date"), timeHandler::getDate)
                .andRoute(GET("/times"), timeHandler::sendTimePerSec);  // 这种方式相对于上一行更加简洁
    }
}
