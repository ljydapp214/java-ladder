package laddergame.domain;

import laddergame.exception.CustomException;
import laddergame.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    public static final String EXIST_TRUE_REPETITION = "연속된 사다리가 존재 합니다.";

    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPeople, LineStrategy lineStrategy) {
        initLine(widthOfLadder(countOfPeople), lineStrategy);
        validateTrueRepetition(points);
    }

    private int widthOfLadder(int countOfPeople) {
        return countOfPeople - 1;
    }

    private void initLine(int widthOfLadder, LineStrategy lineStrategy) {
        for (int i = 0; i < widthOfLadder; i++) {
            points.add(lineStrategy.create());
        }
    }

    private void validateTrueRepetition(List<Boolean> points) {
        for (int i = 0; i < points.size()-1; i++) {
            boolean currentValue = points.get(i);
            boolean afterValue = points.get(i + 1);

            checkTrueRepetition(currentValue, afterValue);
        }
    }

    private void checkTrueRepetition(boolean beforeValue, boolean currentValue) {
        if (beforeValue && currentValue) {
            throw new CustomException(EXIST_TRUE_REPETITION);
        }
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}