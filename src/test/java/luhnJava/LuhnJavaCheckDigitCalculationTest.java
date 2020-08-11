package luhnJava;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class LuhnJavaCheckDigitCalculationTest {
    LuhnAlgorithm luhn;

    String numberInCase;
    int checkDigitInCase;

    public LuhnJavaCheckDigitCalculationTest(String numberInCase, int checkDigitInCase) {
        this.numberInCase = numberInCase;
        this.checkDigitInCase = checkDigitInCase;
        luhn = new LuhnJava();
    }
    @Parameterized.Parameters
    public static Collection setUpData(){
        return List.of(new Object[][] {{"2255889", 4},{"35328501174149",3},{"92480", 3}, {"0000", 0}, {"54535", 0}, {"34668270810251", 0}, {"35395129939832", 8}});
    }

    @Test
    public void calculateCheckDigit() {
        Assert.assertEquals(checkDigitInCase, luhn.calculateCheckDigit(numberInCase), 0);
    }
}
