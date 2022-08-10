import java.util.Arrays;
import java.util.List;

public class JavaThreadExample {

  public static void main(String[] args) {
    JavaThreadExample javaThreadExample = new JavaThreadExample();

    List<Thread> myThreadListImplementingRunnable = Arrays.asList(new Thread(new MyThreadClassImplementingRunnable(), "myFirstThread"),
        new Thread(new MyThreadClassImplementingRunnable(), "mySecondThread"));
    javaThreadExample.startThreadList(myThreadListImplementingRunnable);

    List<Thread> myThreadListExtendingThread = Arrays.asList(new MyThreadClassExtendsThread("myThirdThread"),
        new MyThreadClassExtendsThread("myFourthThread"));

    javaThreadExample.startThreadList(myThreadListExtendingThread);

  }

  void startThreadList (List<Thread> threadList) {
    System.out.println("*** Starting Threads ****");
    threadList.forEach(Thread::start);
    System.out.println("*** Threads Have Been Started ****");
  }
}
