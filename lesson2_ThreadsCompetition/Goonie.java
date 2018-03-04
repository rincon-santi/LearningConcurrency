/*
 This is the class that represents the goonies. They know what team is theirs
and, in execution, steal 1 from the enemy's account and put 1 on their own.

 Note there isn't any mechanism to ensure stealing or putting is an atomic
action.
 */
package lesson2_ThreadsCompetition;

/**
 *
 * @author Santiago Rincón Martínez
 */
public class Goonie extends Thread{
    private final String _name;
    private final TheGodfather _father;
    private final int _team;
    
    public Goonie(String name, int team, TheGodfather father){
        _name=name;
        _father=father;
        _team=team;
    }
    @Override
    public void run(){
        int aux=3;
        switch(_team){
            case 1:
                aux=2;
                break;
            case 2:
                aux=1;
                break;
        }
        _father.stealFromAccount(aux);
        _father.putInAccount(_team);
    }
}
