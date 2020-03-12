package domain.tests.utiltests;

import org.junit.Assert;
import org.junit.Test;
import domain.util.Result;

import java.util.Optional;

public class ResultTests {

    @Test
    public  void result_success() {

        var result = new Result(Optional.of(1.0));

        Assert.assertTrue(result.isSuccess());


    }

    @Test
    public  void result_not_success() {

        var result = new Result(new String[] {"error message"});
        Assert.assertFalse(result.isSuccess());

    }
}
