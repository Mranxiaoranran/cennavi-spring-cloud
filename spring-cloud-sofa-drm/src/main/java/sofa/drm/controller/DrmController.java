package sofa.drm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sofa.drm.service.DrmService;

@RestController
@RequestMapping("/drm")
public class DrmController {

    @Autowired
    private DrmService drmService;


    @RequestMapping("/getStatus.do")
    public boolean getDrmStatus( @RequestParam String drmCode) {
        return drmService.getDrmStatus(drmCode);
    }


}
