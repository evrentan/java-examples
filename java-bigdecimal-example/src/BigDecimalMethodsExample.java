import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalMethodsExample {

  protected void printResult() {
    System.out.println("BigDecimal Methods Examples: ");
    final BigDecimal firstBigDecimal = BigDecimal.valueOf(11.25);
    final MathContext mathContext = new MathContext(2, RoundingMode.CEILING);
    final BigDecimal secondBigDecimal = firstBigDecimal.multiply(new BigDecimal("2.45", mathContext));
    System.out.println(String.format("Multiplication of two BigDecimals with one initialized with MathContext with precision 2 and rounding mode ceiling : %s", secondBigDecimal));

    final BigDecimal thirdBigDecimal = BigDecimal.valueOf(2.02).pow(BigDecimal.TEN.intValue());
    System.out.println(String.format("Power of ten of one BigDecimal : %s", thirdBigDecimal));
  }
}
