package br.com.jdfs.searcher.service

import br.com.jdfs.searcher.component.StringCleanerComponent
import spock.lang.Shared
import spock.lang.Specification

class SearcherServiceSpec extends Specification {

    @Shared
    private SearcherService searcherService

    def setupSpec() {
        searcherService = new SearcherService(new StringCleanerComponent())
    }

    def "Find occurrences with 0%"() {
        when:
        double result = searcherService.findOccurrences(
                    "test phrase",
                    "")
        then:
        result == 0
    }

    def "Find occurrences with 100%"() {
        when:
        double result = searcherService.findOccurrences(
                    "test phrase with two words",
                    "test phrase with two words")
        then:
        result == 100
    }

    def "Partially find occurrences with 80%"() {
        when:
        double result = searcherService.findOccurrences(
                "two with phrase test words",
                "test phrase with two")
        then:
        result == 80
    }

    def "Find occurrences with 100% having repeated words"() {
        when:
        double result = searcherService.findOccurrences(
                "two two one one test",
                "test one two three four five six")
        then:
        result == 100
    }

    def "Partially find occurrences with 20% having not only words"() {
        when:
        double result = searcherService.findOccurrences(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur et auctor sapien, at cursus sem.",
                "sit amet, consectetur adipiscing elit")
        then:
        result.intValue() == 33
    }
}
