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
                new TextFileWriter(true, filePath),
                new CSVTextFileFormatter(","), 
                new CSVTextFileFormatter(","));
        
        List temps = new ArrayList();
//        String[] contacts = {"Dan", "Smith", "WI"};
//        temps.add(contacts);
//        fs.writeFile(temps);
//        temps.add(contacts);
        temps.add("Dan");
        temps.add("Dan");
        temps.add("Dan");
        fs.writeFile(temps);
//        temps.add("1, 2, 3, 4");
        temps = new ArrayList();
        temps.add("Sally");
        temps.add("Sally");
        temps.add("Sally");
//        temps.add("Sally");
//        temps.add("Sally");
        fs.writeFile(temps);

//        System.out.println(fs.readFile().get(0));

    }
}
