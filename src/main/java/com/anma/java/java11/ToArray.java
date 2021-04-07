package com.anma.java.java11;

import java.util.ArrayList;
import java.util.List;

public class ToArray {

    void canTurnListIntoArray() {
        List<String> months = new ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        new String[] { "January", "February", "March" }.equals(months.toArray(new String[months.size()]));
        new String[] { "January", "February", "March" }.equals(months.toArray(String[]::new));
    }

}
