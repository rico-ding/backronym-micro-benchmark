package experiment.backronym_micro_benchmark;

import static java.lang.Character.toUpperCase;

import java.util.Map;
import java.util.stream.Collectors;

public class Backronym {

  private static final Map<String, String> dictionary = Preload.dictionary;

  private Backronym() {
  }

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
    return acronym.toUpperCase().chars().mapToObj(i -> dictionary.get("" + (char) i)).collect(Collectors.joining(" "));
  }

}
