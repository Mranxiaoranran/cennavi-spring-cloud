package sofa.drm.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sofa.drm.bean.DrmDO;
import sofa.drm.dal.DrmMapper;
import sofa.drm.service.DrmService;
@Service
public class DrmServiceImpl implements DrmService {
    @Autowired
    private DrmMapper drmMapper;

    @Override
    public boolean getDrmStatus(String drmCode) {
        QueryWrapper<DrmDO> drmDOQueryWrapper = new QueryWrapper<>();
        drmDOQueryWrapper.eq("DRM_CODE", drmCode);
        drmDOQueryWrapper.eq("DRM_STATUS", 1);
        DrmDO drmDO = drmMapper.selectOne(drmDOQueryWrapper);
        return null != drmDO;
    }
}
