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
    Backronym.makeBackronym("abcdefghijklmnopqrstuvwxyz");
  }

  @Benchmark
  @Fork(value = 2, warmups = 1)
  public void benchmarkBackronymBestPractices() {
    Backronym.makeBackronymBestPractices("abcdefghijklmnopqrstuvwxyz");
  }

}
