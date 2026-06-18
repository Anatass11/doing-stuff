package my.sg2048.game.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Row {
    private List<Cell> row;
    private int size;

    public Row(int size) {
        this.size = size;
        this.row = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            this.row.add(new Cell(0));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(Cell i : row){
            sb.append(i);
            sb.append(" ".repeat(Math.max(0, 4 - i.toString().length())));
            sb.append(" | ");
        }
        sb.delete(sb.length()-3 ,sb.length()-1);
        sb.append("]");
        return sb.toString();
    }
}
