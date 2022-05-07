package ladder.domain;

import ladder.domain.strategy.RandomTrueCondition;
import ladder.domain.strategy.TrueCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final int CONSTANT_TO_CONVERT_COUNT_OF_PERSON_TO_COUNT_OF_LINE = 1;

    private final List<Boolean> line = new ArrayList<>();

    public Line(int countOfPerson) {
        line.add(0, createTrueOrFalse(new RandomTrueCondition()));
        for (int i = 1; i < countOfPerson - CONSTANT_TO_CONVERT_COUNT_OF_PERSON_TO_COUNT_OF_LINE; i++) {
            addValueComparedToPreviousValue(line.get(i - 1));
        }
    }

    Boolean addValueComparedToPreviousValue(Boolean previousValue) {
        if (previousValue == false) {
            Boolean currentValue = createTrueOrFalse(new RandomTrueCondition());
            line.add(currentValue);
            return currentValue;
        }
        line.add(false);
        return false;
    }

    static boolean createTrueOrFalse(TrueCondition trueCondition) {
        return trueCondition.isTrue();
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(line);
    }

    @Override
    public String toString() {
        return line.toString();
    }
}
