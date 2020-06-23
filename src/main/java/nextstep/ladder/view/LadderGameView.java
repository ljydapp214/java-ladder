package nextstep.ladder.view;

import nextstep.ladder.constant.LadderConstants;
import nextstep.ladder.domain.ExecutionResult;
import nextstep.ladder.domain.ExecutionResults;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.MountingBlock;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.PlayerName;
import nextstep.ladder.domain.Players;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LadderGameView {

    public static List<String> inputUserNames() {
        System.out.println(LadderConstants.USER_NAME_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String userNameInput = scanner.nextLine();
        System.out.println();
        return LadderGameViewHelper.parseInputWithComma(userNameInput);
    }

    public static List<String> inputExecutionResults() {
        System.out.println(LadderConstants.EXECUTION_RESULT_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String executionResult = scanner.nextLine();
        System.out.println();
        return LadderGameViewHelper.parseInputWithComma(executionResult);
    }

    public static Integer inputLadderHeight() {
        System.out.println(LadderConstants.LADDER_HEIGHT_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        System.out.println();
        return result;
    }

    public static void viewLadderShape(Ladder ladder) {
        System.out.println(LadderConstants.EXECUTION_LADDER_RESULT_MESSAGE);
        System.out.println();

        Players players = ladder.getPlayers();
        viewPlayers(players);
        Lines lines = ladder.getLines();
        viewLadder(lines);
        ExecutionResults executionResults = ladder.getExecutionResults();
        viewExecutionResults(executionResults);
        System.out.println();
    }

    private static void viewPlayers(Players players) {
        for (Player player : players.getPlayers()) {
            PlayerName leftPad = player.convertPlayerNameWithLeftPad();
            System.out.print(leftPad);
        }
        System.out.println();
    }

    private static void viewLadder(Lines lines) {
        for (Line line : lines.getLines()) {
            viewLine(line.getMountingBlocks());
        }
    }

    private static void viewExecutionResults(ExecutionResults executionResults) {
        for (ExecutionResult executionResult : executionResults.getExecutionResults()) {
            String leftPad = executionResult.convertExecutionResultWithLeftPad();
            System.out.print(leftPad);
        }
        System.out.println();
    }

    private static void viewLine(List<MountingBlock> mountingBlocks) {
        drawFirstHeight();
        IntStream.range(1, mountingBlocks.size() - 1).forEach(i -> {
            drawMountingBlock(mountingBlocks.get(i).getMountingBlock());
            System.out.print(LadderConstants.SHAPE_OF_HEIGHT);
        });

        System.out.println();
    }

    private static void drawFirstHeight() {
        System.out.print(StringUtils.leftPad(LadderConstants.SHAPE_OF_HEIGHT, LadderConstants.FIRST_HEIGHT_PADDING_VALUE));
    }

    private static void drawMountingBlock(Boolean mountingBlock) {
        if (mountingBlock) {
            System.out.print(LadderConstants.SHAPE_OF_MOUNTING_BLOCK);
            return;
        }

        System.out.print(LadderConstants.BLANK_MOUNTING_BLOCK);
    }

    public static String inputExecutionResultPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(LadderConstants.WHAT_YOU_WANT_TO_SEE_PLAYER_EXECUTION_RESULT);
        return scanner.nextLine();
    }

    public static void viewExecutionResult(ExecutionResult executionResult) {
        System.out.println();
        System.out.println(LadderConstants.EXECUTION_RESULT_MESSAGE);
        System.out.println(executionResult);
        System.out.println();
    }

    public static void viewAllExecutionResult(Player player, ExecutionResult executionResult) {
        System.out.println(player + " : " + executionResult);
    }
}
