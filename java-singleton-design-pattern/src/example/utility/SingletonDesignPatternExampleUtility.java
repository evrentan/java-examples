package example.utility;

import example.dto.EagerInstantiationOfSingletonClass;
import example.dto.LazyInstantiationOfSingletonClass;

import java.util.Objects;

public class SingletonDesignPatternExampleUtility {

  public void runExample() {
    EagerInstantiationOfSingletonClass firstEagerInstantiationOfSingletonClass = EagerInstantiationOfSingletonClass.getInstance();
    EagerInstantiationOfSingletonClass secondEagerInstantiationOfSingletonClass = EagerInstantiationOfSingletonClass.getInstance();

    LazyInstantiationOfSingletonClass firstLazyInstantiationOfSingletonClass = LazyInstantiationOfSingletonClass.getInstance();
    LazyInstantiationOfSingletonClass secondLazyInstantiationOfSingletonClass = LazyInstantiationOfSingletonClass.getInstance();

    System.out.println(
        String.format("Are %s and %s equal as they are eager instantiated ? %s"
            , firstEagerInstantiationOfSingletonClass.toString()
            , secondEagerInstantiationOfSingletonClass.toString()
            , Objects.equals(firstEagerInstantiationOfSingletonClass, secondEagerInstantiationOfSingletonClass)
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
