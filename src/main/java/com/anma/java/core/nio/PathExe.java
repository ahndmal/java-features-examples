package com.anma.java.core.nio;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class PathExe {

    public static void main(String[] args) {

        Path path = FileSystems.getDefault().getPath("json");

        System.out.println(path.getNameCount());
        System.out.println(path.getFileSystem().isOpen());
        System.out.println(path.getFileSystem().isReadOnly());

        Path path2 = Path.of("src/resources/text2-new.txt").getParent();
        System.out.println(path2);
    }
}
