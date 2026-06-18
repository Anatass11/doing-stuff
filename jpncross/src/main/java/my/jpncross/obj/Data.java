package my.jpnkross.obj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Data {
    private List<Integer> data;

    public int sum(){
        return data.stream().mapToInt(i -> i).sum();
    }
}
