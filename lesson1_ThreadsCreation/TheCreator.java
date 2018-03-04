/*
 This class create some Threads from the type ImACreatedThread (also in this
package), then throws them and, when they all had been executed, says "MY JOB
HERE IS DONE" and closes, probably with some dramatic cloak movement, but we
can't see that.

 It's important to notice that, although we had coded a "run()" method in the
ImACreatedThreads, we invoke start(), not run(). That is because the Thread
heritage allow us to separate this methods.
 */
package lesson1_ThreadsCreation;

/**
 *
 * @author Santiago Rincón Martínez
 */
public class TheCreator {
    private final int _N;
    private ImACreatedThread [] _childhood;
    public TheCreator (int N){
        _N=N;
        _childhood = new ImACreatedThread[_N];
    }
    @SuppressWarnings("empty-statement") //to avoid warnings in the livechecking
    public void create(){
        for (int i=0; i<_N; i++){ //the Creator Creates threads
            _childhood[i]=new ImACreatedThread("number"+i);
        }
        for (int i=0; i<_N; i++){   //the Creator runs threads
            _childhood[i].start();
        }
        for (int i=0; i<_N; i++){   //the Creator checks all childhood is dead
            while (_childhood[i].isAlive());
        }
        System.out.println("MY JOB HERE IS DONE");
    }
}
