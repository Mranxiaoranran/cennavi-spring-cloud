package sofa.file.common.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("SYS_FILE")
public class FileDO {


    private String fileCode;

    private String fileName;

    private Long fileSize;

    private String fileType;

    private Integer fileStorageType;

}
