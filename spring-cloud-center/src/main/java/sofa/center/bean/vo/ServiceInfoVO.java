package sofa.center.bean.vo;

/**
 * 服务请求参数
 * @author  anran
 */
public class ServiceInfoVO {
    /**
     * 实例ID
     */
    private String instanceId;

    /**
     * 应用名称
     */
    private String appName;

    /**
     *  host名称
     */
    private String hostName;

    /**
     * ip地址
     */
    private String ipAddr;

    /**
     * 端口号
     */
    private int port;




    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
