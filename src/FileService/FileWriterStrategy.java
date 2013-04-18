package FileService;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Dan Smith
 */
public interface FileWriterStrategy {
    public abstract void writeFile(String line) throws IOException;
    
    public abstract void setAppend(boolean append);
    
    public abstract boolean getAppend();
    
    public abstract void setFilePath(String filePath);
    
    public abstract String getFilePath();
}
