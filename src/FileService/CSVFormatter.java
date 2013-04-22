package FileService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Dan Smith
 */
public class CSVFormatter implements FileFormatStrategy{
    private String colDelimiter;
    private boolean hasHeader;

    public CSVFormatter(String colDelimiter, boolean hasHeader) {
        this.colDelimiter = colDelimiter;
        this.hasHeader = hasHeader;
        
    }

    @Override
    public String encode(List<LinkedHashMap<String, String>> data) {
        StringBuilder sb = new StringBuilder();
        
        boolean headerSet = false;
        Set<String> keys = null;
        
        if(hasHeader) {
            keys = data.get(ZERO).keySet();
        }

        for (int i = 0; i < data.size(); i++) {
            // Add header to CSV formatted string if required
            if (keys != null && !headerSet) {
                for (String key : keys) {
                    sb.append(DBL_QUOTE).append(key).append(DBL_QUOTE).append(colDelimiter);
                }
                // Delete last comma
                sb.deleteCharAt(sb.length() - 1);
                // Add new row
                sb.append(ROW_DELIMITER);
                // Header already set
                headerSet = true;
                // Helper method to add map values
                addData(data, i, sb);
            } else {
                addData(data, i, sb);
            }
        }

        return sb.toString();
    }

    @Override
    public List<LinkedHashMap<String, String>> decode(List<String> lines) {
        // Create List of decoded data
        List<LinkedHashMap<String, String>> decodedData =
                new ArrayList<LinkedHashMap<String, String>>();

        // Remove quotes from data
        for (String line : lines) {
            line = removeQuotes(line);
        }

        // Uses this to assign keys to the map
        String[] headerFields = null;

        for (int recordNo = 0; recordNo < lines.size(); recordNo++) {
            // Splits the string and assigns it to values in array
            String[] fields = lines.get(recordNo).split(colDelimiter);

            // Assign the header to headerFields array
            if (hasHeader && (recordNo == 0)) {
                headerFields = fields;
            }

            // Create a Map
            LinkedHashMap<String, String> record =
                    new LinkedHashMap<String, String>();

            for (int i = ZERO; i < fields.length; i++) {
                // Nothing needs to be done, first record is the header
                if (hasHeader && (recordNo == 0)) {
                    break;

                    // if header included, we store header info as key and data value
                } else if (hasHeader) {
                    record.put(headerFields[i], fields[i]);

                    // if no header we create an artificial key from a counter and add value
                } else {
                    record.put(EMPTY_STRING + i, fields[i]);
                }
            }

            // Only add the record if it's not the first row (header)
            if (recordNo != 0) {
                decodedData.add(record);
            }
        }

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
    
    // Helper method to remove quotes
    private String removeQuotes(String line) {
        return line.replaceAll(DBL_QUOTE, EMPTY_STRING);
    }
    
    // Helper method to add values to formatted CSV string
    private void addData(List<LinkedHashMap<String, String>> data, int recordNum, StringBuilder sb) {
        Collection<String> valueCol = data.get(recordNum).values();
        for (String value : valueCol) {
            sb.append(DBL_QUOTE).append(value).append(DBL_QUOTE);
            sb.append(colDelimiter);
        }
        
        sb.deleteCharAt(sb.length() - 1);
        sb.append(ROW_DELIMITER);
    }
    
    
}
