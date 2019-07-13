package sofa.common.bean.dal;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("SYS_DRM")
public class DrmDO {

    private Integer id;

    private String drmCode;

    private String drmName;

    private Integer drmStatus;


}
