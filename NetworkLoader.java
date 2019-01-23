import java.io.*;

public class NetworkLoader{

    public static void main(String[] args) {
      System.out.println("Network loader started");

      NetworkLoader loader = new NetworkLoader();
      loader.loadStuff();
    }

    private void loadStuff(){
      HttpURLConnection ulrConnection = null;
      try{
        URL url = new URL("http://google.com");
        urlConnection = (HttpURLConnection) url.openConnection();
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        String allData = fromStream(in);
        System.out.println(allData);
        in.close();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
      finally{
        if (urlConnection != null)
        {
          urlConnection.disconnect();
        }
      }
    }
}
public static String = new
