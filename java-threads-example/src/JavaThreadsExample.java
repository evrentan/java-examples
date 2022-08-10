import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaThreadsExample {

  public static void main(String[] args) {
    JavaThreadsExample javaThreadsExample = new JavaThreadsExample();

    List<Thread> myThreadList = Arrays.asList(new Thread(new MyThreadClassImplementingRunnable(), "myFirstThread")
        , new Thread(new MyThreadClassImplementingRunnable(), "mySecondThread")
        , new MyThreadClassExtendsThread("myThirdThread")
        , new MyThreadClassExtendsThread("myFourthThread"));
    javaThreadsExample.printThreadListState(myThreadList);
    javaThreadsExample.startThreadList(myThreadList);
  }

  void printThreadListState(List<Thread> threadList) {
    System.out.println("******* Start Printing Threads States *******");
    Map<String, Thread.State> myThreadStateMap = threadList.stream().collect(Collectors.toMap(Thread::getName, Thread::getState));
    myThreadStateMap.forEach((name, state) -> {
      System.out.println(String.format("%s state is %s", name, state));
    });
    System.out.println("******* End Printing Threads States *******");
  }

  void startThreadList(List<Thread> threadList) {
    System.out.println("*** Starting Threads ****");
    threadList.forEach(Thread::start);
    System.out.println("*** Threads Have Been Started ****");
  }
}
