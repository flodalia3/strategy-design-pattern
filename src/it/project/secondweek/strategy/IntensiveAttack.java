package it.project.secondweek.strategy;

import java.util.Random;

public class IntensiveAttack implements AttackStrategy {
    private Random random = new Random();
    @Override
    public int attack() {

        int value = random.nextInt(3);
        if(value == 0 || value == 1){
            return 1; //fa punto
        }else{
            return -1;  //concede punto
        }
    }
}
