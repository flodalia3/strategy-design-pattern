package it.project.secondweek.model;

import it.project.secondweek.strategy.*;

public class Player {
    private Position pos;
    private AttackStrategy strAttack;
    private DefenceStrategy strDefence;

    public Player(Position pos, AttackStrategy attack, DefenceStrategy defence){
            this.pos = pos;
            this.strAttack = attack;
            this.strDefence = defence;
    }

    public void setStrAttack(AttackStrategy strAttack){
        this.strAttack = strAttack;
    }

    public void setStrDefence(DefenceStrategy strDefence){
        this.strDefence = strDefence;
    }

    public int attack(){
        return this.strAttack.attack();
    }

    public int defence(){
        return this.strDefence.defence();
    }


    public void becameAggressive() {
        this.setStrAttack(new IntensiveAttack());
        this.setStrDefence(new IntensiveDefence());
    }

    public void becameStrategic(){
        this.setStrAttack(new StrategicAttack());
        this.setStrDefence(new StrategicDefence());
    }
}
