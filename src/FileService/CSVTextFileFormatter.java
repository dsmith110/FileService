package FileService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public String encode(List<LinkedHashMap<String, String>> data, boolean hasHeader) {
        StringBuilder sb = new StringBuilder();
        
        boolean headerSet = false;
        Set<String> keys = null;
        
        if(hasHeader) {
            keys = data.get(ZERO).keySet();
        }

        for (int i = 0; i < data.size(); i++) {
            if (keys != null && !headerSet) {
                for (String key : keys) {
                    sb.append(DBL_QUOTE).append(key).append(DBL_QUOTE).append(colDelimiter);
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append(ROW_DELIMITER);
                headerSet = true;
                addData(data, i, sb);
            } else {
                addData(data, i, sb);
            }
        }

        return sb.toString();
    }


    @Override
    public List<LinkedHashMap<String, String>> decode(List<String> lines, boolean hasHeader) {
        List<LinkedHashMap<String, String>> decodedData = 
                new ArrayList<LinkedHashMap<String, String>>();


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
    
    private void addData(List<LinkedHashMap<String, String>> data, int recordNum, StringBuilder sb) {
        Collection<String> values = data.get(recordNum).values();
        
        for(Object value : values) {
            sb.append(DBL_QUOTE).append(value).append(DBL_QUOTE).append(colDelimiter);
        }
        
        sb.deleteCharAt(sb.length() - 1);
        sb.append(ROW_DELIMITER);
    }

    
    
    
    public static void main(String[] args) {
        Map test = new LinkedHashMap();
        List data = new ArrayList();

        test.put("Hours Worked", 35);
        test.put("Total Collected", 112.50);
        test.put("Total", 210.99);
        data.add(test);
        test.put("Hours Worked", 35);
        test.put("Total Collected", 112.50);
        test.put("Total", 210.99);
        data.add(test);
        test.put("Hours Worked", 35);
        test.put("Total Collected", 112.50);
        test.put("Total", 210.99);
        data.add(test);
        test.put("Hours Worked", 35);
        test.put("Total Collected", 112.50);
        test.put("Total", 210.99);
        data.add(test);
        

        CSVTextFileFormatter csv = new CSVTextFileFormatter(",");
        System.out.println(csv.encode(data, true));

    }
}
