package ladder.domain;

import ladder.Lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participant {

    public static final int MAX_NAME_LENGTH = 5;
    private final List<String> names;

    public Participant(String inputText) {
        this(Arrays.asList(inputText.split(",")));
    }

    public Participant(List<String> names) {
        names.forEach(name -> Lambda.validateLength(name, MAX_NAME_LENGTH, (text, number) -> text.length() > number));
        this.names = names;
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }

}
