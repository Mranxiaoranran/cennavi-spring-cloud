package sofa.common.bean.dal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sy_todo")
public class TodoDO {
    @TableId(type= IdType.AUTO)
    private Integer id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更改时间
     */
    private Date updateTime;
    /**
     * 代办标题
     */
    private String todoTitle;
    /**
     * 代办发送时间
     */
    private Date todoSendTime;
    /**
     * 代办办结时间
     */
    private Date todoDoneTime;

    /**
     * 办理人编码
     */
    private String doneUserId;
    /**
     * 发送人编码
     */
    private String sendUserId;
    /**
     * 流程编码
     */
    private String taskId;


}
