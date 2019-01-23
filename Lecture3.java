import java.util.Scanner;
import java.util.ArrayList;

public class Lecture3 {

  private String nimi = "Henkilo";
//Staattinen main metodi
  public static void main (String[] args) {

    Lecture3 paaOhjelma = new Lecture3();//Luodaan pääohjeöma
    paaOhjelma.aloitaPaaOhjelma();//Kutsutan aloitaPaaOhjelma
  }
  //Metodi jota kutsutaan pääohjelma oliolle
  public void aloitaPaaOhjelma(){
    /*Scanner lukee tekstiä näppäimistöltä niin kauan, että käyttäjä
    kirjoittaa sanan STOP*/
    Scanner scanner = new Scanner(System.in);
    System.out.println("Hello World");

    ArrayList<Lecture3DemoThread> threads = new ArrayList<Lecture3DemoThread>();
    //Thread siirretty pois if lauseen sisältä
      //Siirretty arraylistaan! ja takaisin if lauseeseen
      //Lecture2DemoThread thread = new Lecture2DemoThread();

    String command = "";
    //Ohjelmasta poistuminen threadin pysäyttämisen jälkeen
    while(!command.equals("STOP")) {
      command = scanner.nextLine();
      //Start thread
      if (command.equals("START")){
        nimi = "Seppo Taalasmaa";
        Lecture3DemoThread thread = new Lecture3DemoThread();
        threads.add(thread);
        //thread.setCallbackInterface(this);
        thread.identifier = "THREAD - 1"; //identifier Lecture2DemoThread.java
        thread.start();//start jotta pääsäie pysyy responsiivisena(ei run)
      }
      //Pysäyttää threadin
      else if (command.equals("STOPALL")){
        for (Lecture3DemoThread thread : threads){
          thread.stopThread();
        }

      }
      else if (command.equals("INTERRUPT")){
        //thread.interrupt();
      }
    }
  }
}
