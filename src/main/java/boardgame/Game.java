package boardgame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int turns;
    private Dice dice;
    private OutputHandler outputHandler;

    public Game(Board board, List<Player> players, int turns, OutputHandler outputHandler) {
        this.board = board;
        this.players = players;
        this.turns = turns;
        this.outputHandler = outputHandler;
        this.dice = new Dice();
    }

    public void start() {
        for (int turn = 1; turn <= turns; turn++) {
            outputHandler.printTurnHeader(turn);
            for (Player player : players) {
                // 1. 주사위를 굴린다
                // 2. 플레이어를 움직인다
                // 3. 이번 턴의 결과를 출력한다 - OutputHandler 오브젝트의 printPlayerTurn() 메서드를 이용
            }
        }
        displayWinner();
    }

    public List<String> calculateWinners() {
        int maxScore = Integer.MIN_VALUE;
        // 최고점을 구한다

        // 우승자 리스트를 만든다

        // 우승자 리스트를 return한다
        return List.of();
    }

    private void displayWinner() {
        List<String> winners = calculateWinners();
        outputHandler.printGameOver();
        outputHandler.printWinner(winners);
    }
}
