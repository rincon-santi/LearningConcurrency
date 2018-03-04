/*
 Ok, ok, I get it. Lesson1 was boring. All what we have done is throwing a big
number of threads and watch them die in desperation. Without doing anything at
all.

 Now we are gonna raise the stakes, we have THE MAFIA with us. The Godfather has
invented a game to make their goonies improve their habilities. There is two
bank accounts: team1's and team2's. Goonies of team1 are going to steal 1 from
the team2's account and put it in their own account and vice-versa. There will
be the exact same number of goonies in team1 and team2 so it's easy to deduce
that after the game, both accounts will have the same money still. But the point
is they won't.

 Why? Concurrency is to blame, we are gonna build the code without taking count
that there are different threads trying to get to the same global variables (the
accounts), so it's possible for 2 of them to get at the same time and "steal the
same coin", or saving it at the same time or... So, what we are going to do for
real is proving why it's very very important to separate and atomize (an atom is
an action that MUST be done only one at a time and can't be interrupted) the
critical sections of the code. How to do such is for another lesson. So let's go
with the mafia.
 */
package lesson2_ThreadsCompetition;

/**
 *
 * @author Santiago Rincón Martínez
 */
public class TheGodfather {
    private final int _N;
    private Goonie [] _team1;
    private Goonie [] _team2;
    private int _team1account;
    private int _team2account;
    
    public TheGodfather (int N){
        _N=N;
        _team1 = new Goonie[_N];
        _team2 = new Goonie[_N];
        _team1account=_N;
        _team2account=_N;
    }
    @SuppressWarnings("empty-statement") //to avoid warnings in the livechecking
    public void create(){
        for (int i=0; i<_N; i++){ //the Godfather makes the teams. There are the same number of goonies in both of them.
            _team1[i]=new Goonie("team1number"+i, 1, this);
            _team2[i]=new Goonie("team2number"+i, 2, this);
        }
        System.out.println("TEAM1 ACCOUNT: "+_team1account); //starting of the game
        System.out.println("TEAM2 ACCOUNT: "+_team2account);
        System.out.println("GO!");
        for (int i=0; i<_N; i++){   //the teams start to play
            _team1[i].start();
            _team2[i].start();
        }
        for (int i=0; i<_N; i++){   //the Godfather checks all goonies have finished
            while (_team1[i].isAlive() || _team2[i].isAlive());
        }
        System.out.println("TEAM1 ACCOUNT: "+_team1account); //results of the game
        System.out.println("TEAM2 ACCOUNT: "+_team2account);
        System.out.println("IT'S OVER!");
    }
    
    public void stealFromAccount(int i){ //to steal
        switch(i){
            case 1:
                _team1account--;
                break;
            case 2:
                _team2account--;
                break;
            default:
                System.out.println("Something, somewhere, went wrong");
        }
    }
    
    public void putInAccount(int i){ //to let in account
        switch(i){
            case 1:
                _team1account++;
                break;
            case 2:
                _team2account++;
                break;
            default:
                System.out.println("Something, somewhere, went wrong");
        }
    }
}