import java.nio.charset.Charset;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Lab5_1
{
  //Scanner lukee näppäimistöltä tekstiä
    Scanner scanner = new Scanner(System.in);
    //Staattinen main metodi
    public static void main(String [ ] args)
    {
      //Luodaan uusi olio ja kutsutaan doStuff metodia
      new Lab5_1().doStuff();
    }
    //DoStuff metodi
    public void doStuff()
    {
      //While loop toistuu niin kauan, että käyttäjä antaa quit komennon (9.)
      while (true)
      {
        System.out.println("1. Read");
        System.out.println("2. Write");
        System.out.println("3. Done");

        String cmd = "";
        cmd = scanner.nextLine();

        if (cmd.equals("1"))
        {
          try{
            //Valitaan kaikki rivit ja tulostetaan
            //Files luokalla on staattinen metodi (readAlllines), jolle annetaan parametreinä tiedostonnimi ja merkistö
            List<String> lines = Files.readAllLines(Paths.get("testFile.txt"), Charset.defaultCharset());
            //Lista loopataan läpi
            for (String line : lines) {
              System.out.println(line);
              }
            }
            catch (Exception e){
              System.out.println("File not found or other error...");
            }
        }
        else if (cmd.equals("2"))
        {
          System.out.println("Please enter new text: ");
          String entry = scanner.nextLine();

          Date date = new Date();

          try{
            //Tiedostoon tallennus
            //true ei tee uutta tiedostoa, jos vanha on jo olemassa
            //Lue more testFile.txt(ennen read diarya tekemistä....)
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File("testFile.txt"), true));
            writer.append("\n\n" + date.toString() + ":" + entry);
            writer.close();
          }
          catch (Exception e) {
            System.out.println("File cannot be created or other error.");
          }
        }
        else if (cmd.equals("3"))
        {
          break;
        }
      }
    }
}
