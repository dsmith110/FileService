/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FileService;

import java.util.List;

/**
 *
 * @author dskrilla24
 */
public interface FileFormatStrategy {
    public final String ROW_DELIMITER = "\n";
    public final int ZERO = 0;
    
    public abstract String encode(List<String> objects);
    
    public abstract List decode(List<String> lines);
    
    public abstract void setColDelimiter(String delimiter);
    
    public abstract String getColDelimiter();
}
