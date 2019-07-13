package sofa.common.bean.dto;

import lombok.Data;

@Data
public class BaseDTO {

    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回码描述
     */
    private String message;

}
