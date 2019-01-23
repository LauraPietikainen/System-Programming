import java.util.Date;

public class Lecture3DemoThread extends Thread {

  public String identifier = "";
  private boolean running = true;

  @Override
  public void run() {
    try {
      //while (true) {
      while(running) {
        Date date = new Date();
        String str = String.format("%tc :", date );
        System.out.printf(str);
        System.out.println("Tiisu, We want more! - " + identifier);
        sleep(5000);//säie nukkuu 5s
      }
    }
    //Exception jos säikeen suoritus keskeytyy
    catch (Exception e) {
      e.printStackTrace();
    }
    System.out.print("Thread stopping..");
  }
  //stopThread
  public void stopThread(){
    running = false;
  }

/*  @Override
  public void interrupt(){
    stopThread();
  }*/
}
