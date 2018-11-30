package com.xk;

import com.xk.bean.User;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Created by hengxiaokang
 * Date:2018/9/19
 * Time:15:42
 */
public class RESTClient
{
    @Test
    public void test()
    {
        final User user = new User();
        user.setId("1000");
        user.setName("Test");
        final WebClient client = WebClient.create("http://localhost:9019/user");
        final Mono<User> createdUser = client.post()
                .uri("")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(user), User.class)
                .exchange()
                .flatMap(response -> response.bodyToMono(User.class));
        System.out.println(createdUser.block());
    }
}