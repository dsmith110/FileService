package FileService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author Dan Smith
 */
public class TextFileWriter implements FileWriterStrategy {
    private File file;
    private boolean append;
    private String filePath;

    public TextFileWriter(boolean append, String filePath) {
        this.setAppend(append);
        this.setFilePath(filePath);
    }
    
    @Override
    public void writeFile(String encodedLine) throws IOException{
        PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                    new FileWriter(file, append)));
         
            out.print(encodedLine);

            

        out.close();
    }

    @Override
    public final void setAppend(boolean append) {
        this.append = append;
    }

    @Override
    public boolean getAppend() {
        return append;
    }

    @Override
    public final void setFilePath(String filePath) {
        file = new File(filePath);
        this.filePath = filePath;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }
    
}
