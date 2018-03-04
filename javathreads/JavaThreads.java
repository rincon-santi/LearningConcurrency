/*
This program pretends to illustrate the usage of threads in Java, in order to do
such, there are different packages working like lessons, and this main function
calls them from a menu, so you can visualice the algorithms in action. It is
recommendable to choose a big number of threads to see the greatness of
concurrence.
*/
package javathreads;

import java.util.Scanner;
import lesson1_ThreadsCreation.TheCreator;
import lesson2_ThreadsCompetition.TheGodfather;

/**
 *
 * @author Tina Rincón Martínez
 */
public class JavaThreads {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner reader= new Scanner(System.in);
        boolean exit=false;
        while(!exit){
            int choice = menu(reader);
            int numberOfThreads;
            switch (choice){
                case 1:
                    numberOfThreads=tellMeNumber(reader);
                    TheCreator creator=new TheCreator(numberOfThreads);
                    creator.create();
                    break;
                case 2:
                    numberOfThreads=tellMeNumber(reader);
                    TheGodfather godfather=new TheGodfather(numberOfThreads);
                    godfather.create();
                    break;
                default:
                    exit=true;
                    break;
            }     
        }
    }

    private static int menu(Scanner reader){
        System.out.println("CHOOSE A LESSON:");
        System.out.println("1 -> Lesson1: Threads Creation");
        System.out.println("2 -> Lesson2: Threads Competition");
        
        int aux;
        try{
            aux = reader.nextInt();
        } catch(java.util.InputMismatchException e){
            System.out.println("Incorrect input, try again");
            aux=menu(reader);
        }
        return aux;
    }

    private static int tellMeNumber(Scanner reader) {
        System.out.println("How many threads do you want to throw?");
        int aux;
        try{
            aux = reader.nextInt();
        } catch(java.util.InputMismatchException e){
            System.out.println("Incorrect input, try again");
            aux=tellMeNumber(reader);
        }
        return aux;
    }
    
}
