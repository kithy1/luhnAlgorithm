package luhnJava;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;


@RunWith(Parameterized.class)
public class LuhnJavaValidationNumberTest {
    LuhnAlgorithm luhn;

    String numberInCase;
    Boolean isValid;

    public LuhnJavaValidationNumberTest(String numberInCase, Boolean isValid) {
        this.numberInCase = numberInCase;
        this.isValid = isValid;
        luhn = new LuhnJava();
    }

    @Parameterized.Parameters
    public static Collection inputData() {
        return List.of(new Object[][]{{"353285011741493", true}, {"22558894", true}, {"353285021741493", false}, {"924803", true}, {"925803", false}, {"0000", true}, {"353951299398328", true}, {"372180072157182", false}});
    }

    @Test
    public void validateTest() {
        boolean actual = luhn.validate(numberInCase);
        Assert.assertEquals(isValid, actual);
    }

}