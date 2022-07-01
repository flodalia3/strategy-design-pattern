package it.project.secondweek.model;

import java.util.Random;

public class Team {
    private Player leftPlayer;
    private Player rightPlayer;

    private int points;
   // private int points;

    public Team(Player leftPlayer, Player rightPlayer){
        this.leftPlayer = leftPlayer;
        this.rightPlayer = rightPlayer;
        this.points = 0;
    }

    public Player getLeftPlayer(){
        return this.leftPlayer;
    }

    public Player getRightPlayer(){
        return this.rightPlayer;
    }

    public int getPoints() {
        return this.points;
    }

    public void resetPoints(){
        this.points = 0;
    }

    public void addPoints(){
        this.points++;
    }

    public void removePoints(){
        this.points--;
    }

    // public void addPoints(){points++;}
    public Player getRandomPlayer(){
        Random random = new Random();
        int res = random.nextInt(2);
        if(res == 0){
            return this.leftPlayer;
        }
        else{
            return this.rightPlayer;
        }
    }



}
