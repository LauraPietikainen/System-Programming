import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab4_1 extends Thread{
    boolean isStop = false;
    boolean isCompleted = false;
    int i = 1;

    void setIsStop(boolean value){
        isStop = value;
    }
    boolean chkIsStop(){
        return isStop;
    }

    public void run(){
        while(!isCompleted){
            if(chkIsStop()){
                while(chkIsStop()){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Lab4_1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else{

				Date date = new Date();
				// display time and date
				String str = String.format("Current Date/Time: %tc", date );
				//System.out.println(date.toString());
				System.out.printf(str);
				System.out.println(" On Progress.." + ++i );

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Lab4_1.class.getName()).log(Level.SEVERE, null, ex);
                }
                  if(i==10){
                    isCompleted=true;
					System.out.println("100% Done!");
				}
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {

		System.out.println("main START");

        Lab4_1 threadPause = new Lab4_1();
        //Joined the Thread with the MAIN Thread
        try {
            threadPause.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Lab4_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        threadPause.start();
        System.out.println("Class START 0%");

        Thread.sleep(3000); // MAIN thread stop 3 sec
        threadPause.setIsStop(false);
        System.out.println("10%"); // Progress 10%

		Thread.sleep(3000);
        threadPause.setIsStop(false);
        System.out.println("20%"); //Progress 20% etc...

		Thread.sleep(3000);
        threadPause.setIsStop(false);
        System.out.println("30%");

		Thread.sleep(3000);
        threadPause.setIsStop(false);
        System.out.println("40%");

		Thread.sleep(3000);
        threadPause.setIsStop(false);
        System.out.println("50%");

		Thread.sleep(3000);
        threadPause.setIsStop(false);
        System.out.println("60%");

		Thread.sleep(3000);
        threadPause.setIsStop(false);
        System.out.println("70%");

		Thread.sleep(3000);
        threadPause.setIsStop(false);
        System.out.println("80%");

		Thread.sleep(3000);
        threadPause.setIsStop(false);
        System.out.println("90%");
    }
}
