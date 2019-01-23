import java.util.Date;

public class Lab2_3 extends Thread {

  @Override
  public void run(){
    try {
      System.out.println("Thread started");
      while (true) {
        Date date = new Date();
				String str = String.format(" %tc ", date); //Date
				System.out.printf(str);
				System.out.println("Tiisu, We want more!");
        sleep(5000); //Display in every 5 sec.
      }
    }
    catch (Exception e) {
      System.out.println("Thread interrupted");
    }
  }
}
