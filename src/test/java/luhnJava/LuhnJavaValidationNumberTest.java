package luhnJava;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;


@RunWith(Parameterized.class)
public class LuhnJavaValidationNumberTest {
    LuhnJava luhn;

    String numberInCase;
    Boolean isValidate;

    public LuhnJavaValidationNumberTest(String numberInCase, Boolean isValidate) {
        this.numberInCase = numberInCase;
        this.isValidate = isValidate;
        luhn = new LuhnJava();
    }

    @Parameterized.Parameters
    public static Collection inputData() {
        return List.of(new Object[][]{{"353285011741493", true}, {"22558894", true}, {"353285021741493", false}, {"924803", true}, {"925803", false}});
    }

    @Test
    public void validateTest() {
        boolean validate = luhn.validate(numberInCase);
        Assert.assertEquals(isValidate, validate);
    }

}