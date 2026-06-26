package my.g2048.services;

import lombok.Getter;
import my.g2048.model.Cell;
import my.g2048.model.Field;
import my.g2048.model.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class FieldService {

    private Field field;
    private int size;

    private RowService rowService;

    @Autowired
    public FieldService(RowService rowService) {
        this.rowService = rowService;
        this.field = new Field(10);
        this.size = 10;
    }

    public Field init(){
        for(int i = 0; i < size/2; i++){
            for(int j = 0; j < size/2; j++){
                 field.getField().get(i).getRow().set(j, new Cell(1024));
            }
        }
        return getField();
    }

    public Field moveRight(){
        for (int i = 0; i < size; i++) {
            rowService.moveRight(field.getField().get(i));
        }
        return getField();
    }

    public Field moveLeft(){
        for (int i = 0; i < size; i++) {
            rowService.moveLeft(field.getField().get(i));
        }
        return getField();
    }

    public Field moveUp(){
        for (int i = 0; i < size; i++) {
            rowService.moveLeft(formColumn(i));
        }
        return getField();
    }

    public Field moveDown(){
        for (int i = 0; i < size; i++) {
            rowService.moveRight(formColumn(i));
        }
        return getField();
    }

    private Row formColumn(int i) {
        Row row = new Row(size);
        for (int j = 0; j < size; j++) {
            row.getRow().set(j, field.getField().get(j).getRow().get(i));
        }
        return row;
    }

}
