package util;

import java.util.Optional;

public class Result {
    Optional<Double> value;
    String[] messages;

    public Optional<Double> getValue() {
        return value;
    }

    public String[] getMessages() {
        return messages;
    }

    public Result(Optional<Double> value) {
        this.value = value;
    }

    public Result(String[] messages) {
        this.messages = messages;
    }

    public boolean isSuccess() {
        return messages == null || messages.length == 0;
    }


}
