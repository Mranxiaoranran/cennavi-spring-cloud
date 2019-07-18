package sofa.common.bean.dto;

import lombok.Data;
import sofa.common.bean.model.BaseErrorEnum;

/**
 * 基础VO传输对象
 *
 * @author anran
 */
@Data
public class BaseErrorDTO extends BaseDTO {

    /**
     * 明细返回码
     */
    private String subCode;

    /**
     * 明细返回码描述
     */
    private String subMsg;

    public BaseErrorDTO(BaseErrorEnum baseResultEnum) {
        setCode(baseResultEnum.getCode());
        setMessage(baseResultEnum.getMessage());
        this.subCode = baseResultEnum.getSubCode();
        this.subMsg = baseResultEnum.getSubMsg();
    }


}
