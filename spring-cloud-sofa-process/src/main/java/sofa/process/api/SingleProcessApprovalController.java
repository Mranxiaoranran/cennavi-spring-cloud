package sofa.process.api;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sofa.api.todo.TodoOpenService;
import sofa.common.bean.vo.SingleProcessApprovalVO;
import sofa.common.bean.vo.TodoVO;

import java.util.HashMap;
import java.util.Map;

/**
 * 单流程审批接口
 */
@RestController
@RequestMapping("/process")
public class SingleProcessApprovalController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TodoOpenService todoOpenService;

    @RequestMapping("/startSingleProcessApproval")
    public void startProcess(@RequestBody SingleProcessApprovalVO singleProcessApprovalVO) {
        Map<String, Object> map = new HashMap<>();
        map.put("approverUserId", singleProcessApprovalVO.getApproverUserId());
        map.put("applicantUserId", singleProcessApprovalVO.getApplicantUserId());
        map.put("approveUrl", singleProcessApprovalVO.getApproveUrl());
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("singleProcessApproval", map);
        //任务id
        String processInstanceId = instance.getProcessInstanceId();
        TodoVO todoVO = new TodoVO();
        todoVO.setTaskId(processInstanceId);
        todoVO.setDoneUserId(singleProcessApprovalVO.getApproverUserId());
        todoVO.setSendUserId(singleProcessApprovalVO.getApplicantUserId());
        todoOpenService.add(todoVO);
    }

    @RequestMapping("/approvalSingleProcessApproval")
    public void approvalSingleProcessApproval(@RequestParam String taskId) {
        Map<String, Object> variables = taskService.getVariables(taskId);
        variables.put("approve", true);
        taskService.complete(taskId, variables);
    }

    @RequestMapping("/rejectSingleProcessApproval")
    public void startProcess(@RequestParam String taskId) {
        Map<String, Object> variables = taskService.getVariables(taskId);
        variables.put("approve", false);
        taskService.complete(taskId, variables);
    }
}
