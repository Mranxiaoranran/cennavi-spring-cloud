package sofa.common.bean.dto;

/**
 * 服务传输数据
 * @author  anran
 */
public class ServiceInfoDTO {
    /**
     * 实例ID
     */
    private String instanceId;

    /**
     * 注册时间
     */
    private Long  registrationTime;



    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public Long getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Long registrationTime) {
        this.registrationTime = registrationTime;
    }
}
