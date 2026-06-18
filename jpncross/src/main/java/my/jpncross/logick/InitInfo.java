package my.jpnkross.logick;

import my.jpnkross.obj.Data;

import java.util.List;

public class InitInfo {
    private List<Data> rows;
    private List<Data> columns;

    public InitInfo(List<Data> rows, List<Data> columns) {
        this.rows = rows;
        this.columns = columns;
    }
}
