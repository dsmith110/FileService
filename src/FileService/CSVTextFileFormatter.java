package FileService;

import java.util.ArrayList;
import java.util.List;

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
    public String encode(List lines) {
        
        StringBuilder sb = new StringBuilder(); 
        List<String> encodedLines = new ArrayList<String>();
//
//        for (Object l : lines) {
//            sb.append(l).append(ROW_DELIMITER);
//            encodedLines.add(sb.toString());
//          
//        }
//        
//        return encodedLines;

//        for (String[] line : lines) {
//            sb = new StringBuilder();
//            for (int i = 0; i < line.length; i++) {
//                sb.append(line[i]);
//                if (i == line.length - 1) {
//                    sb.append(ROW_DELIMITER);
//                } else {
//                    sb.append(colDelimiter);
//                }
//            }
//            encodedLines.add(sb.toString());
//        }
            for(int i = 0; i < lines.size(); i++) {
            if (i == lines.size() - 1) {
                sb.append((lines.get(i))).append(ROW_DELIMITER);
            } else {
                sb.append(lines.get(i)).append(colDelimiter);
            }
        }
        return sb.toString();
    }
    

    @Override
    public List decode(List<String> lines) {
        List<String> decodedLines = new ArrayList<String>();
        String[] temps;
        for (String l : lines) {
            temps = l.split(colDelimiter);
            for (int i = 0; i < temps.length; i++) {
                decodedLines.add(temps[i]);
            }
        }
        return decodedLines;
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
