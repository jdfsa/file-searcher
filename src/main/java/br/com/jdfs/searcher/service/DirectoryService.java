package br.com.jdfs.searcher.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DirectoryService {

    /**
     * Get a file from a <code>directory</code> path
     *
     * @param directory directory path
     * @return File with the directory info
     */
    public File getDirectoryInfo(String directory) {
        Path path = Paths.get(directory);
        return new File(path.toUri());
    }

    /**
     * Load files based on a specific <code>directory</code>
     *
     * @param directory
     * @return map with the file name and its content
     */
    public Map<String, String> getFiles(String directory) {
        File path = getDirectoryInfo(directory);
        return Arrays.stream(path.listFiles()).collect(
                Collectors.toMap(File::getName, f -> readContent(f)));
    }

    /**
     * Read content from a <code>file</code>
     * @param file
     * @return content from <code>file</code>
     */
    private String readContent(File file) {
        try {
            return String.join("\n", Files.readAllLines(Paths.get(file.getPath())));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (Exception e) {
            System.out.println("Generic error on reading the content from the file");
        }
        return null;
    }
}
