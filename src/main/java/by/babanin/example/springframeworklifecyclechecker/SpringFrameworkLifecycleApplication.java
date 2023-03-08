package by.babanin.example.springframeworklifecyclechecker;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringFrameworkLifecycleApplication {

    public static void main(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        CommandLine commandLine = parser.parse(ArgOptions.getOptions(), args);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context-definition.xml");
        context.registerShutdownHook();
        if(commandLine.hasOption(ArgOptions.TRIGGER_START_AND_STOP_CONTEXT.getOption())) {
            context.start();
            context.stop();
        }
    }
}
