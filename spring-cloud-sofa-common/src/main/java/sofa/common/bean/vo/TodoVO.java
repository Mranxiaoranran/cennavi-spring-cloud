package sofa.common.bean.vo;

import lombok.Data;

import java.util.Date;

@Data
public class TodoVO {
    /**
     * 代办表
     */
    private String todoTitle;
    /**
     * 办理人
     */
    private String doneUserId;

    /**
     * 发送人
     */
    private String sendUserId;
    /**
     * 流程编码 对应代办中心主键
     */
    private String taskId;



}
