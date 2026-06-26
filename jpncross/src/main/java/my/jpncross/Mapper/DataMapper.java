package my.jpncross.Mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import my.jpncross.obj.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DataMapper {

    public List<Data> convertStringToData(String string){
        List<Data> data = new ArrayList<Data>();
        List<String> splitData = Arrays.stream(string.split(";")).toList();
        for(String mergedData : splitData){
            data.add(new Data(Arrays.stream(mergedData.split("|"))
                    .map(Integer::parseInt)
                    .toList()));
        }
        return data;
    }
}
