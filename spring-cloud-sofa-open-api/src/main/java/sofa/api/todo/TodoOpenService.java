package sofa.api.todo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import sofa.common.bean.vo.TodoVO;

@FeignClient("spring-cloud-sofa-todo")
public interface TodoOpenService {

    @RequestMapping("/todo/add")
    void add(@RequestBody TodoVO todoVO);


}
