package sofa.process.service;

import org.flowable.engine.delegate.DelegateExecution;
import sofa.common.bean.dto.ProcessDTO;
import sofa.common.bean.vo.ProcessVO;
import sofa.common.bean.vo.UserVO;

import java.util.List;

/**
 * 流程服务
 */
public interface ProcessService {

    /**
     * 开始审批
     *
     * @param processParamVO 流程信息
     */
    void start(ProcessVO processParamVO);

    /**
     * 通过审批
     *
     * @param processId
     */
    void pass(String processId);





}
