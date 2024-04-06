package ladder.domain.Ladder;

import ladder.domain.Ladder.factory.PointFactory;
import ladder.utils.LambdaUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private final List<Point> points;

    public Line(int countOfPerson, PointPredicate pointPredicate) {
        this(PointFactory.generatePoints(countOfPerson, pointPredicate));
    }

    public Line(Boolean... points) {
        this(PointFactory.generatePoints(points));
    }

    public Line(List<Point> points) {
        validatePoints(points);
        this.points = points;
    }

    private static void validatePoints(List<Point> points) {
        IntStream.range(0, points.size() - 1)
                .forEach(num -> LambdaUtils.validatePointRule(points.get(num), points.get(num + 1), Point::isEqualToTrue));
    }

    public List<Boolean> getLine() {
        return this.points.stream()
                .map(Point::isMovable)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean canMove(int positionIndex) {
        if (positionIndex < 0 || positionIndex >= points.size()) {
            return false;
        }
        return points.get(positionIndex).isMovable();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
