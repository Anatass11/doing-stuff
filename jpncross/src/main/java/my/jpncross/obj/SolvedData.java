package my.jpncross.obj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SolvedData {
    private List<Line> lines;

    public int sum(){
        return lines.stream().map(Line::getLength).mapToInt(i -> i).sum();
    }
}
