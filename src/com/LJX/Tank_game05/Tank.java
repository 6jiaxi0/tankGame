package com.LJX.Tank_game05; /*
 * @author:小刘
 * @形成于思,毁于随----朱熹
 */

public class Tank {
    private int x;
    private int y;
    //坦克的方向,0 1 2 3
    private int direct;

    private int speed = 1;
    //上右下左移动方法
    public void moveUp(){
        if(getY() > 0){
            y-=speed;
        }
    }
    public void moveRight(){
        if(getX()+60 < 1000){
            x+=speed;
        }
    }
    public void moveDown(){
       if(getY() +60 < 750){
           y+=speed;
       }
    }
    public void moveLeft(){
        if(getX() > 0) {
            x -= speed;
        }
    }



    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
