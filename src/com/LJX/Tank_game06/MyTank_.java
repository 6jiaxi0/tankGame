package com.LJX.Tank_game06; /*
 * @author:小刘
 * @形成于思,毁于随----朱熹
 */


import java.util.Vector;

public class MyTank_ extends Tank {
    //定义一个shot对象
    Shot shot = null;
    //定义可以发射多个子弹
    Vector<Shot> shots = new Vector<>();

    public MyTank_(int x, int y) {
        super(x, y);
    }

    //射击
    //控制面板一次只能有5颗子弹
    public void shotEnemyTank() {
        if(this.shots.size() == 5){
            return;
        }
        //创建Shot对象，根据坦克的方向得到子弹方向
        switch (getDirect()){
            case 0: {
                shot = new Shot(getX() + 20, getY() + 2, 0);
                break;
            }
            case 1: {
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            }
            case 2: {
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            }
            case 3: {
                shot = new Shot(getX(), getY() + 20, 3);
                break;
            }
        }
        //新创建的shot 放入shots
        shots.add(shot);
        //启动Shot线程
        new Thread(shot).start();
    }


}
