package game1;

/**
 * Created by Liuqi
 * Date: 2016/10/8
 * Email: 18908356464@163.com
 * Project: Demos
 */

import java.util.Random;

/**
 * 电脑下棋的AI
 * 必须先setAI()，再调用getAIX()和getAIY()
 */
public class AI {
    private Color[][] chess; //棋盘落子情况
    private Color myColor; //AI所执棋子颜色
    private Color antiColor;//对方（也就是玩家）所执的颜色
    private int bestX, bestY; //最优落子位置
    private int effectiveX1, effectiveY1, effectiveX2, effectiveY2; //棋盘的有效位置，一个比现有棋子范围大一圈的矩形
    private Color[] colorArr = new Color[]{Color.black, Color.white};
    private Random rand = new Random(); //用于随机落子
//	int antiBlockX1 = -1, antiBlockY1 = -1; //堵住我方棋子的对方棋子坐标，-1表示无棋子
//	int antiBlockX2 = -1, antiBlockY2 = -1; //堵住我方棋子的对方棋子坐标，-1表示无棋子


    /**
     * 传入当前落子情况及电脑所执颜色
     * 由于程序中先创建AI的实例，再根据不同的chess数组运算下一步落子
     * 不再适合使用构造器
     */
    public boolean setAI(Color[][] chess, Color myColor) {
        this.chess = chess;
        this.myColor = myColor;
        this.antiColor = myColor == Color.black ? Color.white : Color.black;
        findEffectiveArea();
        findBestPosition();
        return true;
    }

    /**
     * 返回计算后的X坐标
     */
    public int getAIX() {
        return bestX;
    }

    /**
     * 返回计算后的Y坐标
     */
    public int getAIY() {
        return bestY;
    }

    /**
     * 找出棋盘的有效范围
     */
    private void findEffectiveArea() {
        int offset; //外移的圈数
        //先对effectiveX1等赋初值，再扩大
        for (int i = 0; i <= 14; i++) {
            for (int j = 0; j <= 14; j++) {
                if (chess[i][j] != null) { //该位置有棋子，才开始判断
                    //先找与现有棋子范围相切的矩形
                    effectiveX1 = i;
                    effectiveY1 = j;
                    effectiveX2 = i;
                    effectiveY2 = j;
                }
            }
        }
        for (int i = 0; i <= 14; i++) {
            for (int j = 0; j <= 14; j++) {
                if (chess[i][j] != null) { //该位置有棋子，才开始判断
                    //先找与现有棋子范围相切的矩形
                    effectiveX1 = effectiveX1 > i ? i : effectiveX1;
                    effectiveY1 = effectiveY1 > j ? j : effectiveY1;
                    effectiveX2 = effectiveX2 < i ? i : effectiveX2;
                    effectiveY2 = effectiveY2 < j ? j : effectiveY2;
                }
            }
        }
        offset = 2;
        effectiveX1 = (effectiveX1 - offset) >= 0 ? effectiveX1 - offset : effectiveX1;
        effectiveY1 = (effectiveY1 - offset) >= 0 ? effectiveY1 - offset : effectiveY1;
        effectiveX2 = (effectiveX2 + offset) <= 14 ? effectiveX2 + offset : effectiveX2;
        effectiveY2 = (effectiveY2 + offset) <= 14 ? effectiveY2 + offset : effectiveY2;
    }

    /**
     * 找出最合适的下子位置
     */
    private void findBestPosition() {
        int tempScore = 0;//暂存分数，用以遍历
        int realGetScore; //储存返回值
        bestX = effectiveX1;//初始化最优坐标
        bestY = effectiveY1;
        for (int x = effectiveX1; x <= effectiveX2; x++) {
            for (int y = effectiveY1; y <= effectiveY2; y++) {
                if (chess[x][y] == null) { //此处无子，则判断
                    if (tempScore < getScore(x, y)) {
                        bestX = x;
                        bestY = y;
                        tempScore = getScore(x, y);
                    }
                }
            }
        }
        //如果分数为0，即无适合选择，则随机落子
        if (tempScore == 0) {
            bestX = effectiveX1 + rand.nextInt(effectiveX2 + 1 - effectiveX1);
            bestY = effectiveY1 + rand.nextInt(effectiveY2 + 1 - effectiveY1);
        }
    }

