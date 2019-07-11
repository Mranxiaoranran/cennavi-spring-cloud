package sofa.auth.dal;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import sofa.auth.bean.UserDO;

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {



}
