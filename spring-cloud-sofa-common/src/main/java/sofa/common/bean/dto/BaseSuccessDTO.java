package sofa.common.bean.dto;

import lombok.Data;
import sofa.common.bean.dto.BaseDTO;

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
