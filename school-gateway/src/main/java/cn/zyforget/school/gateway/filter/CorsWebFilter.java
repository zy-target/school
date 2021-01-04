package cn.zyforget.school.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class CorsWebFilter implements WebFilter,Ordered {
    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange ctx, WebFilterChain chain) {
        ServerHttpRequest request = ctx.getRequest();
        ServerHttpResponse response = ctx.getResponse();
        HttpHeaders headers = response.getHeaders();
        String origin = request.getHeaders().getOrigin();
        if (origin != null) {
            headers.add("Access-Control-Allow-Origin", origin);
        }

        headers.add("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
        headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,Authorization,Allow");
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("Access-Control-Expose-Headers", "Authorization");
        headers.add("Access-Control-Max-Age", "86400000");
        headers.add("Content-Type", "application/json;charset=utf-8");
        if (request.getMethod() == HttpMethod.OPTIONS) {
            response.setStatusCode(HttpStatus.OK);
            return Mono.empty();
        } else {
            return chain.filter(ctx);
        }
    }
}
