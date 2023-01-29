package dto;

import java.math.BigDecimal;

public abstract class Vehicle {
  protected static final BigDecimal WASH_BASE_PRICE = BigDecimal.valueOf(50L);

  public abstract BigDecimal calculateWashRate();
  public abstract double getWashRate();
}
