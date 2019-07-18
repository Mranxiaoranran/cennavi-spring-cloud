package sofa.common.bean.dal;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("SYS_FILE_LOCAL_STORAGE")
public class FileLocalStorageDO {

    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 文件编码
     */
    private  String fileCode;
    /**
     * 文件路径
     */
    private  String filePath;



}
