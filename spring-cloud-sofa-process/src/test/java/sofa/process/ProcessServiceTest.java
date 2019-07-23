package sofa.process;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sofa.BaseTest;
import sofa.common.bean.vo.ProcessVO;
import sofa.process.service.ProcessService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessServiceTest extends BaseTest {
    @Autowired
    private ProcessService processService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RuntimeService runtimeService;

    @Test
    public void testList() {
        Map<String, Object> variables = new HashMap<String, Object>();
        List<Task> tasks = taskService.createTaskQuery().caseInstanceId("singleProcessApproval:1:5755e55c-ac7c-11e9-b7db-f8a2d6d5bb3a").list();
        System.out.println("You have " + tasks.size() + " tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ") " + tasks.get(i).getName());
        }
        Task task = tasks.get(0);
        Map<String, Object> processVariables = taskService.getVariables(task.getId());
        System.out.println(task.getId());
        System.out.println(processVariables);
    }

}
