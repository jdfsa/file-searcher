package br.com.jdfs.searcher.service;

import br.com.jdfs.searcher.component.StringCleanerComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearcherService {

    private final StringCleanerComponent stringCleanerComponent;

    @Autowired
    public SearcherService(StringCleanerComponent stringCleanerComponent) {
        this.stringCleanerComponent = stringCleanerComponent;
    }

    /**
     * Given a <code>phrase</code> find how many words contains in a <code>text</code>
     *
     * @param phrase phrase with words to find
     * @param text text to be searched
     * @return percentage with how many matches were found
     */
    public double findOccurrences(String phrase, String text) {
        String searchablePhrase = stringCleanerComponent.getOnlyWords(phrase);
        String searchableText = stringCleanerComponent.getOnlyWords(text);

        List<String> totalWords = Arrays.stream(searchableText.toLowerCase().split(" ")).collect(Collectors.toList());
        Set<String> searchWords = Arrays.stream(searchablePhrase.toLowerCase().split(" ")).collect(Collectors.toSet());

        double totalMatches = searchWords.parallelStream()
                .mapToDouble(word -> totalWords.contains(word) ? 1 : 0).sum();

        return (totalMatches / searchWords.size()) * 100;
    }
}
