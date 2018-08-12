package ru.geekbrains.java1.lesson8;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class Win extends JFrame {
    public Win() {
        setBounds(500, 200, 800, 600);
        setTitle("GUI Demo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));
        JPanel[] jp = new JPanel[4];
        for (int i = 0; i < 4; i++) {
            jp[i] = new JPanel();
            this.add(jp[i]);
            jp[i].setBackground(new Color(100 + i * 40, 100 + i * 40, 100 + i * 40));
        }


        jp[0].setLayout(new BorderLayout());
        JTextArea jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        jp[0].add(jsp);



        jp[1].setLayout(new FlowLayout());
        JRadioButton[] jrb = new JRadioButton[4];
        ButtonGroup bgr = new ButtonGroup();
        ButtonGroup bgr2 = new ButtonGroup();
        ButtonGroup bgr3 = new ButtonGroup();
        for (int i = 0; i < jrb.length; i++) {
            jrb[i] = new JRadioButton("Option #" + i);
            if (i < 2) {
                bgr.add(jrb[i]);
            } else {
                bgr2.add(jrb[i]);
            }
            jp[1].add(jrb[i]);
        }
        JCheckBox[] jcb = new JCheckBox[4];
        for (int i = 0; i < jcb.length; i++) {
            jcb[i] = new JCheckBox("Check #" + i);
//            bgr3.add( jcb[i]);
            jp[1].add(jcb[i]);
        }


        jp[2].setLayout(new FlowLayout());
        String[] comboStr = {"Item #1", "Item #2", "Item #3", "Item #4"};
        JComboBox<String> jcombo1 = new JComboBox<>(comboStr);
        JComboBox<String> jcombo2 = new JComboBox<>(comboStr);
        jp[2].add(jcombo1);
        jp[2].add(jcombo2);


        jcombo1.addActionListener(e -> System.out.println("///*-8565"));

//        jcombo1.addActionListener(e -> {System.out.println(jcombo1.getSelectedItem().toString() + "***");});
//        jcombo1.addActionListener(new ActionComBox());
//        jcombo1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println(jcombo1.getSelectedItem().toString());
//            }
//        });


        int x = 50, y = 200, z = 50;
        jp[3].setLayout(null);
        JPanel jpMini = new JPanel();
         JSlider js = new JSlider();
        JLabel jlab = new JLabel("Value: 100");
        JLabel jlabTwo = new JLabel("Разбавь RGB цвета вручную");
        JButton butAddTenR = new JButton("R +10");
        JButton butAddTenG = new JButton("G +10");
        JButton butAddTenB = new JButton("B +10");
        butAddTenR.setSize(30, 30);
        butAddTenG.setSize(30, 30);
        butAddTenB.setSize(30, 30);
        js.setMaximum(200);
        js.setMinimum(0);
        js.setValue(100);
        jpMini.add(butAddTenR);
        jpMini.add(butAddTenG);
        jpMini.add(butAddTenB);
        jpMini.setLayout(new FlowLayout());
        jpMini.setVisible(true);
        jp[3].add(jlab);
        jp[3].add(jlabTwo);
        jp[3].add(jpMini);
        jp[3].add(js);
        js.addChangeListener(e -> jlab.setText("Value: " + js.getValue()));

        //Изменение №1. Добавил слушателя на изменение значения JSlider, привязал к изменению фонового цвета

        js.addChangeListener(e -> {
            if (js.getValue() == 50) {
                js.setBackground(new Color(x, y, z));
            } else if (js.getValue() > 50) {
                js.setBackground(new Color(x + js.getValue(), y - js.getValue(), z + js.getValue()));
            } else {
                js.setBackground(new Color(x + js.getValue(), y - js.getValue(), z + js.getValue()));
            }
        });

        butAddTenR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x > 155) {
                    js.setBackground(new Color(x  - 100, y, z));
                } else {
                    js.setBackground(new Color(x + 100, y, z));
                }
            }
        });
        butAddTenG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (y > 155) {
                    js.setBackground(new Color(x, y - 100, z));
                } else {
                    js.setBackground(new Color(x, y + 100, z));
                }
            }
        });
        butAddTenB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (z > 155) {
                    js.setBackground(new Color(x, y, z - 100));
                } else {
                    js.setBackground(new Color(x, y, z + 100));
                }
            }
        });


//        js.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                jlab.setText("Value: " + js.getValue());
//            }
//        });
        jpMini.setBounds(10, 40, 300, 100);
        jlab.setBounds(10, 10, 100, 20);
        jlabTwo.setBounds(110, 10, 300, 20);
        js.setBounds(10, 160, 300, 80);




        JMenuBar mainMenu = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenu mEdit = new JMenu("Edit");
        JMenuItem miFileNew = new JMenuItem("New");
        JMenuItem miFileExit = new JMenuItem("Exit");

        setJMenuBar(mainMenu);

        mainMenu.add(mFile);
        mainMenu.add(mEdit);

        mFile.add(miFileNew);
        mFile.addSeparator(); // разделительная линия
        mFile.add(miFileExit);

        miFileExit.addActionListener(e -> System.exit(0));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                System.out.println("BYE");
            }
        });


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Click");
            }
        });

        setVisible(true);

    }

}
