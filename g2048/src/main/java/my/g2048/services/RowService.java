package my.sg2048.game.services;

import my.sg2048.game.model.Row;
import org.springframework.stereotype.Service;

@Service
public class RowService {

    public void moveRight(Row row){
        checkRight(row);
        for (int i = row.getSize() - 1; i >= 0; i--) {
            if(row.getRow().get(i).getX() == 0){
                for(int j = i - 1; j >= 0; j--){
                    if(row.getRow().get(j).getX() != 0){
                        move(row, j, i);
                        break;
                    }
                }
            }
        }
    }

    public void moveLeft(Row row){
        checkLeft(row);
        for (int i = 0; i < row.getSize(); i++) {
            if(row.getRow().get(i).getX() == 0){
                for(int j = i + 1; j < row.getSize(); j++){
                    if(row.getRow().get(j).getX() != 0){
                        move(row, j, i);
                        break;
                    }
                }
            }
        }
    }

    private void move(Row row, int producer, int consumer){
        row.getRow().get(consumer).setX(row.getRow().get(producer).getX());
        row.getRow().get(producer).setX(0);
    }

    private void checkRight(Row row){
        for (int i = row.getSize() - 1; i > 0; i--) {
            if(row.getRow().get(i).getX() == row.getRow().get(i - 1).getX()){
                row.getRow().get(i).setX(row.getRow().get(i - 1).getX() * 2);
                row.getRow().get(i - 1).setX(0);
            }
        }
    }

    private void checkLeft(Row row){
        for (int i = 0; i < row.getSize()-1; i++) {
            if(row.getRow().get(i).getX() == row.getRow().get(i + 1).getX()){
                row.getRow().get(i).setX(row.getRow().get(i + 1).getX() * 2);
                row.getRow().get(i + 1).setX(0);
            }
        }
    }

}
