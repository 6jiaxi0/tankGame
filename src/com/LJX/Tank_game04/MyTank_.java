package com.LJX.Tank_game04; /*
 * @author:小刘
 * @形成于思,毁于随----朱熹
 */


public class MyTank_ extends Tank {
    //定义一个shot对象

    Shot shot = null;

    public MyTank_(int x, int y) {
        super(x, y);
    }

    //射击
    public void shotEnemyTank() {
        //创建Shot对象，根据坦克的方向得到子弹方向
        switch (getDirect()) {
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
        //启动Shot线程
        new Thread(shot).start();
    }


}
