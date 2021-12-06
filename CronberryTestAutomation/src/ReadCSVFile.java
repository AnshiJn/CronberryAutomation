import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class ReadCSVFile {

	
	public static void main(String[] args) throws Exception {
		
		Div();
	}
	
	public static String Div() throws IOException{

		 String value="anshika";
	CSVReader reader = new CSVReader(
			new FileReader("/Users/alcodesmobility/Desktop/live cronberry (Responses) - Form Responses 1.csv"));

	
	
	List<String[]> list = reader.readAll();

	System.out.println("Total rows which we have is " + list.size());


	for (int i = 1; i <= list.size(); i++) {
		
		for(int j=1;j<=4;j++)	
		{
		String[] thirdRow = list.get(i);
		    value= thirdRow[j];
			
}
	}
	
	System.out.println("print"+value);

	return value;

}
}
	
		
		
		
