package dto;

import java.math.BigDecimal;

public class Pickup extends Vehicle {

  private static final double WASH_RATE = 2;

  @Override
  public BigDecimal calculateWashRate() {
    return WASH_BASE_PRICE.multiply(BigDecimal.valueOf(WASH_RATE));
  }

  @Override
  public double getWashRate() {
    return WASH_RATE;
  }
}
