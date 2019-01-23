import java.util.Scanner;

public class Lecture2 {

  public static void main (String[] args) {
    /*Scanner lukee tekstiä näppäimistöltä niin kauan, että käyttäjä
    kirjoittaa sanan STOP*/
    Scanner scanner = new Scanner(System.in);
    System.out.println("START to Start thread, STOP to stop thread and QUIT for exit");
    //Thread siirretty pois if lauseen sisältä
    Lecture2DemoThread thread = new Lecture2DemoThread();

    String command = "";
    while(!command.equals("QUIT")) {
      command = scanner.nextLine();

      if (command.equals("START")){
        //Lecture2DemoThread thread = new Lecture2DemoThread();
        thread.identifier = "THREAD - 1"; //identifier Lecture2DemoThread.java
        thread.start();//start jotta pääsäie pysyy responsiivisena(ei run)
      }
      else if (command.equals("STOP")){
        thread.stopThread();
      }
    }
  }
}
