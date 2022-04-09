package experiment.backronym_micro_benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;

public class Main {

  public static void main(String[] args) throws Exception {
    org.openjdk.jmh.Main.main(args);
  }
  
  @Benchmark
  @Fork(value = 2, warmups = 1)
  public void benchmarkBackronym() {
    Backronym.makeBackronym("dgm");
    Backronym.makeBackronym("lkj");
    Backronym.makeBackronym("interesting");
    Backronym.makeBackronym("codewars");
  }

  @Benchmark
  @Fork(value = 2, warmups = 1)
  public void benchmarkBackronymBestPractices() {
    Backronym.makeBackronymBestPractices("dgm");
    Backronym.makeBackronymBestPractices("lkj");
    Backronym.makeBackronymBestPractices("interesting");
    Backronym.makeBackronymBestPractices("codewars");
  }

}
