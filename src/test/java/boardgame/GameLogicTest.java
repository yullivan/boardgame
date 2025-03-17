package boardgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

// 게임의 핵심 로직—플레이어 이동, 점수 누적 및 우승자 계산을 검증하는 테스트 클래스
public class GameLogicTest {

    // 플레이어의 이동 및 점수 누적을 검증하는 테스트
    @Test
    void testPlayerMovementAndScore() {
        // 인덱스 0:2, 1:4, 2:6, 3:8인 값을 가진 보드 생성
        Board board = new Board(Arrays.asList(2, 4, 6, 8));
        Player player = new Player("Alice");

        // 첫 번째 이동: 주사위 값 3 → 인덱스 3, board[3]=8, 누적 점수 8
        player.move(3, board);
        assertEquals(3, player.getPosition(), "플레이어의 위치는 3이어야 합니다.");
        assertEquals(8, player.getScore(), "플레이어의 점수는 8이어야 합니다.");

        // 두 번째 이동: 주사위 값 2 → (3+2)%4 = 1, board[1]=4, 누적 점수 8+4=12
        player.move(2, board);
        assertEquals(1, player.getPosition(), "플레이어의 위치는 1이어야 합니다.");
        assertEquals(12, player.getScore(), "플레이어의 점수는 12이어야 합니다.");
    }

    // 우승자 계산 로직을 단독으로 검증하는 테스트: 단일 우승자 케이스
    @Test
    void testCalculateWinnersSingle() throws Exception {
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");
        // alice의 점수를 15, bob의 점수를 10으로 설정
        setPlayerScore(alice, 15);
        setPlayerScore(bob, 10);
        // 빈 보드와 더미 OutputHandler (출력은 테스트 대상이 아님)
        Board board = new Board(Arrays.asList(1, 2, 3, 4));
        OutputHandler dummyOutput = new OutputHandler() {
            @Override
            public void printTurnHeader(int turn) {
            }

            @Override
            public void printPlayerTurn(String playerName, int diceValue, int position, int boardValue, int score) {
            }

            @Override
            public void printGameOver() {
            }

            @Override
            public void printWinner(List<String> winners) {
            }
        };
        // 게임 인스턴스 생성 (턴 수는 상관없음)
        Game game = new Game(board, Arrays.asList(alice, bob), 0, dummyOutput);

        List<String> winners = game.calculateWinners();
        assertEquals(1, winners.size(), "우승자는 한 명이어야 합니다.");
        assertEquals("Alice", winners.get(0), "우승자는 Alice여야 합니다.");
    }

    // 우승자 계산 로직을 단독으로 검증하는 테스트: 공동 우승 케이스
    @Test
    void testCalculateWinnersTie() throws Exception {
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");
        Player charlie = new Player("Charlie");
        // alice, bob, charlie의 점수를 모두 20으로 설정
        setPlayerScore(alice, 20);
        setPlayerScore(bob, 20);
        setPlayerScore(charlie, 20);
        // 빈 보드와 더미 OutputHandler (출력은 테스트 대상이 아님)
        Board board = new Board(Arrays.asList(1, 2, 3, 4));
        OutputHandler dummyOutput = new OutputHandler() {
            @Override
            public void printTurnHeader(int turn) {
            }

            @Override
            public void printPlayerTurn(String playerName, int diceValue, int position, int boardValue, int score) {
            }

            @Override
            public void printGameOver() {
            }

            @Override
            public void printWinner(List<String> winners) {
            }
        };
        Game game = new Game(board, Arrays.asList(alice, bob, charlie), 0, dummyOutput);

        List<String> winners = game.calculateWinners();
        assertEquals(3, winners.size(), "모든 플레이어가 공동 우승해야 합니다.");
        assertTrue(winners.containsAll(Arrays.asList("Alice", "Bob", "Charlie")), "우승자 목록에 모든 플레이어가 포함되어야 합니다.");
    }

    // 플레이어의 private score 필드에 값을 강제로 설정하기 위한 헬퍼 메서드
    private void setPlayerScore(Player player, int score) throws Exception {
        Field scoreField = Player.class.getDeclaredField("score");
        scoreField.setAccessible(true);
        scoreField.set(player, score);
    }
}
