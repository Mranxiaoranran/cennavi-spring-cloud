package sofa.orm.mybatis.plus.core;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Date;

public interface DbMapper<T> extends BaseMapper<T> {

    /**
     * 添加
     *
     * @param vo     请求参数领域模型
     * @param entit  数据抽象领域模型
     * @param ignore 领域模型转换需要忽略参数
     * @return 影响行数
     */
    default int insert(Object vo, T entit, String... ignore) {
        BeanUtils.copyProperties(vo, entit, ignore);
        Field createTime = ReflectionUtils.findField(entit.getClass(), "createTime");
        ReflectionUtils.makeAccessible(createTime);
        ReflectionUtils.setField(createTime, entit, new Date());
        return insert(entit);
    }

    /**
     * 如果主键存在则修改，如果不存在则新增
     *
     * @param entity 数据库实体类
     * @return
     */
    default int save(T entity) {
        int line = updateById(entity);
        if (0 == line) {
            line = insert(entity);
        }
        return line;
    }

    /**
     * @param vo     接收参数领域模型
     * @param entit  数据库领域模型
     * @param ignore 忽略转换的数据
     * @return
     */
    default int save(Object vo, T entit, String... ignore) {
        BeanUtils.copyProperties(vo, entit, ignore);
        return save(entit);
    }


}
