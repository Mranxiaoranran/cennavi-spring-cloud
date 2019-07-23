package sofa.process.service.impl;

import org.flowable.engine.IdentityService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sofa.common.bean.dto.ProcessDTO;
import sofa.common.bean.model.ProcessEnum;
import sofa.common.bean.vo.ProcessVO;
import sofa.common.bean.vo.UserVO;
import sofa.process.service.ProcessService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("processServiceImpl")
public class ProcessServiceImpl implements ProcessService {


    /**
     * 审批人用户ID
     */
    private static final String APPROVER_USER_ID = "approverUserId";


    /**
     * 流程状态
     */
    private static final String PROCESS_STATUS = "processState";

    /**
     * 流程ID
     */
    private static String PROCESS_ID = "processId";


    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private IdentityService identityService;

    public void start(ProcessVO processVO) {
        Map<String, Object> startProcess = getStartProcessMap(processVO);
        //设置审批人
        identityService.setAuthenticatedUserId(processVO.getApproverUserId());
        //启动流程
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(processVO.getProcessBpmnFileName(), processVO.getProcessId(), startProcess);
    }

    @Override
    public void pass(String taskId) {
        Map<String, Object> map = new HashMap<>();

    }



    private Map<String, Object> getStartProcessMap(ProcessVO processVO) {
        Map<String, Object> startProcessMap = new HashMap<>();
        startProcessMap.put(APPROVER_USER_ID, processVO.getApproverUserId());
        startProcessMap.put(PROCESS_STATUS, ProcessEnum.PENDING);
        startProcessMap.put("PROCESS_ID", processVO.getProcessId());
        return startProcessMap;
    }

}
