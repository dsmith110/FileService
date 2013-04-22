package FileService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dan Smith
 */
public class TextFileReader implements FileReaderStrategy {
    private String filePath;


    public TextFileReader(String filePath) {
        this.filePath = filePath;
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
    public void setFilePath(String filePath) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getFilePath() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
