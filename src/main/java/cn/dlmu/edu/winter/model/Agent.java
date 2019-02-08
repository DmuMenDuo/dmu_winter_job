package cn.dlmu.edu.winter.model;

import sun.security.krb5.internal.crypto.Aes128;

import java.util.Arrays;
import java.util.Date;

/**
 * @program: winter
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-01-31 14:55
 **/
public class Agent {
    private int id; //唯一标识符
    //五个纬度的人格。
    private AgentType personality;
    //自带情绪。
    private AgentType emotion;
    // 认知
    private AgentType knowledge;
    //社会影响 两部分。静态社会影响。动态社会影响
    private AgentType society;
    private long date;
    private Location location;

    private int[] count; //计数器

    public Agent(int[] array) {
        personality = new AgentType(Arrays.copyOfRange(array,0,5));
        emotion = new AgentType(Arrays.copyOfRange(array,5,11));
        knowledge = new AgentType(Arrays.copyOfRange(array,11,13));
        society = new AgentType(Arrays.copyOfRange(array,13,15));
        date = array[array.length-1];
        count = new int[3]; //init counter
    }

    public void influenced(Agent agent){
        //这里要写规则了。。
        if(this.getDate()>agent.getDate()) return;
        //    用户交互过程的规则包括:
        //    规则1：情绪1影响人格1的用户的行为；
        if(this.emotion.getMain().contains(0)&&agent.getPersonality().getMain().contains(0)){
            agent.updateCount(agent,0,1);
        }
        //    规则2：情绪5影响人格5的用户的行为；
        if(this.emotion.getMain().contains(4)&&agent.getPersonality().getMain().contains(4)){
            agent.updateCount(agent,0,1);
        }
        //    规则3：认知1影响人格3的用户的行为；
        if(this.knowledge.getMain().contains(0)&&agent.getPersonality().getMain().contains(2)){
            agent.updateCount(agent,1,1);
        }
        //    规则4：认知2影响人格2的用户的行为；
        if(this.knowledge.getMain().contains(1)&&agent.getPersonality().getMain().contains(1)){
            agent.updateCount(agent,1,1);
        }
        //    规则5：社会地位1影响人格3的用户的行为；
        if(this.society.getMain().contains(0)&&agent.getPersonality().getMain().contains(2)){
            agent.updateCount(agent,2,1);
        }
        //    规则6：社会地位2影响人格4的的用户的行为。
        if(this.society.getMain().contains(1)&&agent.getPersonality().getMain().contains(3)){
            agent.updateCount(agent,1,1);
        }
    }



    public void updateCount(Agent agent,int index,int value){
        agent.count[index]+=value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AgentType getPersonality() {
        return personality;
    }

    public void setPersonality(AgentType personality) {
        this.personality = personality;
    }

    public int[] getCount() {
        return count;
    }

    public void setCount(int[] count) {
        this.count = count;
    }

    public AgentType getEmotion() {
        return emotion;
    }

    public void setEmotion(AgentType emotion) {
        this.emotion = emotion;
    }

    public AgentType getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(AgentType knowledge) {
        this.knowledge = knowledge;
    }

    public AgentType getSociety() {
        return society;
    }

    public void setSociety(AgentType society) {
        this.society = society;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
