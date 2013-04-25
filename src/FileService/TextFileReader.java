package FileService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Dan Smith
 */
public class TextFileReader implements FileReaderStrategy {
    private String filePath;

    public TextFileReader(String filePath) throws InvalidFilePathException {
        this.setFilePath(filePath);
    }
    
    @Override
    public List<String> readFile() throws IOException{
        List lines = new ArrayList();
        BufferedReader in = null;
        try {
	   in = new BufferedReader(new FileReader(filePath));
	   String line = in.readLine();
	   while(line != null){
		  lines.add(line);
		  line = in.readLine();  // strips out any carriage return chars
	   }
	 
        } catch(IOException ioe) {
            throw ioe;
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
            return lines;
        }
    }

    @Override
    public final void setFilePath(String filePath) throws InvalidFilePathException {
        if(filePath == null || filePath.length() == 0) {
            throw new InvalidFilePathException();
        }
        this.filePath = filePath;
    }

    @Override
    public String getFilePath() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    public static void main(String[] args) {
        String filePath = "src" + File.separatorChar + "Files"
                + File.separatorChar + "myData.txt";
        try {
            TextFileReader tr = new TextFileReader(filePath);
            List<String> temp = new ArrayList<>();
            temp = tr.readFile();
            for (String string : temp) {
                System.out.println(string);
            }
            
            List<LinkedHashMap<String, String>> temp1 = new ArrayList<>();
            CsvCommaFormat cf = new CsvCommaFormat(true);
            temp1 = cf.decode(temp);
            System.out.println(temp1);
            
        } catch(InvalidFilePathException ife) {
            
        } catch(IOException ioe) {
            
        }
        
    }
}
