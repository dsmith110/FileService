package FileService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author Dan Smith
 */
public class TextFileWriter implements FileWriterStrategy {
    private File file;
    private boolean append;
    private String filePath;

    public TextFileWriter(boolean append, String filePath) throws InvalidFilePathException {
        this.setAppend(append);
        this.setFilePath(filePath);
    }
    
    @Override
    public void writeFile(String encodedLine) throws IOException{
        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                new FileWriter(getFile(), isAppend())));

        out.print(encodedLine);
        out.close();
    }

    @Override
    public final void setAppend(boolean append) {
        this.append = append;
    }

    @Override
    public boolean getAppend() {
        return isAppend();
    }

    @Override
    public final void setFilePath(String filePath) throws InvalidFilePathException {
        if(filePath == null || filePath.length() == 0) {
            throw new InvalidFilePathException();
        }
        setFile(new File(filePath));
        this.filePath = filePath;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) throws IllegalArgumentException {
        if(file == null) {
            throw new IllegalArgumentException();
        }
        this.file = file;
    }

    /**
     * @return the append
     */
    public boolean isAppend() {
        return append;
    }
    
}
