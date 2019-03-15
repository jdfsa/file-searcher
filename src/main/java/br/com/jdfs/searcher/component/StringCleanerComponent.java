package br.com.jdfs.searcher.component;

import org.springframework.stereotype.Component;

@Component
public class StringCleanerComponent {

    /**
     * Given a <code>phrase</code> returns only words without punctuation characters
     *
     * @param phrase phrase to be cleaned
     * @return version of <code>phrase</code> without, but keeping only words
     */
    public String getOnlyWords(String phrase) {
        return phrase
                .replaceAll("[^A-zÀ-ÿ0-9ç_\\s]", "")
                .replaceAll("\\s{2,}", " ");
    }
}
