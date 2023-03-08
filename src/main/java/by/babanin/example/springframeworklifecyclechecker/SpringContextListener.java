package by.babanin.example.springframeworklifecyclechecker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

public class SpringContextListener implements ApplicationListener<ApplicationEvent> {

    private static final Logger log = LoggerFactory.getLogger(SpringContextListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        String message = null;
        if(event instanceof ContextRefreshedEvent) {
            message = "context refreshed";
        }
        else if(event instanceof ContextStartedEvent) {
            message = "context started";
        }
        else if(event instanceof ContextStoppedEvent) {
            message = "context stopped";
        }
        else if(event instanceof ContextClosedEvent) {
            message = "context closed";
        }

        if(message != null) {
            LogUtils.infoWithStacktrace(log, message);
        }
    }
}
