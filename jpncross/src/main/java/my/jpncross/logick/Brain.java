package my.jpncross.logick;

import my.jpncross.Mapper.DataMapper;
import my.jpncross.obj.Cord;
import my.jpncross.obj.Data;
import my.jpncross.obj.Table;

import java.util.List;

public class Brain {
    private Table table;

    private InitInfo initInfo;
    private Solver solver;

    public Brain(String cols, String rows) {
        DataMapper mapper = new DataMapper();
        List<Data> dataCols = mapper.convertStringToData(cols);
        List<Data> dataRows = mapper.convertStringToData(rows);
        validate(dataCols, dataRows);
        this.initInfo = new InitInfo(dataRows, dataCols);
        this.solver = new Solver();
    }

    public Table start(){
        show();
        checkGarant();
        show();
        return table;
    }

    public void show(){
        System.out.println(this.table);
    }

    private void garant(Cord x, Cord y){
        this.table.setCell(x, "O");
        if(x.getX() == y.getX() && x.getY() == y.getY()){
            return;
        }
        else if(x.getX() == y.getX()){
            if(x.getY() > y.getY()){
                x.setY(x.getY() - 1);
            }
            else {
                x.setY(x.getY() + 1);
            }
        }
        else if(x.getY() == y.getY()){
            if(x.getX() > y.getX()){
                x.setX(x.getX() - 1);
            }
            else {
                x.setX(x.getX() + 1);
            }
        }
        garant(x, y);
    }

    private void checkGarant(){
        for (int i=0; i < this.table.getCols().size(); i++){
            if(this.table.getCols().get(i).sum() == this.table.getCols().size()){
                garant(new Cord(0, i), new Cord(this.table.getRows().size()-1, i));
            }
        }
        for (int i=0; i < this.table.getRows().size(); i++){
            if(this.table.getRows().get(i).sum() == this.table.getRows().size()){
                garant(new Cord(i, 0), new Cord(i, this.table.getCols().size()-1));
            }
        }
    }

    private void validate(List<Data> dataCols, List<Data> dataRows){
        if(!dataCols.stream().map(Data::sum).reduce(0, Integer::sum).equals(dataRows.stream().map(Data::sum).reduce(0, Integer::sum))){
            throw new RuntimeException("Data of Rows and Cols do not match");
        }
    }
}
