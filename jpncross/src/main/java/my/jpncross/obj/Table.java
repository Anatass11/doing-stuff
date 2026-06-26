package my.jpncross.obj;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Table {
    private List<Data> cols;
    private List<Data> rows;

    public List<List<String>> table;

    public Table(List<Data> cols, List<Data> rows) {
        this.cols = cols;
        this.rows = rows;
        this.table = new ArrayList<List<String>>();
        for(int i = 0; i < rows.size(); i++){
            this.table.add(new ArrayList<>());
            for(int j = 0; j < cols.size(); j++){
                this.table.get(i).add(" ");
            }
        }
    }

    public String getCell(Cord cell){
        return this.table.get(cell.getX()).get(cell.getY());
    }

    public void setCell(Cord cell, String value){
        this.table.get(cell.getX()).set(cell.getY(), value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<String> row : this.table) {
            sb.append("[");
            for (String cell : row) {
                sb.append(cell).append("|");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]\n");
        }
        return sb.toString();
    }


}
