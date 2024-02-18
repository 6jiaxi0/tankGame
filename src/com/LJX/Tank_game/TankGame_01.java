package com.LJX.Tank_game; /*
 * @author:小刘
 * @形成于思,毁于随----朱熹
 */

import com.LJX.Tank_game02.MyPanel;

import javax.swing.*;

public class TankGame_01 extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        new TankGame_01();
    }

    public TankGame_01(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
