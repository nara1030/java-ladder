package ladder.domain;

import ladder.exception.InvalidNameOfReulstException;
import ladder.exception.InvalidNumberOfResultException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameResult {
    private final String[] input;
    private final List<Integer> result;

    public GameResult(String[] inputs, Participants participants) {
        validateNumberOfResult(inputs, participants);
        validateNameOfResult(inputs);
        this.input = inputs;
        result = new ArrayList<>();
    }

    private void validateNumberOfResult(String[] inputs, Participants participants) {
        if (inputs.length != participants.getNumberOfParticipants()) {
            throw new InvalidNumberOfResultException(inputs.length, participants.getNumberOfParticipants());
        }
    }

    private void validateNameOfResult(String[] inputs) {
        for (String input : inputs) {
            validateNameOfResult(input);
        }
    }

    private void validateNameOfResult(String input) {
        if (input.length() == 0) {
            throw new InvalidNameOfReulstException(input);
        }
    }

    void save(int indexOfParticipants, int result) {
        this.result.add(indexOfParticipants, result);
    }

    int getNumberOfResults() {
        return input.length;
    }

    public List<String> getInputOfResults() {
        return Arrays.asList(input);
    }

    public String getResultOfGame(int index) {
        return input[result.get(index)];
    }
}
