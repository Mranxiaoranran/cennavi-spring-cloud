package sofa.common.bean.model;

public enum ProcessEnum {

    /**
     * 待审批
     */
    PENDING(0),
    /**
     * 已同意申请
     */
    PASS(1),
    /**
     * 已拒绝申请
     */
    REJECT(2),
    /**
     * 已取消
     */
    CANCEL(3);

    /**
     * 状态
     */
    private Integer status;

    ProcessEnum(Integer status) {
        this.status = status;
    }
}
