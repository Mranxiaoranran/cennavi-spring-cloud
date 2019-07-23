package sofa.gate.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import sofa.api.drm.DrmOpenService;
import sofa.common.bean.dto.TokenDTO;
import sofa.common.util.jwt.JwtUtil;
import sofa.gate.common.result.DealResult;


/**
 * spring cloud 基于 JWT 服务鉴权实现
 * 此处是在spring-cloud-gateway基础上
 *
 * @author anran
 */
@Component
public class AuthFilter implements GlobalFilter {

    private final Logger log = LoggerFactory.getLogger(AuthFilter.class);


    /**
     * JWT 存储在请求头中的key值
     */
    private final String TOKEN_HEADER = "Authorization";

    private final String IGNORE = "/api/auth/user/login.do";

    @Lazy
    @Autowired
    private DrmOpenService drmService;


    private static final String AUTH_FILTER_CHECK_TOKEN = "AUTH_FILTER_CHECK_TOKEN";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        if (request.getPath().pathWithinApplication().value().contains(IGNORE)) {
            ServerHttpRequest build = request.mutate().build();
            return chain.filter(exchange.mutate().request(build).build());
        }
        String authorization = request.getHeaders().getFirst("Authorization");
        ServerHttpRequest.Builder mutate = request.mutate();
        if (drmService.getDrmStatus(AUTH_FILTER_CHECK_TOKEN)) {
            try {
                //获取token式会发生异常，不过异常产生的原因可能是时间过期
                TokenDTO tokenDTO = JwtUtil.decryptToken(authorization);
            } catch (Exception e) {
                log.error("非法token", e);
                return DealResult.dealTokenError(exchange);
            }
        }

        ServerHttpRequest build = mutate.build();
        return chain.filter(exchange.mutate().request(build).build());
    }


}
