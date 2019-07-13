package sofa.center.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Pair;
import com.netflix.eureka.EurekaServerContext;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import com.netflix.eureka.registry.PeerAwareInstanceRegistryImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sofa.common.bean.dto.ServiceInfoDTO;
import sofa.common.bean.vo.ServiceInfoVO;

import java.util.*;

@RestController
public class ServiceController {

    /**
     * 查询服务列表
     *
     * @return
     */
    @RequestMapping("/listRegisterService.do")
    public String listService() throws JsonProcessingException {
        PeerAwareInstanceRegistryImpl registry = (PeerAwareInstanceRegistryImpl) getRegistry();
        List<Pair<Long, String>> lastNRegisteredInstances = registry.getLastNRegisteredInstances();
        List<ServiceInfoDTO> serviceInfoDTOS = new ArrayList<>();
        lastNRegisteredInstances.forEach(
                key -> {
                    ServiceInfoDTO serviceInfoDTO = new ServiceInfoDTO();
                    serviceInfoDTO.setInstanceId(key.second());
                    serviceInfoDTO.setRegistrationTime(key.first());
                    serviceInfoDTOS.add(serviceInfoDTO);
                }
        );
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(serviceInfoDTOS);
    }

    /**
     * 添加服务
     *
     * @return
     */
    @RequestMapping("/addService.do")
    public String addService(@RequestBody ServiceInfoVO serviceInfoVO) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        PeerAwareInstanceRegistryImpl registry = (PeerAwareInstanceRegistryImpl) getRegistry();
        InstanceInfo.Builder builder = InstanceInfo.Builder.newBuilder();
        builder.setInstanceId(serviceInfoVO.getInstanceId());
        builder.setAppName(serviceInfoVO.getAppName());
        builder.setHostName(serviceInfoVO.getHostName());
        builder.setIPAddr(serviceInfoVO.getIpAddr());
        builder.setPort(serviceInfoVO.getPort());
        InstanceInfo instanceInfo = builder.build();
        registry.register(instanceInfo, true);
        map.put("code", "success");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }


    private PeerAwareInstanceRegistry getRegistry() {
        return getServerContext().getRegistry();
    }

    private EurekaServerContext getServerContext() {
        return EurekaServerContextHolder.getInstance().getServerContext();
    }
}
