package com.LJX.Tank_game04; /*
 * @author:小刘
 * @形成于思,毁于随----朱熹
 */

import java.util.Vector;

//敌人坦克
public class Hero extends Tank implements Runnable{
    //在敌人tank 中使用Vector, 保存多个shot
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;
    public Hero(int x, int y) {
        super(x, y);
    }


    @Override
    public void run() {
        setSpeed(2);
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //根据坦克的方向继续移动
            switch(getDirect()){
                case 0:
                    for (int i =0; i < 30; i++){
                        moveUp();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 1:
                    for (int i =0; i < 30; i++){
                        moveRight();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    for (int i =0; i < 30; i++){
                        moveDown();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    for (int i =0; i < 30; i++){
                        moveLeft();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //随机改变方向
            double newDirect = Math.random() * 4;
            int newDirect1 = (int) newDirect;
            this.setDirect(newDirect1);

            //一旦写并发程序，一定要考虑该线程什么时候停止
            if(!isLive){
                break;
            }
        }
    }
}
