package sofa.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sofa.auth.service.UserService;
import sofa.common.bean.dto.BaseDTO;
import sofa.common.bean.dto.BaseErrorDTO;
import sofa.common.bean.model.BaseErrorEnum;
import sofa.common.bean.vo.UserVO;

@RestController
@RequestMapping("/api/auth/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public BaseDTO login(UserVO userVO) {
        try {
            return userService.login(userVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseErrorDTO(BaseErrorEnum.INVALID_AUTH_TOKEN);
        }
    }

}
