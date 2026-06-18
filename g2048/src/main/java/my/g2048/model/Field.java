package my.sg2048.game.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Field {
    private final List<Row> field;
    private final int size;

    public Field(int size) {
        this.size = size;
        this.field = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            this.field.add(new Row(size));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            sb.append(field.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
