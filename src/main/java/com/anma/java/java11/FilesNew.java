package com.anma.java.java11;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/*
 Java 11 Files API
 https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Files.html
 https://www.baeldung.com/java-nio-2-file-api
 */

public class FilesNew {

    public static void main(String[] args) throws IOException {

        Path tmpFilePath = Path.of(
                File.createTempFile("tempFile", ".tmp").toURI());

        Path returnedFilePath = Files.writeString(tmpFilePath,
                "Hello World!", Charset.defaultCharset(),
                StandardOpenOption.WRITE);

    }

    private static void readStr1() throws IOException, URISyntaxException {

        URI txtFileUri = FilesNew.class.getClass().getClassLoader()
                .getResource("helloworld.txt").toURI();
        String content = Files.readString(Path.of(txtFileUri),
                Charset.defaultCharset());
        "Hello World!".equals(content);

    }
}
