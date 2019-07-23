package sofa.process.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class SingleProcessRejectDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("拒绝审批");
    }
}
