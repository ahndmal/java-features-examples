package com.anma.java.core.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class Xdd {

    static void usage() {
        System.out.println("Usage: java Xdd <file>");
        System.out.println("       java Xdd -set <name>=<value> <file>");
        System.out.println("       java Xdd -get <name> <file>");
        System.out.println("       java Xdd -del <name> <file>");
        System.exit(-1);
    }

    public static void main(String[] args) throws IOException {
        // one or three parameters
        if (args.length != 1 && args.length != 3)
            usage();

        Path file = (args.length == 1) ? Paths.get(args[0])
                : Paths.get(args[2]);

        // check that user defined attributes are supported by the file store
        FileStore store = Files.getFileStore(file);
        if (!store.supportsFileAttributeView(UserDefinedFileAttributeView.class)) {
            System.err.format(
                    "UserDefinedFileAttributeView not supported on %s\n", store);
            System.exit(-1);

        }
        UserDefinedFileAttributeView view = Files.getFileAttributeView(file,
                UserDefinedFileAttributeView.class);

        // list user defined attributes
        if (args.length == 1) {
            System.out.println("    Size  Name");
            System.out
                    .println("--------  --------------------------------------");
            for (String name : view.list()) {
                System.out.format("%8d  %s\n", view.size(name), name);
            }
            return;
        }

        // Add/replace a file's user defined attribute
        if (args[0].equals("-set")) {
            // name=value
            String[] s = args[1].split("=");
            if (s.length != 2)
                usage();
            String name = s[0];
            String value = s[1];
            view.write(name, Charset.defaultCharset().encode(value));
            return;
        }

        // Print out the value of a file's user defined attribute
        if (args[0].equals("-get")) {
            String name = args[1];
            int size = view.size(name);
            ByteBuffer buf = ByteBuffer.allocateDirect(size);
            view.read(name, buf);
            buf.flip();
            System.out.println(Charset.defaultCharset().decode(buf).toString());
            return;
        }

        // Delete a file's user defined attribute
        if (args[0].equals("-del")) {
            view.delete(args[1]);
            return;
        }

        // option not recognized
        usage();
    }
}
