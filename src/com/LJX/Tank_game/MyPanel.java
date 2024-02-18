//package com.LJX.Tank_game; /*
// * @author:小刘
// * @形成于思,毁于随----朱熹
// */
//
//import javax.swing.*;
//import java.awt.*;
//
//public class MyPanel extends JPanel {
//    //定义我的坦克
//    MyTank_ tank = null;
//    public MyPanel(){
//        //初始化 坦克
//        tank = new MyTank_(100,100);
//    }
//
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        g.fillRect(0,0,1000,750);
//
//        //画出坦克 --封装方法
//        drawTank(tank.getX(), tank.getY(), g, 0, 0);
//    }
//
//    //编写方法 -- 画坦克
//    /*
//    * x---坦克的左上角x坐标
//    * y-- 坦克的右上角y坐标
//    * g -- 画笔
//    * dirct 坦克方向
//    * type 坦克的类型
//    * */
//    public void drawTank(int x,int y,Graphics g ,int direct,int type){
//
//        switch(type){
//            case 0:
//                //我们的坦克
//                //靑色
//                g.setColor(Color.cyan);
//                break;
//            case 1:
//                //敌人的坦克
//                g.setColor(Color.yellow);
//                break;
//        }
//
//        switch(direct){
//            //0 --> up
//            case 0:{
//                //画出坦克左边的轮子
//                g.fill3DRect(x, y,10,60,false);
//                //画出坦克右边的轮子
//                g.fill3DRect(x + 30, y,10,60,false);
//                //画出坦克的盖子
//                g.fill3DRect(x + 10, y + 10,20,40,false);
//                //画出坦克的小圆盖
//                g.fillOval(x + 10, y + 20,20,20);
//                //画出炮筒
//                g.drawLine(x + 20, y + 30, x + 20, y);
//                break;
//            }
//
//        }
//
//    }
//}
