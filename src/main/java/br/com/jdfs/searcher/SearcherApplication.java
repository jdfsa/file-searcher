package br.com.jdfs.searcher;

import br.com.jdfs.searcher.processor.StartupProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SearcherApplication implements CommandLineRunner {

    private StartupProcessor startupProcessor;

    @Autowired
    public SearcherApplication(StartupProcessor startupProcessor) {
        this.startupProcessor = startupProcessor;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SearcherApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.setLogStartupInfo(false);
        app.run(args);
    }

    @Override
    public void run(String... args) {
        startupProcessor.init(args[0]);
    }
}
