import it.project.secondweek.model.*;
import it.project.secondweek.strategy.IntensiveAttack;
import it.project.secondweek.strategy.IntensiveDefence;
import it.project.secondweek.strategy.StrategicAttack;
import it.project.secondweek.strategy.StrategicDefence;

import java.util.Random;

public class Program {

    public static void main(String[] args) {
        Player playerLeft1 = new Player(Position.LEFT, new IntensiveAttack(), new IntensiveDefence());
        Player playerRight1 = new Player(Position.RIGHT, new StrategicAttack(), new StrategicDefence());
        Player playerLeft2 = new Player(Position.LEFT, new IntensiveAttack(), new IntensiveDefence());
        Player playerRight2 = new Player(Position.RIGHT, new StrategicAttack(), new StrategicDefence());

        Team teamOne = new Team(playerLeft1, playerRight1);
        Team teamTwo = new Team(playerLeft2, playerRight2);

        Match match = new Match(teamOne, teamTwo);

        Team currentTeam = match.getRandomTeam();
        Player currentPlayer = currentTeam.getRandomPlayer();
        boolean win = false;
        attack(currentPlayer, currentTeam, match);
        int a = 0;
        while(!win){
            currentTeam = match.getOtherTeam(currentTeam);//change team
            currentPlayer = currentTeam.getRandomPlayer();
            defence(currentPlayer, currentTeam, match);
            attack(currentPlayer, currentTeam, match);
            if(a==0){
                currentTeam.getRightPlayer().becameAggressive();
                match.getOtherTeam(currentTeam).getLeftPlayer().becameStrategic();
                match.getOtherTeam(currentTeam).getRightPlayer().becameStrategic();
                a=1;
            }
            if(match.getTeam1().getPoints()==21 || match.getTeam2().getPoints()==21){
                win = true;
            }
        }
        //add for the master
        currentTeam.getRightPlayer().becameAggressive();
        match.getOtherTeam(currentTeam).getLeftPlayer().becameStrategic();
        match.getOtherTeam(currentTeam).getRightPlayer().becameStrategic();

        currentTeam.getRightPlayer().becameAggressive();
        match.getOtherTeam(currentTeam).getLeftPlayer().becameStrategic();
        match.getOtherTeam(currentTeam).getRightPlayer().becameStrategic();



        /*random number per scegliere quale team comincia,
          random number per decidere quale dei due player attacca per primo.
        Ciclo -> giocatore random dell'altro team esegue defend() e in seguito attack()
                [cambia team, loop finché non si raggiungono 21 punti].
        Quando uno dei due team supera (>) 15 punti PER PRIMO anche il giocatore di destra diventa aggressive,
        mentre l'altro team diventa interamente strategic. (Accade solo una volta) */



    }

    private static void defence(Player currentPlayer, Team currentTeam, Match match) {
        int res = currentPlayer.defence();
        if(res == 1){
            currentTeam.addPoints();
        } else if (res == -1) {
            match.getOtherTeam(currentTeam).addPoints();
        }
    }
    //le funzioni sono quasi identiche ( a parte l'uso dei metodi defence e attack ), come potrei "unirle"?
    private static void attack(Player currentPlayer, Team currentTeam, Match match) {
        int res = currentPlayer.attack();
        if(res == 1){
            currentTeam.addPoints();
        } else if (res == -1) {
            match.getOtherTeam(currentTeam).addPoints();
        }
    }

    /*private static Team changeTeam(Match match, Team currentTeam) {
        if(currentTeam == match.getTeam1()){
            return match.getTeam2();
        }
         else{
            return match.getTeam1();
         }

    }*/ //non serve più

    


}
