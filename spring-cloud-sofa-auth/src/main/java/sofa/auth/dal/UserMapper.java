package sofa.auth.dal;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import sofa.common.bean.dal.UserDO;


@Mapper
public interface UserMapper extends BaseMapper<UserDO> {



}
