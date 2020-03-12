package app.util;

public abstract class Response<TValue> {

    private final TValue value;
    private final boolean isSuccess;
    private final String[] messages;

    public TValue getValue() {
        return value;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String[] getMessages() {
        return messages;
    }

    public Response(TValue value){
        this(value,true,null);
    }

    public Response(String[] messages){
        this(null,false, messages);
    }

    private Response(TValue value, boolean isSuccess, String[] messages) {
        this.value = value;
        this.isSuccess = isSuccess;
        this.messages = messages;
    }




}
