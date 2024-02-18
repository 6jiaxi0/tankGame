package com.LJX.Tank_game07; /*
 * @author:小刘
 * @形成于思,毁于随----朱熹
 * 用于要保存的坦克对象的坐标和位置
 */

public class Node_ {
    private int x;
    private int y;
    private int direct;


    public Node_(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
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
}
