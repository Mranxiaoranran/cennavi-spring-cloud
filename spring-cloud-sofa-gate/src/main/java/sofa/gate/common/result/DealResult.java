package sofa.gate.common.result;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sofa.common.bean.model.BaseErrorEnum;
import sofa.common.bean.dto.BaseErrorDTO;

import java.nio.charset.StandardCharsets;

/**
 * 网关结果处理类
 *
 * @author anran
 */
public class DealResult {

    /**
     * 处理 token 异常，并且返回给客户端
     */
    public static Mono<Void> dealTokenError(ServerWebExchange serverWebExchange) {
        BaseErrorDTO baseVO = new BaseErrorDTO(BaseErrorEnum.INVALID_AUTH_TOKEN);
        return dealError(serverWebExchange, baseVO);
    }


    /**
     * 处理网关异常情况，并返回给调用者信息
     *
     * @param baseVO
     */
    private static Mono<Void> dealError(ServerWebExchange serverWebExchange, BaseErrorDTO baseVO) {
        serverWebExchange.getResponse().setStatusCode(HttpStatus.OK);
        byte[] bytes = JSONObject.toJSONString(baseVO).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = serverWebExchange.getResponse().bufferFactory().wrap(bytes);
        return serverWebExchange.getResponse().writeWith(Flux.just(buffer));
    }


}
