package sofa.common.bean.model;

public enum BaseErrorEnum {


    INVALID_AUTH_TOKEN(20001, "授权权限不足", "invalid-auth-token", "无效的访问令牌"),

    USER_PASSWORD_WRONG(40004, "业务处理失败", "password-wrong", "账号或密码错误"),

    SUCCESS_REQUEST(1000, "接口调用成功，调用结果请参考具体的API文档所对应的业务返回参数", "", ""),

    WRONG_REQUEST(40004, "业务处理失败", "WRONG_REQUEST", "服务器发生异常");


    /**
     * 状态码
     */
    private Integer code;
    /**
     * 返回码描述
     */
    private String message;

    /**
     * 明细返回码
     */
    private String subCode;

    /**
     * 明细返回码描述
     */
    private String subMsg;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubMsg() {
        return subMsg;
    }

    public void setSubMsg(String subMsg) {
        this.subMsg = subMsg;
    }

    BaseErrorEnum(Integer code, String message, String subCode, String subMsg) {
        this.code = code;
        this.message = message;
        this.subCode = subCode;
        this.subMsg = subMsg;
    }
}
