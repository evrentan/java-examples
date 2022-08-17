package example.dto;

import java.time.LocalTime;

public class EagerInstantiationOfSingletonClass {

  /**
   * Object that provides the eager instantiation of the class while load time and as it is static, it will be loaded once
   */
  private static EagerInstantiationOfSingletonClass eagerInstantiationOfSingletonClass = new EagerInstantiationOfSingletonClass();

  /**
   * Private constructor to avoid instantiate the class from outside the class
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  private EagerInstantiationOfSingletonClass() {
    System.out.println(String.format("%s is instantiated at call time at %s !!!", EagerInstantiationOfSingletonClass.class.getCanonicalName(), LocalTime.now()));
  }

  /**
   * Static factory method that returns the object instantiated during load time
   * @return EagerInstantiationOfSingletonClass instance
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  public static EagerInstantiationOfSingletonClass getInstance() {
    return eagerInstantiationOfSingletonClass;
  }
}
