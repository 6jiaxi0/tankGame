package com.LJX.Tank_game06; /*
 * @author:小刘
 * @形成于思,毁于随----朱熹
 */

public class Bomb {
    int x,y;
    //炸弹的生命周期
    int life = 9;
    boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown(){
        if(life > 0){
            life--;
        }else{
            isLive = false;
        }
    }

}
