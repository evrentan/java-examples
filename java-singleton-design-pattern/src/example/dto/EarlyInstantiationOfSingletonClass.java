package example.dto;

import java.time.LocalTime;

public class EarlyInstantiationOfSingletonClass {

  // Object that provides the early instantiation of the class while load time and as it is static, it will be loaded once
  private static EarlyInstantiationOfSingletonClass earlyInstantiationOfSingletonClass = new EarlyInstantiationOfSingletonClass();

  // Private constructor to avoid instantiate the class from outside the class
  private EarlyInstantiationOfSingletonClass() {
    System.out.println(String.format("%s is instantiated at call time at %s !!!", EarlyInstantiationOfSingletonClass.class.getCanonicalName(), LocalTime.now()));
  }

  // Static factory method that returns the object instantiated during load time
  public static EarlyInstantiationOfSingletonClass getInstance() {
    return earlyInstantiationOfSingletonClass;
  }
}