    /**
     * 某位置是否有指定颜色的棋子
     * 边界也能堵住已方棋子，与敌方棋子等效
     * 1为已方，-1为对方或边界，0为无棋子
     */
    private int contains(int x, int y, Color color) {
        if (x < 0 || x > 14 || y < 0 || y > 14) {
            return -1;
        } else if (chess[x][y] == color) {
            return 1;
        } else if (chess[x][y] == null) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 算出某位置的得分
     * 先算四个方向的棋子数，再调用算分方法
     */
    private int getScore(int x, int y) {
        int tempX = x;//将传入的x保存以待复位
        int tempY = y;
        int count = 0;//同一条直线上相连的同色棋子数
        int block = 0;//相连棋子尽头阻塞数
        int totalScore = 0;//部分，用于返回
        //先计算横向
        //已方与敌方都要检测
        for (Color color : colorArr) {
            //先判断横向
            x = tempX;
            y = tempY;
            count = 0;
            block = 0;
            while (contains(x - 1, y, color) == 1) { //同色棋子，则继续左移
                x--;
                count++;
            }
            if (contains(x - 1, y, color) == -1) { //若被堵住，则计数
                block++;
            }
            x = tempX;//复位，重新开始
            y = tempY;
            while (contains(x + 1, y, color) == 1) {
                x++;
                count++;
            }
            if (contains(x + 1, y, color) == -1) {
                block++;
            }
            count++;
            totalScore += countToScore(count, block, color);
            //再判断纵向
            x = tempX;
            y = tempY;
            count = 0;
            block = 0;
            while (contains(x, y - 1, color) == 1) {
                y--;
                count++;
            }
            if (contains(x, y - 1, color) == -1) {
                block++;
            }
            x = tempX;
            y = tempY;
            while (contains(x, y + 1, color) == 1) {
                y++;
                count++;
            }
            if (contains(x, y + 1, color) == -1) {
                block++;
            }
            count++;//前面未计入初始位置，此处加上
            totalScore += countToScore(count, block, color);
            //再判断左上到右下
            x = tempX;
            y = tempY;
            count = 0;
            block = 0;
            while (contains(x - 1, y - 1, color) == 1) {
                x--;
                y--;
                count++;
            }
            if (contains(x - 1, y - 1, color) == -1) {
                block++;
            }
            x = tempX;
            y = tempY;
            while (contains(x + 1, y + 1, color) == 1) {
                x++;
                y++;
                count++;
            }
            if (contains(x + 1, y + 1, color) == -1) {
                block++;
            }
            count++;
            totalScore += countToScore(count, block, color);
            //再判断左下到右上
            x = tempX;
            y = tempY;
            count = 0;
            block = 0;
            while (contains(x - 1, y + 1, color) == 1) {
                x--;
                y++;
                count++;
            }
            if (contains(x - 1, y + 1, color) == -1) {
                block++;
            }
            x = tempX;
            y = tempY;
            while (contains(x + 1, y - 1, color) == 1) {
                x++;
                y--;
                count++;
            }
            if (contains(x + 1, y - 1, color) == -1) {
                block++;
            }
            count++;
            totalScore += countToScore(count, block, color);
        }
        return totalScore;
    }

    /**
     * 将棋子数换算成分数
     */
    private int countToScore(int count, int block, Color color) {
        if (block == 2) return 0; //return直接结束方法，故下面不需要else。
        //下面按草稿的顺序计分
        if (count == 5 && color == myColor) return 1000000000; //下一步已方成五，执之
        if (count == 5 && color == antiColor) return 100000000; //下一步对手成五，堵之
        if (count == 4 && color == myColor && block == 0) return 10000000; //下一步已方活四，执之
        if (count == 4 && color == myColor && block == 1) return 1000000; //下一步已方冲四，执之
        if (count == 4 && color == antiColor && block == 0) return 100000; //下一步对手活四，堵之
        if (count == 3 && color == myColor && block == 0) return 10000; //下一步已方活三，执之
        if (count == 4 && color == antiColor && block == 1) return 1000; //下一步对手冲四，堵之  ******敌手冲四，已方可以堵实或空一位堵，该想法未实现
        if (count == 3 && color == myColor && block == 1) return 100; //下一步已方眠三（一头被堵），执之
        if (count == 2 && color == myColor && block == 0) return 10; //下一步已方活二，执之
        if (count == 2 && color == myColor && block == 1) return 1; //下一步已方冲二，执之
        //***********同一个位置，对手的该位置得分也可以加成到已方得分上，该想法未实现
        return 0; //剩余情况一律返回0;
    }
}
