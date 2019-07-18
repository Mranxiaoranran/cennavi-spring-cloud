package sofa.file.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sofa.common.bean.dal.FileDO;
import sofa.file.common.dal.FileMapper;

@Service
public class FileCommon {

    @Autowired
    private FileMapper fileMapper ;

    public String getDriverClassName(String fileCode ){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("FILE_CODE",fileCode);
        FileDO fileDO = fileMapper.selectOne(queryWrapper);
        return  null;
    }


}
