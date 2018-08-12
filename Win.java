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
        jsp.setBackground(Color.RED);
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
            jp[1].add(jcb[i]);
        }

        //Меня блюд
        //Изменение №4. Вывод менюшек
        jp[2].setLayout(new FlowLayout());
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        Button btnOk = new Button("Подтверждаю");
        String[] comboStr = {"Menu №1", "Menu №2", "Menu №3", "Menu №4"};
        JComboBox<String> jcombo1 = new JComboBox<>(comboStr);
        JLabel jLabel1 = new JLabel("Будни: ");
        JComboBox<String> jcombo2 = new JComboBox<>(comboStr);
        JLabel jLabel2 = new JLabel("Праздники: ");
        JLabel jLabelBtn = new JLabel("Подтвердите выбранное меню, нажав на кнопку:");


        jPanel1.setBackground(new Color(180,180,180));
        jPanel2.setBackground(new Color(180,180,180));
        jPanel3.setBackground(new Color(180,180,180));
        jPanel1.add(jLabel1);
        jPanel1.add(jcombo1);
        jPanel2.add(jLabel2);
        jPanel2.add(jcombo2);
        jPanel3.add(jLabelBtn);
        jPanel3.add(btnOk);

        jp[2].add(jPanel1);
        jp[2].add(jPanel2);
        jp[2].add(jPanel3);

        //Вывод выбранного пункта меню 1 комбобокса
        jcombo1.addActionListener(e -> System.out.println("Меню будни, выбрано - " + jcombo1.getSelectedItem()));

        //Вывод выбранного пункта меню 2 комбобокса
        jcombo2.addActionListener(e -> System.out.println("Меню праздники, выбрано - " + jcombo2.getSelectedItem()));


        //JSlider панель
        Color color = new Color(100, 200, 100);
        jp[3].setLayout(null);
        JPanel jpMini = new JPanel();
         JSlider js = new JSlider();
        JLabel jlab = new JLabel("Value: 50");
        JLabel jlabTwo = new JLabel("Разбавь RGB цвета вручную");
        JButton butAddTenR = new JButton("R +-100");
        JButton butAddTenG = new JButton("G +-100");
        JButton butAddTenB = new JButton("B +-100");
        butAddTenR.setSize(30, 30);
        butAddTenG.setSize(30, 30);
        butAddTenB.setSize(30, 30);
        js.setMaximum(100);
        js.setMinimum(0);
        js.setValue(50);
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
                js.setBackground(color);
            } else if (js.getValue() > 50) {
                js.setBackground(new Color(color.getRed() + js.getValue(), color.getGreen() - js.getValue(), color.getBlue() + js.getValue()));
            } else {
                js.setBackground(new Color(color.getRed() + js.getValue(), color.getGreen() - js.getValue(), color.getBlue() + js.getValue()));
            }
        });

        //Изменение №2. Кнопки на ручное изменение цвета
        butAddTenR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (color.getRed() > 155) {
                    js.setBackground(new Color(color.getRed()  - 100, color.getGreen(), color.getBlue()));
                } else {
                    js.setBackground(new Color(color.getRed() + 100, color.getGreen(), color.getBlue()));
                }
            }
        });
        butAddTenG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (color.getGreen() > 155) {
                    js.setBackground(new Color(color.getRed(), color.getGreen() - 100, color.getBlue()));
                } else {
                    js.setBackground(new Color(color.getRed(), color.getGreen() + 100, color.getBlue()));
                }
            }
        });
        butAddTenB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (color.getBlue() > 155) {
                    js.setBackground(new Color(color.getRed(), color.getGreen(), color.getBlue() - 100));
                } else {
                    js.setBackground(new Color(color.getRed(), color.getGreen(), color.getBlue() + 100));
                }
            }
        });
        jpMini.setBounds(10, 40, 300, 100);
        jlab.setBounds(10, 10, 100, 20);
        jlabTwo.setBounds(110, 10, 300, 20);
        js.setBounds(10, 160, 300, 80);



        //Изменение №3. Добавлена кнопка сохранения и настроек без реализации
        JMenuBar mainMenu = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenu mEdit = new JMenu("Edit");
        JMenuItem miFileNew = new JMenuItem("New");
        JMenuItem miSaveNew = new JMenuItem("Save");
        JMenuItem miSettingsNew = new JMenuItem("Settings");
        JMenuItem miFileExit = new JMenuItem("Exit");

        setJMenuBar(mainMenu);

        mainMenu.add(mFile);
        mainMenu.add(mEdit);

        mFile.add(miFileNew);
        mFile.addSeparator(); // разделительная линия
        mFile.add(miSaveNew);
        mFile.addSeparator(); // разделительная линия
        mFile.add(miSettingsNew);
        mFile.addSeparator(); // разделительная линия
        mFile.add(miFileExit);

        miFileExit.addActionListener(e -> System.exit(0));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //изменил момент закрытия программы через крестик
                JOptionPane.showMessageDialog(null, "Закрытие программы, нажмите на ОК для подтверждения");
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
