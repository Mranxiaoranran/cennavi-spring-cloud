package sofa.common.bean;

import lombok.Data;

@Data
public class BaseSuccessDTO<T> extends BaseDTO {

    public BaseSuccessDTO(){
        setCode(10000);
        setMessage("Success");
    }

    /**
     * 业务数据
     */
    private T data;



}
