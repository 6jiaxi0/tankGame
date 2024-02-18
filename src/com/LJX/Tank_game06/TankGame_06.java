package com.LJX.Tank_game06; /*
 * @author:小刘
 * @形成于思,毁于随----朱熹
 */

import javax.swing.*;

public class TankGame_06 extends JFrame{
   MyPanel mp = null;
    public static void main(String[] args) {
        new TankGame_06();
    }

    public TankGame_06(){
        mp = new MyPanel();
        //将mp放入Thread,并启动
        new Thread(mp).start();

        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
