package experiment.backronym_micro_benchmark;

import static java.lang.Character.toUpperCase;
import static java.util.Map.entry;

import java.util.Map;
import java.util.stream.Collectors;

public class Backronym {

  private Backronym() {
  }

  private static Map<String, String> dictionary = Map.ofEntries(
    entry("A", "awesome"),
    entry("B", ""),
    entry("C", "confident"),
    entry("D", "disturbing"),
    entry("E", "eager"),
    entry("F", ""),
    entry("G", "gregarious"),
    entry("H", ""),
    entry("I", "ingestable"),
    entry("J", "joke"),
    entry("K", "klingon"),
    entry("L", "literal"),
    entry("M", "mustache"),
    entry("N", "newtonian"),
    entry("O", "oscillating"),
    entry("P", ""),
    entry("Q", ""),
    entry("R", "rant"),
    entry("S", "stylish"),
    entry("T", "turn"),
    entry("U", ""),
    entry("V", ""),
    entry("W", "weird"),
    entry("X", ""),
    entry("Y", ""),
    entry("Z", "")
  );

  public static String makeBackronym(String acronym) {
    var resultBuilder = new StringBuilder();
    for (int i = 0; i < acronym.length(); ++i) {
      resultBuilder.append(dictionary.get(String.valueOf(toUpperCase(acronym.charAt(i)))));
      if (i < acronym.length() - 1) {
        resultBuilder.append(" ");
      }
    }
    return resultBuilder.toString();
  }

  public static String makeBackronymBestPractices(String acronym) {
    return acronym.toUpperCase().chars().mapToObj(i -> dictionary.get("" + (char)i)).collect(Collectors.joining(" "));
  }

}