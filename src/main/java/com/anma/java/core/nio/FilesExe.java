package com.anma.java.core.nio;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesExe {

    public static void main(String[] args) throws URISyntaxException, IOException {

        Files.delete(Path.of(new URI("src/resources/text2-new.txt")));
    }
}
