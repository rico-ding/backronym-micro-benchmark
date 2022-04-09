package experiment.backronym_micro_benchmark;

import static java.util.Map.entry;

import java.util.Map;

public class Preload {

  public static final Map<String, String> dictionary = Map.ofEntries(
    entry("A", "awesome"),
    entry("B", "beautiful"),
    entry("C", "confident"),
    entry("D", "disturbing"),
    entry("E", "eager"),
    entry("F", "fantastic"),
    entry("G", "gregarious"),
    entry("H", "hippy"),
    entry("I", "ingestable"),
    entry("J", "joke"),
    entry("K", "klingon"),
    entry("L", "literal"),
    entry("M", "mustache"),
    entry("N", "newtonian"),
    entry("O", "oscillating"),
    entry("P", "perfect"),
    entry("Q", "queen"),
    entry("R", "rant"),
    entry("S", "stylish"),
    entry("T", "turn"),
    entry("U", "underlying"),
    entry("V", "volcano"),
    entry("W", "weird"),
    entry("X", "xylophone"),
    entry("Y", "yogic"),
    entry("Z", "zero")
  );

  private Preload() {
  }

}
