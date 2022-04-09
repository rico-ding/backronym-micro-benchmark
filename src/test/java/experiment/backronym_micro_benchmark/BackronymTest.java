package experiment.backronym_micro_benchmark;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class BackronymTest {

  private static final Random RAND = new Random();

  @Test
  void testFixedStrings1() {
    assertFixedStringsWork(Backronym::makeBackronym);
  }

  @Test
  void testFixedStrings2() {
    assertFixedStringsWork(Backronym::makeBackronymBestPractices);
  }

  @Test
  void testRandomStrings1() {
    assertRandomStringsWork(Backronym::makeBackronym);
  }

  @Test
  void testRandomStrings2() {
    assertRandomStringsWork(Backronym::makeBackronymBestPractices);
  }

  @Test
  void testExamples1() {
    assertExamplesWork(Backronym::makeBackronym);
  }

  @Test
  void testExamples2() {
    assertExamplesWork(Backronym::makeBackronymBestPractices);
  }

  private static void assertFixedStringsWork(UnaryOperator<String> makeBackronym) {
    runTest(makeBackronym, "adh", "awesome disturbing hippy");
    runTest(makeBackronym, "lmnop", "literal mustache newtonian oscillating perfect");
    runTest(makeBackronym, "wyv", "weird yogic volcano");
    runTest(makeBackronym, "privet", "perfect rant ingestable volcano eager turn");
    runTest(makeBackronym, "paka", "perfect awesome klingon awesome");
    runTest(makeBackronym, "", "");
    runTest(makeBackronym, "ppp", "perfect perfect perfect");
    runTest(
      makeBackronym,
      "abcdefghijklmnopqrstuvwxyz",
      "awesome beautiful confident disturbing eager fantastic gregarious hippy ingestable joke klingon literal mustache newtonian oscillating perfect queen rant stylish turn underlying volcano weird xylophone yogic zero"
    );
  }

  private static void assertRandomStringsWork(UnaryOperator<String> makeBackronym) {
    String base = "abcdefghijklmnopqrstuvwxyz";

    base = base + base.toUpperCase();
    for (int i = 0; i < 20; i++) {
      int length = randRange(5, 20);
      String test = "";
      for (int j = 0; j < length; j++) {
        test += "" + base.charAt(RAND.nextInt(base.length()));
      }
      runTest(makeBackronym, test, known(test));
    }
  }

  private static void assertExamplesWork(UnaryOperator<String> makeBackronym) {
    assertThat(
      makeBackronym.apply("dgm"),
      is("disturbing gregarious mustache")
    );
    assertThat(
      makeBackronym.apply("lkj"),
      is("literal klingon joke")
    );
    assertThat(
      makeBackronym.apply("interesting"),
      is("ingestable newtonian turn eager rant eager stylish turn ingestable newtonian gregarious")
    );
    assertThat(
      makeBackronym.apply("codewars"),
      is("confident oscillating disturbing eager weird awesome rant stylish")
    );
  }

  private static void runTest(UnaryOperator<String> makeBackronym, String acronym, String expected) {
    String actual = makeBackronym.apply(acronym);
    String msg = "Ran " + acronym + ", expected " + expected + ", but got: " + actual;
    assertThat(msg, actual, is(expected));
  }

  private static int randRange(int from, int to) {
    return RAND.nextInt(to - from) + from;
  }

  private static String known(String acronym) {
    List<String> translations = acronym.chars()
      .mapToObj(c -> (char) c)
      .map(c -> Character.toString(c))
      .map(String::toUpperCase)
      .map(s -> Preload.dictionary.get(s))
      .collect(Collectors.toList());
    return String.join(" ", translations);
  }

}