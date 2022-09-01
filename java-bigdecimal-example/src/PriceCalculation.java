import java.math.BigDecimal;

public class PriceCalculation {
  private static final double BASE_PRICE = 41.98;
  private static final double TAX_PERCENTAGE = 0.08;

  private void printResult() {
    System.out.println("**************");
    System.out.println("Price Calculation Example Using Double and BigDecimal:");
    System.out.println(String.format("Price with tax using doubles : %s", BASE_PRICE + (BASE_PRICE * TAX_PERCENTAGE)));

    final BigDecimal priceBigDecimal = new BigDecimal("41.98");
    final BigDecimal taxBigDecimal = BigDecimal.valueOf(TAX_PERCENTAGE);
    System.out.println(String.format("Price with tax using BigDecimals: %s", priceBigDecimal.multiply(taxBigDecimal).add(priceBigDecimal)));
    System.out.println("**************");
  }
}
