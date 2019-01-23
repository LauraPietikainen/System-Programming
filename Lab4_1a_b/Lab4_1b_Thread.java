import java.lang.*;

public class Lab4_1b_Thread extends Thread {

  private int progress = 0;
  private int threadIdentifier = 0;
  public Lab4_1b_Thread(int identifier){
    this.threadIdentifier = identifier;
  }
  protected Lab4_1b_Interface notifier = null;
  public void setNotifier(Lab4_1b_Interface notifier) {
    this.notifier = notifier;
  }

  public void run(){
    while(progress < 100){
      try{
        sleep(3000);
        progress = progress + 10;
        if(notifier != null){
          notifier.printProgress(progress, threadIdentifier);
        }
      }
      catch (Exception e) {
        System.out.println("Interrupted!");
        return;
      }
    }
  }
}
