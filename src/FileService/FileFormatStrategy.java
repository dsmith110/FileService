/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FileService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dskrilla24
 */
public interface FileFormatStrategy {
    public final String ROW_DELIMITER = "\n";
    public final String DBL_QUOTE = "\"";
    public final int ZERO = 0;
    
    public abstract List<LinkedHashMap<String, String>> decode(List<String> lines, boolean hasHeader);
    
    public abstract String encode(List<LinkedHashMap<String, String>> lines, boolean hasHeader);
    
    public abstract void setColDelimiter(String delimiter);
    
    public abstract String getColDelimiter();
}
