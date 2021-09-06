package ladderrefactoring.domain.datas;

import ladderrefactoring.domain.data.Person;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class People {

    private final List<Person> people;

    public People(List<String> peopleString) {
        this.people = peopleString.stream()
                .map(Person::new)
                .collect(Collectors.toList());;
    }

    public boolean isSameSizeAs(int size) {
        return people.size() == size;
    }

    public int subtractNumberFromSize(int number) {
        return people.size() - number;
    }

    public List<Person> people() {
        return Collections.unmodifiableList(people);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;
        People people1 = (People) o;
        return Objects.equals(people, people1.people);
    }

    @Override
    public int hashCode() {
        return Objects.hash(people);
    }
}