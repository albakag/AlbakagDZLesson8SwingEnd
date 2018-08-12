package ru.geekbrains.java1.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Form1 extends JFrame {
    public Form1() {
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        JButton[] jbs = new JButton[5];
        for (int i = 0; i < 5; i++) {
            jbs[i] = new JButton("#" + i);
        }
        setLayout(new BorderLayout()); // выбор компоновщика элементов
        add(jbs[0], BorderLayout.EAST); // добавление кнопки на форму
        add(jbs[1], BorderLayout.WEST);
        add(jbs[2], BorderLayout.SOUTH);
        add(jbs[3], BorderLayout.NORTH);
        add(jbs[4], BorderLayout.CENTER);

        setVisible(true);
    }
}

