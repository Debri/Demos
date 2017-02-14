package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Created by Liuqi
 * Date: 2016/12/24.
 */
public class Game {
    private final int TABLE_WIDTH = 300;//桌面的宽度
    private final int TABLE_HEIGHT = 400;//桌面的高度
    private final int RACKET_HEIGHT = 20;//球拍的高度
    private final int RACKET_WIDTH = 60;//球拍的宽度
    private final int BALL_SIZE = 16;//小球的大小
    private Frame f = new Frame("弹球游戏");
    Random rand = new Random();
    private int ySpeed = 8;//小球纵向的运行速度
    //返回一个-0.5-0.5的比率，用以控制小球的运行方向
    private double xyRate = rand.nextDouble() - 0.5;
    private int xSpeed = (int) (ySpeed * xyRate * 2);//小球的横向速度
    private int ballX = rand.nextInt(200) + 20;//小球的坐标
    private int ballY = rand.nextInt(10) + 20;
    private int racketY = 340;//球拍的垂直位置
    private int racketX = rand.nextInt(200);//球拍的水平位置
    private Game.MyCanvas tableArea = new Game.MyCanvas();
    Timer timer;
    private boolean isLose = false;//游戏是否结束的旗标

    public static void main(String[] args) {
        new Game().init();
    }

    /**
     * 初始化游戏
     */
    public void init() {
        long start = System.currentTimeMillis();
        tableArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        f.add(tableArea);
        // 创建一个 Timer 并将初始延迟和事件间延迟初始化为 100 毫秒
        Thread baffle = new Thread(new Baffle());
        Thread ball = new Thread(new Ball());
        baffle.start();
        ball.start();
        f.pack();
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    class Ball implements Runnable {
        public void run() {
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    //如果小球碰到左边边框
                    if (ballX <= 0 || ballX >= TABLE_WIDTH - BALL_SIZE) {
                        xSpeed = -xSpeed;
                    }
                    //如果小球高度超出了球拍位置且横向不在球拍范围之内，游戏结束
                    if (ballY >= racketY - BALL_SIZE && (ballX < racketX || ballX > racketX + RACKET_WIDTH)) {
                        timer.stop();
                        isLose = true;
                        tableArea.repaint();
                    }
                    //如果小球位于球拍之间，且达到球拍位置，小球反弹
                    else if (ballY <= 0 || (ballY >= racketY - BALL_SIZE && ballX > racketX && ballX <= racketX + RACKET_WIDTH)) {
                        ySpeed = -ySpeed;
                    }
                    ballY += ySpeed;
                    ballX += xSpeed;
                    tableArea.repaint();
                }
            };
            // 创建一个 Timer 并将初始延迟和事件间延迟初始化为 100 毫秒
            timer = new Timer(100, taskPerformer);
            timer.start();
        }
    }

    class Baffle implements Runnable {
        public void run() {
            KeyAdapter keyProcessor = new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    //按左键水平坐标减少
                    if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                        if (racketX > 0)
                            racketX -= 10;
                    }
                    //按右键水平坐标增加
                    if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                        if (racketX < TABLE_WIDTH - RACKET_WIDTH)
                            racketX += 10;
                    }
                    if (ke.getKeyCode() == KeyEvent.VK_UP) {
                        if (racketY > RACKET_HEIGHT + 10) {
                            racketY -= 10;
                        }
                    }
                    if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
                        if (racketY < TABLE_HEIGHT - RACKET_HEIGHT) {
                            racketY += 10;
                        }
                    }
                }
            };
            f.addKeyListener(keyProcessor);
            tableArea.addKeyListener(keyProcessor);
        }
    }


    class MyCanvas extends Canvas {
        public void paint(Graphics g) {
            if (isLose) {
                g.setColor(Color.RED);
                g.setFont(new Font("Times", Font.BOLD, 30));
                g.drawString("圣诞快乐", 50, 200);
                //g.drawString("游戏结束了" , 50, 200);
            } else {
                g.setColor(Color.YELLOW);
                g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
                g.setColor(Color.GREEN);
                g.fillRect(racketX, racketY, RACKET_WIDTH, RACKET_HEIGHT);
            }
        }
    }
}
