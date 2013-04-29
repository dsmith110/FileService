package FileService;

import java.util.List;

/**
 *
 * @author Dan Smith
 */
public interface FileFormatStrategy <T, E>{
    public final String ROW_DELIMITER = "\n";
    public final String DBL_QUOTE = "\"";
    public final String EMPTY_STRING = "";
    public final int ZERO = 0;
    
    public abstract List<T> decode(E lines);
    
    public abstract String encode(List<T> lines);
    
    
}
