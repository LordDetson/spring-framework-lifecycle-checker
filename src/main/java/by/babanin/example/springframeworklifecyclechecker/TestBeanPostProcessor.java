package by.babanin.example.springframeworklifecyclechecker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBeanPostProcessor implements BeanPostProcessor {

    public static final String TEST_BEAN_NAME = "testBean";

    private static final Logger log = LoggerFactory.getLogger(TestBeanPostProcessor.class);

    public TestBeanPostProcessor() {
        LogUtils.infoWithStacktrace(log, "BeanPostProcessor constructor");
    }

    public void init() {
        LogUtils.infoWithStacktrace(log, "initMethod registered method");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(shouldShowBean(beanName)) {
            LogUtils.infoWithStacktrace(log, "BeanPostProcessor#postProcessBeforeInitialization() method - beanName = " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(shouldShowBean(beanName)) {
            LogUtils.infoWithStacktrace(log, "BeanPostProcessor#postProcessAfterInitialization() method - beanName = " + beanName);
        }
        return bean;
    }

    public void cleanUp() {
        LogUtils.infoWithStacktrace(log, "destroyMethod registered method");
    }

    private boolean shouldShowBean(String beanName) {
        return beanName.equals(TEST_BEAN_NAME);
    }
}
