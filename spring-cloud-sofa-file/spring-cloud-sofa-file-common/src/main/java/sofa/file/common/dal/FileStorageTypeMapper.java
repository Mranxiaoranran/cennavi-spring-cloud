package sofa.file.common.dal;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import sofa.common.bean.dal.FileStorageTypeDO;

public interface FileStorageTypeMapper extends BaseMapper<FileStorageTypeDO> {

     FileStorageTypeDO getFileStorageTypeByFileCode(String fileCode);

}
