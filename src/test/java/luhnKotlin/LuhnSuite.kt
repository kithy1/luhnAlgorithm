package luhnKotlin

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(LuhnCalculateCheckDigitTest::class, LuhnValidationNumberTest::class)
class LuhnSuite {
}