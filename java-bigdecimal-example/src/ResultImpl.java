import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;

public class ResultImpl extends BaseClass implements Result {
  @Override
  public void printResult() {
    try {
      Object priceCalculationObject = PriceCalculation.class.getDeclaredConstructor().newInstance();
      Method printResult = priceCalculationObject.getClass().getDeclaredMethod("printResult");
      printResult.setAccessible(Boolean.TRUE);
      printResult.invoke(priceCalculationObject);

      BigDecimalMethodsExample bigDecimalMethodsExample = new BigDecimalMethodsExample();
      bigDecimalMethodsExample.printResult();
    } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException exception) {
      logger.log(Level.SEVERE, exception.getMessage());
    }
  }
}