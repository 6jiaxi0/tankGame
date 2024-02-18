package com.LJX.Tankgame; /**
 * @author:小刘
 * @形成于思,毁于随----朱熹
 */

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

public class TankGame extends JFrame{
   MyPanel mp = null;
   static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        new TankGame();
    }


    public TankGame(){
        System.out.println("输入你的选择: 1,开始游戏 2,继续上一把游戏\n");
        String key = "";
        key = sc.next();
        mp = new MyPanel(key);
        //将mp放入Thread,并启动
        new Thread(mp).start();

        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1300,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //在JFrame增加相对应的关闭窗口的处理
       this.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               try {
                   Record_.keepRecord();
               } catch (IOException ex) {
                   throw new RuntimeException(ex);
               }
               System.exit(0);
           }
       });

    }
}
