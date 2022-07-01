package it.project.secondweek.model;

import java.util.Random;

public class Match {
    Team team1;
    Team team2;

    public Match(Team team1, Team team2){
        this.team1=team1;
        this.team2=team2;
    }


    public Team getTeam1(){
        return this.team1;
    }

    public Team getTeam2(){
        return this.team2;
    }

    public Team getRandomTeam(){
        Random random = new Random();
        int res = random.nextInt(2);
        if(res == 0){
            return this.team1;
        }
        else{
            return this.team2;
        }
    }

    public Team getOtherTeam(Team currentTeam){
        if(currentTeam == this.team1){
            return this.team2;
        }else{
            return this.team1;
        }

    }
}
