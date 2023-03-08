package by.babanin.example.springframeworklifecyclechecker;

import java.util.Arrays;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public enum ArgOptions {
    TRIGGER_START_AND_STOP_CONTEXT(Option.builder("tssc")
            .longOpt("triggerStartAndStopContext")
            .build());
    private final Option option;

    ArgOptions(Option option) {
        this.option = option;
    }

    public Option getOption() {
        return option;
    }

    public static Options getOptions() {
        Options options = new Options();
        Arrays.stream(ArgOptions.values())
                .forEach(argOptions -> options.addOption(argOptions.getOption()));
        return options;
    }
}
