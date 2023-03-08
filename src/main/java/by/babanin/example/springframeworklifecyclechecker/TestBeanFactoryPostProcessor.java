package by.babanin.example.springframeworklifecyclechecker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(TestBeanFactoryPostProcessor.class);

    public TestBeanFactoryPostProcessor() {
        LogUtils.infoWithStacktrace(log, "BeanFactoryPostProcessor constructor");
    }

    public void init() {
        LogUtils.infoWithStacktrace(log, "initMethod registered method");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        LogUtils.infoWithStacktrace(log, "BeanFactoryPostProcessor#postProcessBeanFactory method");
    }

    public void cleanUp() {
        LogUtils.infoWithStacktrace(log, "destroyMethod registered method");
    }
}
