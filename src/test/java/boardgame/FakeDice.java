package boardgame;

import java.util.Iterator;
import java.util.List;

// 테스트를 위한 FakeDice 클래스: Dice 클래스를 확장하여 예측 가능한 주사위 값을 제공합니다.
class FakeDice extends Dice {
    private Iterator<Integer> values;

    // 미리 지정된 주사위 값 리스트를 받아 Iterator를 초기화합니다.
    public FakeDice(List<Integer> values) {
        this.values = values.iterator();
    }

    // 다음 값이 있으면 해당 값을 반환하고, 없으면 기본값 1을 반환합니다.
    @Override
    public int roll() {
        if (values.hasNext()) {
            return values.next();
        }
        return 1; // 더 이상 값이 없을 경우 기본값 1 반환
    }
}
