package sofa.common.bean.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 流程参数
 */
@Data
public class ProcessVO implements Serializable {

    /**
     * 审批人用户ID
     */
    private String approverUserId;


    /**
     * 流程id，是xml文件里的那个processId
     */
    private String processBpmnFileName;

    /**
     * 流程ID
     */
    private String processId;


}
