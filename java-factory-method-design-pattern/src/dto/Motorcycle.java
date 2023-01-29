package dto;

import java.math.BigDecimal;

public class Motorcycle extends Vehicle {

  private static final double WASH_RATE = 0.75;

  @Override
  public BigDecimal calculateWashRate() {
    return WASH_BASE_PRICE.multiply(BigDecimal.valueOf(WASH_RATE));
  }

  @Override
  public double getWashRate() {
    return WASH_RATE;
  }
}
