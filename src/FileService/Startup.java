package FileService;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Dan Smith
 */
public class Startup {
    
    public static void main(String[] args) {
        String filePath = "src" + File.separatorChar + "Files"
                + File.separatorChar + "myData.txt";
//          String filePath = "";
        List<LinkedHashMap<String, String>> test1 = new ArrayList<>();
        LinkedHashMap<String, String> test = new LinkedHashMap<>();
        test.put("First Name", "Dan");
        test.put("Last Name", "Smith");
        test.put("State", "NY");
        test1.add(test);
        test1.add(test);
        try {
            FileService fs = new FileService(
                new TextFileReader(filePath),
                new TextFileWriter(false, filePath),
                new CsvCommaFormat(true),
                new CsvCommaFormat(true));
//            fs.writeFile(test1);
            List<LinkedHashMap<String, String>> temp = new ArrayList<>();
            fs.writeFile(test1);
            temp = fs.readFile();
            
            System.out.println(temp);
        } catch(InvalidFilePathException ife) {
            System.out.println(ife.toString());
        } catch(IOException ioe) {
            System.out.println(ioe.toString());
        }
        
        
        
        
        
    }
}
