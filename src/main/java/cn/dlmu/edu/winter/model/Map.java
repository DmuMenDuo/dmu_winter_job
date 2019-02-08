package cn.dlmu.edu.winter.model;

import cn.dlmu.edu.winter.utils.DataUtils;

import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @program: winter
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-02 14:30
 **/
public class Map {
    private Agent[][] map; //二维地图
    private int[][] status; //标记当前位置是否有agent占用
    private PriorityQueue<Agent> queue; //一个优先队列
    private int size_x; //地图x方向的长度
    private int size_y; //地图y方向的长度
    private int mapSize; //我的想法是 sizeX * sizeY = agentCount * mapSize
    private int influenceSize; //一个agent的可影响范围

    public Map( int mapSize, int influenceSize) {
        this.size_x = mapSize;
        this.size_y = mapSize;
        this.mapSize = mapSize;
        this.influenceSize = influenceSize;
        this.queue = new PriorityQueue<Agent>((o1, o2) -> o1.getDate()>=o2.getDate()?1:-1);
        this.map = new Agent[size_x][size_y];
        this.status = new int[size_x][size_y];
    }

    public PriorityQueue<Agent> getQueue() {
        return queue;
    }

    public void setQueue(PriorityQueue<Agent> queue) {
        this.queue = queue;
    }

    public int getSize_x() {
        return size_x;
    }

    public void setSize_x(int size_x) {
        this.size_x = size_x;
    }

    public Agent[][] getMap() {
        return map;
    }

    public void setMap(Agent[][] map) {
        this.map = map;
    }

    public int[][] getStatus() {
        return status;
    }

    public void setStatus(int[][] status) {
        this.status = status;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public int getInfluenceSize() {
        return influenceSize;
    }

    public void setInfluenceSize(int influenceSize) {
        this.influenceSize = influenceSize;
    }

    public int getSize_y() {
        return size_y;
    }

    public void setSize_y(int size_y) {
        this.size_y = size_y;
    }

    public void initAgents(){
        Random random = new Random();
        int max = mapSize;
        int min = 0;
        for (int i = 0; i < 8 ; i++) {
            int[] data = DataUtils.getData(i);
            Agent agent = new Agent(data);
            agent.setId(i);
            int x,y;
            while (true){
                x = random.nextInt(max)%(max-min+1) +min;
                y = random.nextInt(max)%(max-min+1) +min;
                if(status[x][y]==0) break;
            }
            agent.setLocation(new Location(x,y));
            status[x][y]=1;
            map[x][y] = agent;
            this.queue.add(agent);//放入优先队列
        }
    }

}
