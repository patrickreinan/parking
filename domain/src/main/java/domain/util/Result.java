package domain.util;

import java.util.Optional;

public class Result<T> {
    private Optional<T> value;
    private String[] messages;

    public Optional<T> getValue() {
        return value;
    }

    public String[] getMessages() {
        return messages;
    }

    public Result(Optional<T> value) {
        this.value = value;
    }

    public Result(String[] messages) {
        this.messages = messages;
    }

    public Result(String message){
        this.messages =new String[]{message};
    }

    public boolean isSuccess() {
        return messages == null || messages.length == 0;
    }


}
