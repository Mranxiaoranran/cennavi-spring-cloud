package sofa.auth.service;

import sofa.common.bean.dto.BaseDTO;
import sofa.common.bean.vo.UserVO;

public interface UserService {
    /**
     * 登陆
     * @param userVO
     * @return
     */
    BaseDTO login(UserVO userVO) throws Exception;

}
