import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class FileReader{
	public static void main(String[] args) throws FileNotFoundException, IOException {


		File file = new File("/home/desjoao/LPII/exemplo.txt");
		Scanner scan = new Scanner(file);

		while(scan.hasNextLine()){
			System.out.println(scan.nextLine());
		}

		String fileContent = "";
		while(scan.hasNextLine()){
			fileContent = fileContent.concat(scan.nextLine() + "\n");
		}

		FileWriter writer = new FileWriter("/home/desjoao/LPII/exemplo_escrita.txt");
		writer.write(fileContent);
		writer.close();

	}
}

