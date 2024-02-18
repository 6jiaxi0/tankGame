package com.LJX.Tankgame; /*
 * @author:小刘
 * @形成于思,毁于随----朱熹
 */

import java.util.Vector;

//敌人坦克
public class Hero extends Tank implements Runnable{
    //在敌人tank 中使用Vector, 保存多个shot
    Vector<Shot> shots = new Vector<>();
    //增加成员,使用Vector,可以得到敌人坦克的Vector
    Vector<Hero> enemyTanks = new Vector<>();
    public void setEnemyTanks(Vector<Hero> enemyTanks) {
        this.enemyTanks = enemyTanks;
        //这里提供一个方法得到Mypanel里的敌人坦克对象 Vector<Hero> hero = new Vector<>();
        //设置到EnemyTank 的成员 enemyTanks
    }

    public Vector<Hero> getEnemyTanks() {
        return enemyTanks;
    }

    //编写方法,判断这个敌人坦克，是否发生重叠或碰撞
    public boolean isTouchEnemyTank(){
        //判断敌人坦克方向（this）
        switch(this.getDirect()){
            case 0:{
                //上
                //然当前的坦克与敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从vector中取出一辆坦克
                    Hero enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if(enemyTank != this){
                        //如果敌人坦克方向是上/下
                        //代码分析：
                        //x 的范围[x,x+40]
                        //y 的范围[y,y+60]
                        if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            //坦克 左上角坐标[x,y]
                            if(this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX()+40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60){
                                return true;
                            }
                            //坦克 右上角坐标[x + 40, y]
                            if(this.getX()+40 >= enemyTank.getX()
                                    && this.getX()+40 <= enemyTank.getX()+40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        //如果敌人坦克方向是左/右
                        //代码分析：
                        //x 的范围[x,x+60]
                        //y 的范围[y,y+40]
                        if(enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3){
                            //坦克 左上角坐标[x,y]
                            if(this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX()+60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40){
                                return true;
                            }
                            //坦克 右上角坐标[x + 40, y]
                            if(this.getX()+40 >= enemyTank.getX()
                                    && this.getX()+40 <= enemyTank.getX()+60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;
            }
            case 1:{
                //右
                //然当前的坦克与敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从vector中取出一辆坦克
                    Hero enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if(enemyTank != this){
                        //如果敌人坦克方向是上/下
                        //代码分析：
                        //x 的范围[x,x+40]
                        //y 的范围[y,y+60]
                        if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            //坦克 右上角坐标[x+60,y]
                            if(this.getX()+60 >= enemyTank.getX()
                                    && this.getX()+60 <= enemyTank.getX()+40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60){
                                return true;
                            }
                            //坦克 右下角坐标[x + 60, y + 40]
                            if(this.getX()+60 >= enemyTank.getX()
                                    && this.getX()+60 <= enemyTank.getX()+40
                                    && this.getY() +40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        //如果敌人坦克方向是左/右
                        //代码分析：
                        //x 的范围[x,x+60]
                        //y 的范围[y,y+40]
                        if(enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3){
                            //坦克 右上角坐标[x+60,y]
                            if(this.getX()+60 >= enemyTank.getX()
                                    && this.getX()+60 <= enemyTank.getX()+40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60){
                                return true;
                            }
                            //坦克 右下角坐标[x + 60, y + 40]
                            if(this.getX()+60 >= enemyTank.getX()
                                    && this.getX()+60 <= enemyTank.getX()+40
                                    && this.getY() +40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                    }
                }
                break;
            }

            case 2:{
                //下
                //然当前的坦克与敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从vector中取出一辆坦克
                    Hero enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if(enemyTank != this){
                        //如果敌人坦克方向是上/下
                        //代码分析：
                        //x 的范围[x,x+40]
                        //y 的范围[y,y+60]
                        if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            //坦克 左下角坐标[x,y + 60]
                            if(this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX()+40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60){
                                return true;
                            }
                            //坦克 右下角坐标[x + 40, y + 60]
                            if(this.getX()+40 >= enemyTank.getX()
                                    && this.getX()+40 <= enemyTank.getX()+40
                                    && this.getY() +60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        //如果敌人坦克方向是左/右
                        //代码分析：
                        //x 的范围[x,x+60]
                        //y 的范围[y,y+40]
                        if(enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3){
                            //坦克 左下角坐标[x,y + 60]
                            if(this.getX()>= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX()+40
                                    && this.getY()+60 >= enemyTank.getY()
                                    && this.getY()+60 <= enemyTank.getY() + 40){
                                return true;
                            }
                            //坦克 右下角坐标[x + 40, y + 60]
                            if(this.getX()+40 >= enemyTank.getX()
                                    && this.getX()+40 <= enemyTank.getX()+40
                                    && this.getY() +60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                    }
                }
                break;
            }
            case 3:{
                //左
                //然当前的坦克与敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从vector中取出一辆坦克
                    Hero enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if(enemyTank != this){
                        //如果敌人坦克方向是上/下
                        //代码分析：
                        //x 的范围[x,x+40]
                        //y 的范围[y,y+60]
                        if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            //坦克 左上角坐标[x,y]
                            if(this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX()+40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60){
                                return true;
                            }
                            //坦克 左下角坐标[x, y + 40]
                            if(this.getX()>= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX()+40
                                    && this.getY() +40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        //如果敌人坦克方向是左/右
                        //代码分析：
                        //x 的范围[x,x+60]
                        //y 的范围[y,y+40]
                        if(enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3){
                            //坦克 左上角坐标[x,y]
                            if(this.getX()>= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX()+40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40){
                                return true;
                            }
                            //坦克 左下角坐标[x, y + 40]
                            if(this.getX()>= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX()+40
                                    && this.getY() +40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                    }
                }
                break;
            }

        }
        return false;
    }

    boolean isLive = true;
    public Hero(int x, int y) {
        super(x, y);
    }


    @Override
    public void run() {
        setSpeed(2);
        while (true) {
            if (isLive && shots.size() < 2) {
                Shot shot1 = null;
                switch (getDirect()) {
                    case 0: {
                        shot1 = new Shot(getX() + 20, getY(), 0);
                        break;
                    }
                    case 1: {
                        shot1 = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    }
                    case 2: {
                        shot1 = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    }
                    case 3: {
                        shot1 = new Shot(getX(), getY() + 20, 3);
                        break;
                    }
                }
                shots.add(shot1);
                new Thread(shot1).start();
            }
            //根据坦克的方向继续移动
            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (!this.isTouchEnemyTank()) {
                            moveUp();
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (!isTouchEnemyTank()) {
                            moveRight();
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (!isTouchEnemyTank()) {
                            moveDown();
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (!isTouchEnemyTank()) {
                            moveLeft();
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    break;
            }
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            //随机改变方向
            double newDirect = Math.random() * 4;
            int newDirect1 = (int) newDirect;

            this.setDirect(newDirect1);

            //一旦写并发程序，一定要考虑该线程什么时候停止
            if (!isLive) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
