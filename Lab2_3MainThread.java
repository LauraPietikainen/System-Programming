import java.util.Scanner;

public class Lab2_3MainThread {

  public static void main(String[] args){
    Lab2_3 thread = new Lab2_3();
    boolean isInterrupted = false;
    Scanner scanner = new Scanner(System.in);
    String command = "";

    while(!command.equals("QUIT")) {
      System.out.println("Master, give your command: START, STOP or QUIT");
      command = scanner.nextLine();

      if(command.equals("START") && !thread.isAlive()) {
        if (isInterrupted) {
          thread = new Lab2_3();
        }

        System.out.println("Starting thread");
        thread.start();
      }
      else if(command.equals("STOP") && thread.isAlive()) {
        thread.interrupt();
        isInterrupted = true;
      }
    }
    if(thread.isAlive()) {
      thread.interrupt();
      isInterrupted = true;
    }
  }
}
