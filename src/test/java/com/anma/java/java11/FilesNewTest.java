package com.anma.java.java11;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static org.junit.jupiter.api.Assertions.*;

class FilesNewTest {

    @Test
    void filesReadApiOne() throws IOException, URISyntaxException {

        URI txtFileUri = getClass().getClassLoader()
                .getResource("text2.txt").toURI();

        String content = Files.readString(Path.of(txtFileUri), Charset.defaultCharset());

        assertEquals("Hello World!", content);
    }

    @Test
    void canWriteString() throws IOException {

        Path tmpFilePath = Path.of(
                File.createTempFile("tempFile", ".tmp").toURI());

        Path returnedFilePath = Files.writeString(tmpFilePath,
                "Hello World!", Charset.defaultCharset(),
                StandardOpenOption.WRITE);

        assertEquals(tmpFilePath, returnedFilePath);
    }
}