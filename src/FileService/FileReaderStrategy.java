package FileService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dan Smith
 */
public interface FileReaderStrategy {
    public abstract List<String> readFile() throws IOException;
    
    public abstract void setFilePath(String filePath);
    
    public abstract String getFilePath();
}
