package boardgame;

import java.util.List;

public class OutputHandler {

    public void printTurnHeader(int turn) {
        System.out.println("\n--- 턴 " + turn + " ---");
    }

    public void printPlayerTurn(String playerName, int diceValue, int position, int boardValue, int score) {
        System.out.println(playerName + "는 주사위 " + diceValue
                + "를 굴려 " + position + "번 인덱스에 있는 값 " + boardValue
                + "에 도착했습니다. (누적 점수: " + score + ")");
    }

    public void printGameOver() {
        System.out.println("\n게임 종료!");
    }

    public void printWinner(List<String> winners) {
        if (winners.size() > 1) {
            System.out.println("우승자는 공동 우승입니다! (공동 우승: " + String.join(", ", winners) + ")");
        } else if (winners.size() == 1) {
            System.out.println("우승자는 " + winners.get(0) + "입니다! 🎉");
        } else {
            System.out.println("우승자가 없습니다.");
        }
    }
}
