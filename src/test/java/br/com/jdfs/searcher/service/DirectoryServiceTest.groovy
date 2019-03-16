package br.com.jdfs.searcher.service


import spock.lang.Shared
import spock.lang.Specification

import java.nio.file.Paths

class DirectoryServiceTest extends Specification {

    @Shared
    private DirectoryService directoryService

    def setupSpec() {
        directoryService = new DirectoryService()
    }

    def "Get directory valid info"() {
        when:
        File result = directoryService.getDirectoryInfo(".")

        then:
        result != null
        result.isDirectory()
    }

    def "Get all files"() {

        given:
        DirectoryService directoryServiceSpy = Spy(DirectoryService)

        and: 'Mock return pointing to resource files'
        1 * directoryServiceSpy.getDirectoryInfo(_) >> new File(Paths.get("./src/test/resources/files").toUri())

        when:
        Map<String, String> result = directoryServiceSpy.getFiles("any_test_path")

        then:
        result.size() == 2
        result.containsKey("file1.txt")
        result.get("file1.txt").startsWith("I checked to make")
        result.containsKey("file2.txt")
        result.get("file2.txt").startsWith("The river stole")
    }
}
