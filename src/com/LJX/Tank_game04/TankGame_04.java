package com.LJX.Tank_game04; /*
 * @author:小刘
 * @形成于思,毁于随----朱熹
 */

import javax.swing.*;

public class TankGame_04 extends JFrame{
   MyPanel mp = null;
    public static void main(String[] args) {
        new TankGame_04();

    }

    public TankGame_04(){
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
