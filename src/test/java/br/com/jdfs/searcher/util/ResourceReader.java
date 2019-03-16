package br.com.jdfs.searcher.util;

import java.io.File;

public final class ResourceReader {
    public static File[] getFiles(String... paths) {
        File[] files = new File[paths.length];
        for (int i = 0; i < paths.length; i++) {
            files[i] = getFile(paths[i]);
        }
        return files;
    }

    public static File getFile(String path) {
        return new File(ResourceReader.class.getResource(path).getFile());
    }
}
