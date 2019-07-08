package sofa.auth.service;

import sofa.common.bean.BaseDTO;
import sofa.common.bean.BaseErrorDTO;
import sofa.common.bean.UserVO;

public interface UserService {
    /**
     * 登陆
     * @param userVO
     * @return
     */
    BaseDTO login(UserVO userVO) throws Exception;

}
