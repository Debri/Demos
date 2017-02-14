package game;

import java.awt.*;
import java.util.Random;

/**
 * Created by Liuqi
 * Date: 2016/12/24.
 */
public class Ball {
    private final int BALL_SIZE = 16;//小球的大小
    private Frame f = new Frame("弹球游戏");
    Random rand = new Random();
    private int ySpeed = 8;//小球纵向的运行速度
    //返回一个-0.5-0.5的比率，用以控制小球的运行方向
    private double xyRate = rand.nextDouble() - 0.5;
    private int xSpeed = (int) (ySpeed * xyRate * 2);//小球的横向速度
    private int ballX = rand.nextInt(200) + 20;//小球的坐标
    private int ballY = rand.nextInt(10) + 20;
}
