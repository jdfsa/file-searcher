package br.com.jdfs.searcher.processor;

import br.com.jdfs.searcher.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

@Component
public class StartupProcessor {

    private final DirectoryService directoryService;

    @Autowired
    public StartupProcessor(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    /**
     * Start up configuration
     *
     * @param path arguments passed via command-line
     */
    public void init(String path) {
        Map<String, String> files = directoryService.getFiles(path);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("search> ");
            String t = scanner.nextLine();
            System.out.println(t);
        }
    }
}
