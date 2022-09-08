import java.util.Arrays;
import java.util.List;

public class PerformanceLoopingVsStreaming {

  public static void main(String... args) {
    PerformanceLoopingVsStreaming performanceLoopingVsStreaming = new PerformanceLoopingVsStreaming();
    List<Thread> threadList = Arrays.asList(new Thread(new LoopingThread(), "loopingThread")
        , new Thread(new StreamingThread(), "streamingThread")
        , new Thread(new ParallelStreamingThread(), "parallelStreamingThread"));
    performanceLoopingVsStreaming.startThreadList(threadList);
  }

  void startThreadList(List<Thread> threadList) {
    System.out.println("*** Starting Threads ****");
    threadList.forEach(Thread::start);
    System.out.println("*** Threads Have Been Started ****");
  }
}
