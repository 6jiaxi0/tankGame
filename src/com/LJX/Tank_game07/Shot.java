package com.LJX.Tank_game07; /*
 * @author:小刘
 * @形成于思,毁于随----朱熹
 */

public class Shot implements Runnable{
    //子弹坐标
    int x;
    int y;

    int direct = 0;
    int speed = 10;
    //子弹是否存活
    boolean isLive = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while(true){
            //让线程休眠
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //根据方向,改变想x,y
            switch(direct){
                case 0:{
                    //上
                    y-=speed;
                    break;
                }
                case 1:
                    //右
                    x+=speed;
                    break;
                case 2:
                    //下
                    y+=speed;
                    break;
                case 3:
                    //左
                    x-=speed;
                    break;
            }
            //测试
            System.out.println("子弹 x = " + x + "y = " + y);
            //当子弹到达边界,销毁
            if(!(x >= 0 && x<= 1000 && y >= 0 && y <= 750 && isLive)){
                System.out.println("子弹线程退出...");
                isLive = false;
                break;
            }
        }
    }
}
