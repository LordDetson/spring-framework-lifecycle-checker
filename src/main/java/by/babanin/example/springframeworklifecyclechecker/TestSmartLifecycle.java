package by.babanin.example.springframeworklifecyclechecker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;

public class TestSmartLifecycle implements SmartLifecycle {

    private static final Logger log = LoggerFactory.getLogger(TestSmartLifecycle.class);

    private boolean running;

    @Override
    public void start() {
        LogUtils.infoWithStacktrace(log, "SmartLifecycle#start method");
        running = true;
    }

    @Override
    public void stop() {
        LogUtils.infoWithStacktrace(log, "SmartLifecycle#stop method");
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
