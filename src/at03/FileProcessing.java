package at03;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileProcessing {

	public static void main(String[] args) throws IOException{
		
		File file = new File("entries.txt");
		PrintWriter out = null;
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		/*try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("D:\\Ohjelmointi\\Java\\java-projects\\at03\\src\\at03\\entries.txt", true)));
			out.println("text");
		}catch(IOException e) {
			System.err.println(e);
		}finally {
			if(out != null) {
				out.close();
			}
		}*/
		
		try {
			Files.write(Paths.get("entries.txt"), "testi12345".getBytes(), StandardOpenOption.APPEND);
		}catch(IOException e) {
			
		}
	
	}
	
	
	

}
