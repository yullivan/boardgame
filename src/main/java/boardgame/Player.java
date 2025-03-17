package boardgame;

public class Player {
    private final String name;
    private int position;
    private int score;

    public Player(String name) {
        this.name = name;
        this.position = 0;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }

    public void move(int diceValue, Board board) {
        // 새로운 위치를 계산해서 플레이어의 위치를 변경한다
        // 새로운 위치에 해당하는 점수를 구한다
        // 새로운 위치에 해당하는 점수를 플레이어 점수에 누적하여 더한다
    }
}
