package app.util;

public interface Handler<TRequest,TResponse> {
    TResponse handle(TRequest request);
}
