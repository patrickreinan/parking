package app.calculate;

import app.util.Response;

public class CalculateResponse extends Response<Double> {

    public CalculateResponse(String[] messages) {
        super(messages);
    }

    public CalculateResponse(Double aDouble) {
        super(aDouble);
    }
}
