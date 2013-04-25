package FileService;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Dan Smith
 */
public interface FileReaderStrategy {
    public abstract List<String> readFile() throws IOException;
    
    public abstract void setFilePath(String filePath) throws InvalidFilePathException;
    
    public abstract String getFilePath();
}
