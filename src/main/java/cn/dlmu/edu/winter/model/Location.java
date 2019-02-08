package cn.dlmu.edu.winter.model;

/**
 * @program: winter
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-07 00:54
 **/
public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
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
}
