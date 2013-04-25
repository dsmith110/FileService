package FileService;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Dan Smith
 */
public interface FileFormatStrategy {
    public final String ROW_DELIMITER = "\n";
    public final String DBL_QUOTE = "\"";
    public final String EMPTY_STRING = "";
    public final int ZERO = 0;
    
    public abstract List<LinkedHashMap<String, String>> decode(List<String> lines);
    
    public abstract String encode(List<LinkedHashMap<String, String>> lines);
    
    
}
