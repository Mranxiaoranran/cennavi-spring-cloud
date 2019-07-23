package sofa.common.bean.vo;

import lombok.Data;

/**
 * 单流程交互参数
 */
@Data
public class SingleProcessApprovalVO {


    /**
     * 审批人
     */
    private String approverUserId;

    /**
     * 申请人
     */
    private String applicantUserId;

    /**
     * 批准后回调接口（主要用与具体业务功能，参数拼接在URL后）
     */
    private String approveUrl;

    /**
     * 申请标题
     */
    private String title;






}
