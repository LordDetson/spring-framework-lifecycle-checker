package by.babanin.example.springframeworklifecyclechecker;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringFrameworkLifecycleApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context-definition.xml");
        context.close();
    }
}
