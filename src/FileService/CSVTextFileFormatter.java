package FileService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Dan Smith
 */
public class CSVTextFileFormatter implements FileFormatStrategy {
    private String colDelimiter;

    public CSVTextFileFormatter() {}
    
    public CSVTextFileFormatter(String colDelimiter) {
        this.colDelimiter = colDelimiter;
    }
    
    @Override
    public String encode(List<LinkedHashMap<String, String>> lines, boolean hasHeader) {
        /*
         * 1. retrieve keyset of keys (Header values) hasHeader = true
         * 2. Loop through the list and retrieve each map as a seperate record
         * 3. Ask for values collection (our data)
         * 4. Loop through value collection, add to a string followed by a coma
         */
        StringBuilder sb = new StringBuilder();
        Set keys = null;
        if(hasHeader) {
            keys = lines.get(ZERO).keySet();
        }
        for(int i = 0; i < lines.size(); i++) {
            
        }
        
        return sb.toString();
    }
    

    @Override
    public List<Map<String, String>> decode(List<String> lines, boolean hasHeader) {
        List<Map<String, String>> decodedData = new ArrayList<Map<String, String>>();
        
        
        return decodedData;
    }


    @Override
    public void setColDelimiter(String delimiter) {
        this.colDelimiter = delimiter;
    }

    @Override
    public String getColDelimiter() {
        return colDelimiter;
    }
    
}
