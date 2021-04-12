package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PersonTest {

  @Test
  void generate() {
    String name = "bong";
    Person person = Person.generate(name);
    assertEquals(person.getName(), name);
  }

  @Test
  void generate_fail_over_length() {
    String name ="bonggu";
    assertThatIllegalArgumentException()
        .isThrownBy(() -> Person.generate(name))
        .withMessage("name.length < 6");
  }
}