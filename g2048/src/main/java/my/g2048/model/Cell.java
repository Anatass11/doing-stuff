package my.g2048.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private int x;

    public Cell(int x){
        this.x = x;
    }

    @Override
    public String toString() {
        return String.valueOf(x);
    }
}
