package experiment.backronym_micro_benchmark;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.function.UnaryOperator;

import org.junit.jupiter.api.Test;

class BackronymTest {

  @Test
  void testBackronym() {
    assertMakeBackronymWorks(Backronym::makeBackronym);
  }

  @Test
  void testBackronymBestPractices() {
    assertMakeBackronymWorks(Backronym::makeBackronymBestPractices);
  }

  private static void assertMakeBackronymWorks(UnaryOperator<String> makeBackronym) {
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

}