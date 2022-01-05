package me.connor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;

public class Details implements ActionListener {
    private int revenue = 10;
    private int delay = 1000;
    private int growth = 0;
    private JLabel label;
    private JLabel Money;
    private AppFrame appFrame;
    private JPanel score;
    private JPanel buttons;
    private Timer start_stop;

    public int getGrowth(){
        return growth;
    }

    public void setGrowth(int i){
        growth = growth + i;
    }

    public int getRevenue(){
        return revenue;
    }

    public void setRevenue(int i){
        revenue = revenue - i;
    }

    public Details(){
        appFrame = new AppFrame();
        // Make appFrame visible...
        appFrame.setVisible(true);
        appFrame.setTitle("Zoo Build");

        label = new JLabel("Money in the Bank; ");
        label.setFont(new Font("Verdana", Font.PLAIN, 20));
        Money = new JLabel(String.valueOf(revenue));
        Money.setFont(new Font("Verdana", Font.PLAIN, 18));

        score = new JPanel(new GridLayout(2, 1));
        score.add(label, BorderLayout.BEFORE_FIRST_LINE);
        score.add(Money, BorderLayout.LINE_END);
        appFrame.add(score, BorderLayout.BEFORE_FIRST_LINE);

        JButton zoo_Patrons = new JButton("Buy Tickets; Cost $1");
            zoo_Patrons.addActionListener(this);
            zoo_Patrons.setActionCommand("1");
        JButton zoo_Animals = new JButton("Buy New Animals; Cost $10");
            zoo_Animals.addActionListener(this);
            zoo_Animals.setActionCommand("2");
        JButton zoo_Cleaners = new JButton("Buy Cleaning Staff; Cost $100");
            zoo_Cleaners.addActionListener(this);
            zoo_Cleaners.setActionCommand("3");
        JButton zoo_Food_Huts = new JButton("Buy Food Huts; Cost $1000");
            zoo_Food_Huts.addActionListener(this);
            zoo_Food_Huts.setActionCommand("4");
        JButton zoo_Playground = new JButton("Add a Playground; Cost $10000");
            zoo_Playground.addActionListener(this);
            zoo_Playground.setActionCommand("5");
        JButton Restart = new JButton("Restart...");
            Restart.addActionListener(this);
            Restart.setActionCommand("6");

        buttons = new JPanel();
        buttons.setLayout(new GridLayout(3, 3, 29, 30));
        buttons.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        buttons.add(zoo_Patrons);
        buttons.add(zoo_Animals);
        buttons.add(zoo_Cleaners);
        buttons.add(zoo_Food_Huts);
        buttons.add(zoo_Playground);
        buttons.add(Restart);
        appFrame.add(buttons, BorderLayout.CENTER);

        ActionListener time = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                revenue += getGrowth();
                Money.setFont(new Font("Verdana", Font.PLAIN, 18));
                Money.setText(String.valueOf(revenue));
            }
        };
        start_stop = new Timer(delay, time);
        start_stop.start();


    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("1")) {
            if((getRevenue() - 1) >= 0){
                setRevenue(1);
                Money.setText(String.valueOf(revenue));
                setGrowth(1);
            }
            else{
                Money.setFont(new Font("Verdana", Font.BOLD, 24));
            }
        }
        if (action.equals("2")) {
            if((getRevenue() - 10) >= 0){
                setRevenue(10);
                Money.setText(String.valueOf(revenue));
                setGrowth(3);
            }
            else{
                Money.setFont(new Font("Verdana", Font.BOLD, 24));
            }
        }
        if (action.equals("3")) {
            if((getRevenue() - 100) >= 0){
                setRevenue(100);
                Money.setText(String.valueOf(revenue));
                setGrowth(10);
            }
            else{
                Money.setFont(new Font("Verdana", Font.BOLD, 24));
            }
        }
        if (action.equals("4")) {
            if((getRevenue() - 1000) >= 0){
                setRevenue(1000);
                Money.setText(String.valueOf(revenue));
                setGrowth(100);
            }
            else{
                Money.setFont(new Font("Verdana", Font.BOLD, 24));
            }
        }
        if (action.equals("5")) {
            if((getRevenue() - 10000) >= 0){
                setRevenue(10000);
                Money.setText(String.valueOf(revenue));
                setGrowth(100);
            }
            else{
                Money.setFont(new Font("Verdana", Font.BOLD, 24));            }
        }
        if (action.equals("6")) {
            setRevenue((getRevenue()-10));
            setGrowth(-(getGrowth()));
        }
    }
}
