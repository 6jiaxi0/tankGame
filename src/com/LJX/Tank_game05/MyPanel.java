package com.LJX.Tank_game05; /*
 * @author:小刘
 * @形成于思,毁于随----朱熹
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//为了监听键盘事件,实现KeyListener
// 为了 让Panel 不停的重绘,需要将MyPanel 实现Runnable,当做一个线程使用

public class MyPanel extends JPanel implements KeyListener ,Runnable{
    //定义我的坦克
    MyTank_ tank = null;

    //定义敌人的坦克
    Vector<Hero> hero = new Vector<>();
    int enemyTankSize = 3;

    //定义一个Vector 用于 存放炸弹
    //当子弹击中 坦克时,就加入一个bomb对象
    Vector<Bomb> bombs = new Vector<>();

    //定义三张效果图 ,显示爆炸
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel(){
        //初始化 坦克
        tank = new MyTank_(100,100);
        
        //初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            Hero hero1 = new Hero(100 * (i + 1), 0);
            //设置方向
            hero1.setDirect(2);
            new Thread(hero1).start();
            //给 hero,加入一个子弹
            Shot shot = new Shot(hero1.getX() + 20, hero1.getY() + 60, hero1.getDirect());
            //计入Hero 中 的Vector
            hero1.shots.add(shot);
            //启动shot 对象
            new Thread(shot).start();
            hero.add(hero1);
        }
        
        //设置坦克的速度
        tank.setSpeed(3);

        //初始化图片
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

    }

    //编写方法,判断我方的子弹是否击中敌方坦克
    public  void hitTank(Shot s, Hero tank){
        //判断 s 击中坦克
        switch (tank.getDirect()) {
            case 0:
            case 2:
                if (s.x > tank.getX() && s.x < tank.getX() + 40
                        && s.y > tank.getY() && s.y < tank.getY() + 60) {
                    //创建Bomb对象, 加入bombs集合
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                    s.isLive = false;
                    tank.isLive = false;
                    hero.remove(tank);
                }
                break;
            case 1:
            case 3:
                if(s.x > tank.getX() && s.x < tank.getX() + 60
                        && s.y > tank.getY() && s.y < tank.getY() + 40){
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                    s.isLive = false;
                    tank.isLive = false;
                    hero.remove(tank);
                }
                break;
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //填充游戏区域
        g.fillRect(0,0,1000,750);

        //画出坦克 --封装方法
        drawTank(tank.getX(), tank.getY(), g, tank.getDirect(), 1);

        //画出tank 发射的子弹
        if(tank.shot != null && tank.shot.isLive != false){
            System.out.println("重绘...");
//            g.fill3DRect(tank.shot.x,tank.shot.y,1,1,false);
            g.draw3DRect(tank.shot.x,tank.shot.y,3,3,false);
        }


        //画出敌人的坦克，遍历Vector

        for (int i = 0; i < hero.size(); i++) {
            Hero hero1 = hero.get(i);
            if (hero1.isLive) {
                drawTank(hero1.getX(), hero1.getY(), g, hero1.getDirect(), 0);
                //画出所有子弹
                for (int j = 0; j < hero1.shots.size(); j++) {
                    Shot shot1 = hero1.shots.get(j);
                    //绘制
                    if (shot1.isLive) {
                        g.draw3DRect(shot1.x, shot1.y, 3, 3, false);
                    } else {
                        //移除
                        hero1.shots.remove(shot1);
                    }
                }
            }
        }
        //如果bombs 集合有对象则画出
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前 这个bomb对象的life值 去画出对象的图片
            if(bomb.life > 6){
                g.drawImage(image1,bomb.x,bomb.y,60,60,this);
            }else if(bomb.life > 3){
                g.drawImage(image2,bomb.x,bomb.y,60,60,this);
            }else{
                g.drawImage(image3,bomb.x,bomb.y,60,60,this);
            }
            //让生命减少
            bomb.lifeDown();
            //如果 bomb的life 值为0，则删除
            if(bomb.life == 0){
                bombs.remove(bomb);
            }
        }


    }

    //编写方法 -- 画坦克
    /*
    * x---坦克的左上角x坐标
    * y-- 坦克的右上角y坐标
    * g -- 画笔
    * dirct 坦克方向
    * type 坦克的类型
    * */
    public void drawTank(int x,int y,Graphics g ,int direct,int type){

        switch(type){
            case 0:
                //我们的坦克
                //靑色
                g.setColor(Color.cyan);
                break;
            case 1:
                //敌人的坦克
                g.setColor(Color.yellow);
                break;
        }
        //根据坦克的方向,来绘制不同的坦克
        //direct 表示不同的方向(0->up, 1->right, 2->down, 3->left)
        switch(direct){
            //0 --> up
            case 0:{
                //画出坦克左边的轮子
                g.fill3DRect(x, y,10,60,false);
                //画出坦克右边的轮子
                g.fill3DRect(x + 30, y,10,60,false);
                //画出坦克的盖子
                g.fill3DRect(x + 10, y + 10,20,40,false);
                //画出坦克的小圆盖
                g.fillOval(x + 10, y + 20,20,20);
                //画出炮筒
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            }
            case 1:{
                //画出坦克上边的轮子
                g.fill3DRect(x, y,60,10,false);
                //画出坦克下边的轮子
                g.fill3DRect(x, y + 30,60,10,false);
                //画出坦克的盖子
                g.fill3DRect(x + 10, y + 10,40,20,false);
                //画出坦克的小圆盖
                g.fillOval(x + 20, y + 10,20,20);
                //画出炮筒
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            }
            case 2:{
                //画出坦克左边的轮子
                g.fill3DRect(x, y,10,60,false);
                //画出坦克右边的轮子
                g.fill3DRect(x + 30, y,10,60,false);
                //画出坦克的盖子
                g.fill3DRect(x + 10, y + 10,20,40,false);
                //画出坦克的小圆盖
                g.fillOval(x + 10, y + 20,20,20);
                //画出炮筒
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            }
            case 3:{
                //画出坦克上边的轮子
                g.fill3DRect(x, y,60,10,false);
                //画出坦克下边的轮子
                g.fill3DRect(x, y + 30,60,10,false);
                //画出坦克的盖子
                g.fill3DRect(x + 10, y + 10,40,20,false);
                //画出坦克的小圆盖
                g.fillOval(x + 20, y + 10,20,20);
                //画出炮筒
                g.drawLine(x + 30, y + 20, x - 9, y + 20);
                break;
            }
            default:{
                System.out.println("被动情况————wrong");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    //处理wasd被按下的事件
    @Override
    public void keyPressed(KeyEvent e) {
        //direct 表示不同的方向(0->up, 1->right, 2->down, 3->left)
        if (e.getKeyCode() == KeyEvent.VK_W) {
            //改变坦克的方向
            tank.setDirect(0);
            //修改坦克的坐标
            tank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            tank.setDirect(1);
            tank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            tank.setDirect(2);
            tank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            tank.setDirect(3);
            tank.moveLeft();
        }else if (e.getKeyCode() == KeyEvent.VK_J){
            tank.shotEnemyTank();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //判断是否击中敌人坦克
            //我的子弹存活
            if(tank.shot!= null && tank.shot.isLive){
                //遍历敌人的所有坦克
                for (int i = 0; i < hero.size(); i++) {
                    Hero hero1 = hero.get(i);
                    hitTank(tank.shot, hero1);
                }
            }

            //实现敌人坦克的自由移动

            //刷新绘图区域
            this.repaint();
        }
    }
}
