package sofa.file.common.dal;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import sofa.common.bean.dal.FileDO;

@Mapper
public interface FileMapper extends BaseMapper<FileDO> {
}
