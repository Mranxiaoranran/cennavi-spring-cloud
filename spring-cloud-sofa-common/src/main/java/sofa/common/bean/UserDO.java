package sofa.common.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName(value = "SYS_USER")
public class UserDO {

    private Integer id;

    private String  userId;

    private  String  userAccount;

    private String userPassword;


}
