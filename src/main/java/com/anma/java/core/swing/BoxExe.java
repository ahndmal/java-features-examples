package com.anma.java.core.swing;

import javax.swing.*;
import java.awt.*;

public class BoxExe {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setTitle("Frame");

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.LIGHT_GRAY);

        JButton button = new JButton();
        button.setBackground(Color.ORANGE);
        button.setText("Click");
        panel1.add(button);

        JLabel label = new JLabel();
        label.setText("Text in the label");
        panel1.add(label);

        JLabel label2 = new JLabel();
        label2.setText("Label 2 lorem ...");
        panel1.add(label2);


        Box box = Box.createHorizontalBox();
        box.add("component1", Box.createGlue());
        box.show();

        panel1.add(box);

        JTable table = new JTable(3, 3);
        CellEditor cellEditor = new DefaultCellEditor(new JCheckBox("Checkbox text"));
        
        panel1.add(table);

        frame.getContentPane().add(panel1);

        frame.setVisible(true);
    }
}
