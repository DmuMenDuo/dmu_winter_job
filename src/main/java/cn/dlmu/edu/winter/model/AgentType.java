package cn.dlmu.edu.winter.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: winter
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-01-31 14:57
 **/
public class AgentType {
    private int[] values;
    private List<Integer> main;

    public AgentType(int[] values) {
        this.values = values;
        generalMain();
    }

    /**
     * 生成主属性？？？
     */
    private void generalMain() {
        main = new ArrayList<Integer>();
        int[] tmp = values.clone();
        Arrays.sort(tmp);
        int max = tmp[tmp.length-1];
        for (int i = 0; i < values.length ; i++) {
            if(values[i] == max) main.add(i);
        }
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    public List<Integer> getMain() {
        return main;
    }

    public void setMain(List<Integer> main) {
        this.main = main;
    }
}
