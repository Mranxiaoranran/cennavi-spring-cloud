package sofa.common.bean.dal;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("SYS_FILE_STORAGE_TYPE")
public class FileStorageTypeDO {

    private Integer id;

    private Integer fileStorageType;

    private String fileStorageName;

    private String  driverClassName;






}
