package boardgame;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        // 사용자 입력 받기
        Board board = inputHandler.readBoard();
        List<Player> players = inputHandler.readPlayers();
        int turns = inputHandler.readTurns();

        // 게임 로직 처리
        Game game = new Game(board, players, turns, outputHandler);
        game.start();

        inputHandler.close();
    }

}
