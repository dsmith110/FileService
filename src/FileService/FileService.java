package FileService;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Dan Smith
 */
public class FileService {
    private FileReaderStrategy fileReader;
    private FileWriterStrategy fileWriter;
    private FileFormatStrategy fileReaderFormat;
    private FileFormatStrategy fileWriterFormat;

    public FileService(FileWriterStrategy fileWriter, FileFormatStrategy fileWriterFormat) {
        this.fileWriter = fileWriter;
        this.fileWriterFormat = fileWriterFormat;
    }

    public FileService(FileReaderStrategy fileReader, FileFormatStrategy fileReaderFormat) {
        this.fileReader = fileReader;
        this.fileReaderFormat = fileReaderFormat;
    }

    public FileService(FileReaderStrategy fileReader, FileWriterStrategy fileWriter, FileFormatStrategy fileReaderFormat, FileFormatStrategy fileWriterFormat) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.fileReaderFormat = fileReaderFormat;
        this.fileWriterFormat = fileWriterFormat;
    }
    
    public List<LinkedHashMap<String, String>> readFile() throws IOException {
        return fileReaderFormat.decode(fileReader.readFile());
    }
    
    public void writeFile(List<LinkedHashMap<String, String>> data) throws IOException {
        fileWriter.writeFile(fileWriterFormat.encode(data));
    }
    
    public String encode(List<String> data) {
        return fileWriterFormat.encode(data);
    }
    
    public void setAppend(boolean append) {
        fileWriter.setAppend(append);
    }
    
    public boolean getAppend() {
        return fileWriter.getAppend();
    }
    
    /**
     * @return the fileReader
     */
    public FileReaderStrategy getFileReader() {
        return fileReader;
    }

    /**
     * @param fileReader the fileReader to set
     */
    public void setFileReader(FileReaderStrategy fileReader) {
        this.fileReader = fileReader;
    }

    /**
     * @return the fileWriter
     */
    public FileWriterStrategy getFileWriter() {
        return fileWriter;
    }

    /**
     * @param fileWriter the fileWriter to set
     */
    public void setFileWriter(FileWriterStrategy fileWriter) {
        this.fileWriter = fileWriter;
    }

    /**
     * @return the fileReaderFormat
     */
    public FileFormatStrategy getFileReaderFormat() {
        return fileReaderFormat;
    }

    /**
     * @param fileReaderFormat the fileReaderFormat to set
     */
    public void setFileReaderFormat(FileFormatStrategy fileReaderFormat) {
        this.fileReaderFormat = fileReaderFormat;
    }

    /**
     * @return the fileWriterFormat
     */
    public FileFormatStrategy getFileWriterFormat() {
        return fileWriterFormat;
    }

    /**
     * @param fileWriterFormat the fileWriterFormat to set
     */
    public void setFileWriterFormat(FileFormatStrategy fileWriterFormat) {
        this.fileWriterFormat = fileWriterFormat;
    }
}
