package boardgame;

import java.util.List;

public class Board {
    private List<Integer> squares;

    public Board(List<Integer> squares) {
        this.squares = squares;
    }

    public int getSize() {
        return squares.size();
    }

    public int getValueAt(int position) {
        return squares.get(position);
    }
}
