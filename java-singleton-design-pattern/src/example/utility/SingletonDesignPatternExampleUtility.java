package example.utility;

import example.dto.EarlyInstantiationOfSingletonClass;
import example.dto.LazyInstantiationOfSingletonClass;

import java.util.Objects;

public class SingletonDesignPatternExampleUtility {

  public void runExample() {
    EarlyInstantiationOfSingletonClass firstEarlyInstantiationOfSingletonClass = EarlyInstantiationOfSingletonClass.getInstance();
    EarlyInstantiationOfSingletonClass secondEarlyInstantiationOfSingletonClass = EarlyInstantiationOfSingletonClass.getInstance();

    LazyInstantiationOfSingletonClass firstLazyInstantiationOfSingletonClass = LazyInstantiationOfSingletonClass.getInstance();
    LazyInstantiationOfSingletonClass secondLazyInstantiationOfSingletonClass = LazyInstantiationOfSingletonClass.getInstance();

    System.out.println(
        String.format("Are %s and %s equal as they are early instantiated ? %s"
            , firstEarlyInstantiationOfSingletonClass.toString()
            , secondEarlyInstantiationOfSingletonClass.toString()
            , Objects.equals(firstEarlyInstantiationOfSingletonClass, secondEarlyInstantiationOfSingletonClass)
        )
    );

    System.out.println(
        String.format("Are %s and %s equal as they are lazy instantiated ? %s"
            , firstLazyInstantiationOfSingletonClass.toString()
            , secondLazyInstantiationOfSingletonClass.toString()
            , Objects.equals(firstLazyInstantiationOfSingletonClass, secondLazyInstantiationOfSingletonClass)
        )
    );
  }
}
