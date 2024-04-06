package ladder.domain.result.factory;

import ladder.domain.result.Reward;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResultFactory {

    private GameResultFactory() {
    }

    public static List<Reward> createRewards(String[] items) {
        return IntStream.range(0, items.length)
                .mapToObj(i -> new Reward(items[i], i))
                .collect(Collectors.toList());
    }
}
