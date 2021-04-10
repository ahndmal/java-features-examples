package com.anma.java.core.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class ResourceBundleExe {

    public static void main(String[] args) {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("com.anma.java.core.util.props");
        MessageFormat format = new MessageFormat(resourceBundle.getString("country"));
    }
}
