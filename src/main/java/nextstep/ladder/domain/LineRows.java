package nextstep.ladder.domain;

import nextstep.ladder.domain.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LineRows {

    private final List<ConnectionStatus> connectionStatuses;

    private LineRows(List<ConnectionStatus> connectionStatuses) {
        this.connectionStatuses = connectionStatuses;
    }

    public static LineRows initialize(int userCount, BooleanGenerator booleanGenerator) {
        LineRows lineRows = new LineRows(new ArrayList<>());
        IntStream.range(0, userCount - 1)
                .forEach(index -> lineRows.addConnect(index, booleanGenerator));
        return lineRows;
    }

    private void addConnect(int index, BooleanGenerator booleanGenerator) {
        if (isNotAddableTrue(index)) {
            connectionStatuses.add(new ConnectionStatus(false));
            return;
        }
        connectionStatuses.add(new ConnectionStatus(booleanGenerator.getBoolean()));
    }

    private boolean isNotAddableTrue(int index) {
        return index != 0 && getConnectionStatus(index - 1).isConnected();
    }

    private ConnectionStatus getConnectionStatus(int index) {
        return connectionStatuses.get(index);
    }

    public List<ConnectionStatus> getConnectionStatuses() {
        return connectionStatuses;
    }

    @Override
    public String toString() {
        return "\nLineRows{" +
                "connectionStatuses=" + connectionStatuses +
                '}';
    }

}
