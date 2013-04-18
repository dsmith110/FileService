package FileService;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Dan Smith
 */
public class Startup {
    
    public static void main(String[] args) throws IOException {
        String filePath = "src" + File.separatorChar + "Files"
                + File.separatorChar + "myData.txt";

        FileService fs = new FileService(
                new TextFileReader(filePath),
                new TextFileWriter(false, filePath),
                new CSVTextFileFormatter(","), 
                new CSVTextFileFormatter(","));
        
        
    }
}
