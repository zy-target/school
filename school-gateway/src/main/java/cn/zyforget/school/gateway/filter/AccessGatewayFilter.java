package cn.zyforget.school.gateway.filter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author denny.zhang
 * @Description token过滤器
 * @date 2019/12/12 13:55
 */
@Slf4j
@Component
public class AccessGatewayFilter implements GatewayFilter, Ordered {

    private static final String AUTHORIZE_TOKEN = "Authorization";
    private static final String BEARER = "Bearer ";

    /**
     * token过滤
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("当前环境已开启token校验");
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        ServerHttpResponse response = exchange.getResponse();
        // 取Authorization
        String tokenHeader = headers.getFirst(AUTHORIZE_TOKEN);
        log.info("tokenHeader=" + tokenHeader);
        // token不存在
        if (StringUtils.isEmpty(tokenHeader)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        // 取token
        String token = this.getToken(tokenHeader);
        log.info("token=" + token);

        // token不存在
        if (StringUtils.isEmpty(token)) {
            log.info("token不存在");
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        return chain.filter(exchange);
    }


    @Override
    public int getOrder() {
        return -10;
    }

    /**
     * 解析Token
     */
    public String getToken(String requestHeader) {
        //2.Cookie中没有从header中获取
        if (requestHeader != null && requestHeader.startsWith(BEARER)) {
            return requestHeader.substring(7);
        }
        return "";
    }
}
