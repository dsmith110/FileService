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
        Map test = new LinkedHashMap();
        List data = new ArrayList();
        Employee e1 = new Employee("Dan", "Smith", "WI");
        Employee e2 = new Employee("Bob", "Brown", "WI");
        Employee e3 = new Employee("Sally", "Jones", "WI");
        Employee e4 = new Employee("Roger", "Waters", "WI");
        test.put("First Name", e1.getfName());
        test.put("Last Name", e1.getlName());
        test.put("State", e1.getState());
        data.add(test);
        Map test1 = new LinkedHashMap();
        test1.put("First Name", e2.getfName());
        test1.put("Last Name", e2.getlName());
        test1.put("State", e2.getState());
        data.add(test1);

        try {
            FileService fs = new FileService(
                new TextFileReader(filePath),
                new TextFileWriter(false, filePath),
                new CsvCommaFormat(true), 
                new CsvCommaFormat(true));
            
            List<LinkedHashMap<String, String>> temp = new ArrayList<>();
            fs.writeFile(data);
            temp = fs.readFile();

            System.out.println(temp);
            
        } catch(InvalidFilePathException ifpe) {
            System.out.println(ifpe);
        } catch(IOException ioe) {
            System.out.println(ioe.toString());
        }
        
        
        
        
    }
}
