import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        PrintHello reflectionClassWithoutReflection = new PrintHello();
        reflectionClassWithoutReflection.setValue("Hello Java without Reflection !!!");
        System.out.println(reflectionClassWithoutReflection.getValue());

        Object reflectionClassWithReflection = PrintHello.class.getDeclaredConstructor().newInstance();
        Method setValue = reflectionClassWithReflection.getClass().getDeclaredMethod("setValue", String.class);
        setValue.invoke(reflectionClassWithReflection, "Hello Java with Reflection !!!");
        Method method = reflectionClassWithReflection.getClass().getDeclaredMethod("printHello");
        method.setAccessible(true);
        method.invoke(reflectionClassWithReflection);

        Field declaredField = reflectionClassWithReflection.getClass().getDeclaredField("value");
        System.out.println("Name of the declared field value name is: "  + declaredField.getName());

        Field[] fields = reflectionClassWithReflection.getClass().getDeclaredFields();
        System.out.print("Declared fields of PrintHello class are: ");
        int fieldNumber = fields.length;
        int i = 0;
        for(Field field : fields) {
            System.out.print(field.getName());
            if (++i != fieldNumber) System.out.print(", ");
        }
        System.out.println();

        Object executeTestClass = ReflectionGetClassInstanceTest.class.getDeclaredConstructor().newInstance();
        Method executeTestMethod = executeTestClass.getClass().getDeclaredMethod("executeTest");
        executeTestMethod.setAccessible(true);
        executeTestMethod.invoke(executeTestClass);
    }
}
