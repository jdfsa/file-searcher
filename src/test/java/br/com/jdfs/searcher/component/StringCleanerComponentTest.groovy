package br.com.jdfs.searcher.component

import spock.lang.Shared
import spock.lang.Specification

class StringCleanerComponentTest extends Specification {

    @Shared
    private StringCleanerComponent stringCleanerComponent

    def setupSpec() {
        stringCleanerComponent = new StringCleanerComponent()
    }

    def "Get only words"() {
        when:
        String result = stringCleanerComponent.getOnlyWords(
                "test, <> Phrase \$ á À ççç with.! special characters.!")
        then:
        result == "test Phrase á À ççç with special characters"
    }

    def "Get only words with double spaces"() {
        when:
        String result = stringCleanerComponent.getOnlyWords(
                "test,     <>   Phrase \$  á  À ççç with.! special characters.!")
        then:
        result == "test Phrase á À ççç with special characters"
    }
}
