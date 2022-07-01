package it.project.secondweek.strategy;

import java.util.Random;

public class IntensiveDefence implements DefenceStrategy{
    Random random = new Random();
    @Override
    public int defence() {
        int value = random.nextInt(5);
        if(value == 0){
            return 1; //fa punto
        }
        if(value == 1 || value == 2){
            return -1;  //concede punto
        }else{
            return 0; //nulla
        }
    }
}
