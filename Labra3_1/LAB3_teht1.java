import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class LAB3_teht1
{
	// Lukee URLin ja palauttaa sisällön stringissä
	public static String readURLContent(String urlString) throws IOException
	{
		URL url = new URL(urlString);
		Scanner scan = new Scanner(url.openStream());

		String content = new String();
		while (scan.hasNext())
			content += scan.nextLine();
		scan.close();

		return content;
	}

	// Hakee rajatun html sisällön (title, style, body, head)
	public static String findTitle(String str)
	{
		/*String	tagOpen = "<title>";
		String	tagClose = "</title>";*/

		String	tagOpen = "<style>";
		String	tagClose = "</style>";

		/*String	tagOpen = "<head>";
		String	tagClose = "</head>";*/

		/*String	tagOpen = "<body>";
		String	tagClose = "</body>";*/

		int		begin = str.indexOf(tagOpen) + tagOpen.length();
		int		end = str.indexOf(tagClose);
		return str.substring(begin, end);
	}
//pääsäie
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in);

		while (true)
		{
			System.out.println("Syota URL muodossa: http://www...(Valilyonti enter keskeytys):");
			String	str = scan.nextLine();
			if (str.length() == 0)
				break;

			String content = readURLContent(str);
			String title = findTitle(content);
			System.out.println(title);
		}
	}
}
