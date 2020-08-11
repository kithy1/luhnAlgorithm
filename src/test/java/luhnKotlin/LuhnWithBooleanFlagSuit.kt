package luhnKotlin

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(LuhnWithBooleanFlagCheckDigitCalculationTestTest::class, LuhnWithBooleanFlagValidationNumberTest::class)
class LuhnWithBooleanFlagSuit {
}