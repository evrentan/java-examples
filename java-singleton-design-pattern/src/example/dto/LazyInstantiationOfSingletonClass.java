package example.dto;

import java.time.LocalTime;
import java.util.Objects;

public class LazyInstantiationOfSingletonClass {

  /**
   * Static attribute to be sure that it is loaded once
   */
  private static LazyInstantiationOfSingletonClass lazyInstantiationOfSingletonClass;

  /**
   * Private constructor to avoid instantiate the class from outside the class
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  private LazyInstantiationOfSingletonClass() {
  }

  /**
   * Static factory method that returns the object. It checks whether it is instantiated or not. If not, it creates the object first.
   * @return LazyInstantiationOfSingletonClass instance
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  public static LazyInstantiationOfSingletonClass getInstance() {
    // object is instantiated at call time of getInstance() method
    if (Objects.isNull(lazyInstantiationOfSingletonClass)) {
      lazyInstantiationOfSingletonClass = new LazyInstantiationOfSingletonClass();
      System.out.println(String.format("%s is instantiated at call time at %s !!!", LazyInstantiationOfSingletonClass.class.getCanonicalName(), LocalTime.now()));
    }

    return lazyInstantiationOfSingletonClass;
  }
}
