package boardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public Board readBoard() {
        System.out.print("게임판에 들어갈 숫자들을 공백으로 구분하여 입력하세요: ");
        String boardLine = scanner.nextLine();
        String[] tokens = boardLine.trim().split("\\s+");
        List<Integer> boardNumbers = new ArrayList<>();
        for (String token : tokens) {
            boardNumbers.add(Integer.parseInt(token));
        }
        return new Board(boardNumbers);
    }

    public List<Player> readPlayers() {
        System.out.print("플레이어 수를 입력하세요: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // 개행문자 제거
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("플레이어 " + i + " 이름: ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }
        return players;
    }

    public int readTurns() {
        System.out.print("몇 턴을 진행하시겠습니까? ");
        int turns = scanner.nextInt();
        scanner.nextLine();  // 버퍼 정리
        return turns;
    }

    public void close() {
        scanner.close();
    }
}
