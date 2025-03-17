package boardgame;

import java.lang.reflect.Field;
import java.util.List;

// Game 클래스에서 사용하는 Dice 인스턴스를 테스트용 FakeDice로 주입하기 위한 TestableGame 클래스
public class TestableGame extends Game {
    public TestableGame(Board board, List<Player> players, int turns, OutputHandler outputHandler, Dice dice) {
        super(board, players, turns, outputHandler);
        try {
            // Game 클래스의 private dice 필드에 접근하여 테스트용 Dice 인스턴스로 변경합니다.
            Field diceField = Game.class.getDeclaredField("dice");
            diceField.setAccessible(true);
            diceField.set(this, dice);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
