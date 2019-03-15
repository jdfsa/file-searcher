package br.com.jdfs.searcher.processor;

import org.springframework.stereotype.Service;

@Service
public class StartupProcessor {

    public void readDirectories() {
        System.out.println("Loading directory files...");
    }
}
