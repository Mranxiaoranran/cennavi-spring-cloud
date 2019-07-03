package sofa.center.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.shared.Pair;
import com.netflix.eureka.EurekaServerContext;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import com.netflix.eureka.registry.PeerAwareInstanceRegistryImpl;
import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ServiceController {

    /**
     * 查询所有服务
     *
     * @return
     */
    @RequestMapping("/listService.do")
    public String listService() throws JsonProcessingException {
        PeerAwareInstanceRegistryImpl registry = (PeerAwareInstanceRegistryImpl) getRegistry();
        List<Pair<Long, String>> lastNRegisteredInstances = registry.getLastNRegisteredInstances();
        List<Map<Long,String>> lastRegisteredInstances = new ArrayList<>();
        lastNRegisteredInstances.forEach(
                key->{
                    Map<Long,String> map = new HashMap<>(1);
                    map.put(key.first(),key.second());
                    lastRegisteredInstances.add(map);
                }
        );
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(lastRegisteredInstances);
    }

  


    private PeerAwareInstanceRegistry getRegistry() {
        return getServerContext().getRegistry();
    }

    private EurekaServerContext getServerContext() {
        return EurekaServerContextHolder.getInstance().getServerContext();
    }
}
