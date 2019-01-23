import java.util.Date;
import java.util.*;

public class Lab4_1b_Main implements Lab4_1b_Interface {

  private ArrayList<Lab4_1b_Thread> threads = new ArrayList<Lab4_1b_Thread>();
  private Lab4_1b_Thread thread;
  private Scanner scanner;
  private String command = "";

  public static void main(String[] args) {
    Lab4_1b_Main lab4 = new Lab4_1b_Main();
    lab4.startProgram();

  }

  public void startProgram() {
    scanner = new Scanner(System.in);
    System.out.println("START for new thread, QUIT for exit");
    while(!command.equals("QUIT")){
      command = scanner.nextLine();
      if(command.equals("START")){
        thread = new Lab4_1b_Thread(threads.size() + 1);
        threads.add(thread);
        thread.setNotifier(this);
        thread.start();
      }
    }
    for(Lab4_1b_Thread thread : threads){
      thread.interrupt();
    }
  }

  @Override
  public void printProgress(int progress, int threadCounter) {
    Date date = new Date();
    // Time, date, counter and progress
    String str = String.format("Current Date/Time: %tc", date );
    System.out.println(str + " Thread " + threadCounter +
                  " progress = " + progress + "%");
  }

}
