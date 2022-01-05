public class ReflectionGetClassInstanceTest {

  private void executeTest() throws ClassNotFoundException {
    Class<?> reflectionTestClassWithForName = Class.forName("ReflectionGetClassInstanceTest");
    System.out.println("Name of the test class with forName() method is: " + reflectionTestClassWithForName.getName());

    //Get class instance by using getClass() method
    ReflectionGetClassInstanceTest reflectionGetClassInstanceTest = new ReflectionGetClassInstanceTest();
    Class reflectionTestClassWithGetClass = reflectionGetClassInstanceTest.getClass();
    System.out.println("Name of the test class with getClass() method is: " + reflectionTestClassWithGetClass.getName());

    //Get class instance by .class syntax
    Class reflectionTestClassWithClass = ReflectionGetClassInstanceTest.class;
    System.out.println("Name of the test class with .class syntax is: " + reflectionTestClassWithClass.getName());
  }
}