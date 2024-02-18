package com.LJX.Tank_game07;

import javax.xml.soap.Node;
import java.io.*;
import java.util.Vector;

/**
 * @ author:小刘
 * @ 形成于思,毁于随----朱熹
 * 该类用于记录相关信息，和文件交互
 */

public class Record_ {
    //定义变量，记录我方击毁坦克树
    private static int allEnemyTankNum = 0;

    //定义IO对象,准备写数据到文件中
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordFile = "D:\\java_code\\myRecord1.txt";
    private static Vector<Hero> enemyTanks = null;

    public static void setEnemyTanks(Vector<Hero> enemyTanks) {
        Record_.enemyTanks = enemyTanks;
    }

    //定义一个保存Node 的Vector
    private static Vector<Node_> nodes = new Vector<>();

    //增加方法，读取文件，恢复信息
    public static Vector<Node_> getNodesAndEnemyTankRec(){

        try {
          br = new BufferedReader(new FileReader(recordFile));
          allEnemyTankNum = Integer.parseInt(br.readLine());
          String line;
          while((line = br.readLine()) != null){
              String[] xyd = line.split(" ");
              Node_ node = new Node_(Integer.parseInt(xyd[0])
                      ,Integer.parseInt(xyd[1])
                      ,Integer.parseInt(xyd[2]));
              nodes.add(node);
          }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return nodes;
    }


    //但我们退出游戏时,将 allEnemyTankNum 保存到recordFIle
    //对keepRecord进行升级,保存敌人的坐标和方向
    public static void keepRecord() throws IOException {
        try {
            bw = new BufferedWriter(new FileWriter(Record_.recordFile));
            bw.write(allEnemyTankNum + "\r\n");

            //要取得敌人坦克的 坐标和方向，就要遍历敌人坦克
            //OOP思想,定义Vector，通过set方法在mypanel中取得存贮敌人坦克的集合
            for (int i = 0; i < enemyTanks.size(); i++) {
                if (enemyTanks.get(i).isLive) {
                    System.out.println("======" + enemyTanks.get(i).getX()+ enemyTanks.get(i).getY()+ "=============");
                    String record = enemyTanks.get(i).getX() + " " + enemyTanks.get(i).getY() + " " + enemyTanks.get(i).getDirect();
                    bw.write(record + "\r\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
           if(bw != null){
               bw.close();
           }
        }
    }


    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Record_.allEnemyTankNum = allEnemyTankNum;
    }

    public static void addAllEnemyTankNum() {
        Record_.allEnemyTankNum++;
    }
}
