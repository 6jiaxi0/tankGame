package com.LJX.Tank_game05; /*
 * @author:小刘
 * @形成于思,毁于随----朱熹
 */

import java.util.Vector;

//敌人坦克
public class Hero extends Tank implements Runnable {
    //在敌人tank 中使用Vector, 保存多个shot
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;

    @Override
    public void run() {
        this.setSpeed(5);
        while (true) {
            double newDirect = Math.random() * 4;
            int newDirect1 = (int) newDirect;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //随机改变 坦克的方向
            switch (newDirect1) {
                case 0: {
                    //上
                    this.setDirect(0);
                    this.moveUp();
                    break;
                }
                case 1:
                    //右
                    this.setDirect(1);
                    this.moveRight();
                    break;
                case 2:
                    //下
                    this.setDirect(2);
                    this.moveDown();
                    break;
                case 3:
                    //左
                    this.setDirect(3);
                    this.moveLeft();
                    break;
            }
            //随机改变坦克的行进

        }
    }

    //实现敌人坦克的移动方法
    public void randoMove() {
        if (!isLive) {
            return;
        }

    }


    public Hero(int x, int y) {
        super(x, y);
    }
}
