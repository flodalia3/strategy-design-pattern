package it.project.secondweek.strategy;

import java.util.Random;

public class StrategicAttack implements AttackStrategy{
    Random random = new Random();
    @Override
    public int attack() {
        int value = random.nextInt(3);
        if(value == 0 || value == 1){
            return 0; //nessun effetto
        }else{
            return 1;  //fa punto
        }
    }
}
