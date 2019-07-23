package sofa.api.drm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("spring-cloud-sofa-drm")
public interface DrmOpenService {

    @RequestMapping("/drm/getStatus.do")
    boolean getDrmStatus(@RequestParam String drmCode);



}
