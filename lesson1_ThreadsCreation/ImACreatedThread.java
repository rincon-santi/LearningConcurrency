/*
 This is a thread class to be created and runned. It tells us when is created
and runned. And when dies. While complaining about futility of life.

 The interesting part (unless you are Schopenhauer or so, and really interested
in futility of life) can be resumed in three points:
    - The "extends Thread" thing. Bless heritage. The all-good Java designers
    let us the Thread class (implementing Runnable) to make our lives easy (and
    meaningful, not like the ImACreatedThread one). Whenever we have to split
    our programs work in concurrent work, all we have to do is using this
    heritage.

    - The "run()" override. We need to tell our thread what to do. It works more
    or less like the "main()" method, describing the performance of our 
    subprogram. It's important to keep in mind that all the Threads paralelly
    thrown are executed at the same time, so we will have to protect critic
    sections (like changing a global variable value).

    - The try section, which vigilates nobody and nothing wake up our sleeping
    creature, killing himself if so. We have to keep this vigilance beacuse, as
    we are programming in a concurrent way, there could happen something
    somewhere affecting our thread.
 */
package lesson1_ThreadsCreation;

/**
 *
 * @author Tina Rincón Martínez
 */
public class ImACreatedThread extends Thread{
    private final String _name;
    private final long _birthtime;
    
    public ImACreatedThread(String name){
        _name=name;
        _birthtime=System.currentTimeMillis();
        System.out.println("I'm "+_name+", I've been created!");
    }
    @Override
    public void run(){
        System.out.println("I'm "+_name+", I've been runned "+ ((System.currentTimeMillis()-_birthtime)/1000)+" seconds after being born! Now I want to sleep.");
        long segundos=(long)(Math.random());
        try {
            Thread.sleep(segundos*1000);
        } catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("I am "+ _name + ".It has been "+((System.currentTimeMillis()-_birthtime)/1000)+" seconds alive and life is paaaaain.");
    }
}
