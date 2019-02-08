import cn.dlmu.edu.winter.model.Agent;
import cn.dlmu.edu.winter.model.Map;

import java.util.Arrays;


/**
 * @program: winter
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-01-31 14:53
 **/
public class Main {
//    人格						情绪							认知			社会地位			时间
//    开放性	外向性	宜人性	责任性	神经质		情绪1	情绪2	情绪3	情绪4	情绪5	情绪6		认知1	认知2		社会地位1	社会地位2
//    用户1	1	2	11	7	9		12	0	0	0	2	6		0	3		66	55		201803110810
//    用户2	2	2	2	3	4		2	32	23	12	2	3		32	3		93	34		201803120911
//    用户3	5	1	5	3	8		1	2	12	13	0	2		2	6		23	68		201803120323
//    用户4	2	6	8	3	3		2	5	22	0	0	8		5	4		88	98		201803110815
//    用户5	2	9	11	3	10		7	8	0	0	1	8		8	0		126	101		201803111520
//    用户6	1	4	3	3	9		4	9	0	2	3	9		9	0		29	44		201803121210
//    用户7	10	3	2	3	4		8	15	0	1	7	2		15	8		30	28		201803110900
//    用户8	17	23	2	3	6		4	23	0	1	8	2		23	9		20	31		201803111004

//    每个用户的数据包括五个部分：人格/情绪/认知/社会地位/时间
//
//    人格总共是五个维度，哪个维度的得分高，用户就属于哪个维度的人格，如果同时有两个或者多个维度较高，则用户的人格为多维度，同时具有多种人格。
//
//    用户交互过程的规则包括:
//    规则1：情绪1影响人格1的用户的行为；
//    规则2：情绪5影响人格5的用户的行为；
//    规则3：认知1影响人格3的用户的行为；
//    规则4：认知2影响人格2的用户的行为；
//    规则5：社会地位1影响人格3的用户的行为；
//    规则6：社会地位3影响人格4的的用户的行为。
//
//    用户间的交互满足交互规则，用户则根据影响他的用户的情绪和认知状态来更新自身的情绪和认知状态，同时行为变量计数即可。行为分为受情绪影响的行为/受认知影响的行为/受社会地位影响的行为，分三类计数，三类加一起也计数。

    public static void main(String[] args) {
        Map map = new Map(4,3);
        map.initAgents();
        while(!map.getQueue().isEmpty()){
            Agent agent = map.getQueue().peek();
            for (int i = 0; i < map.getSize_x(); i++) {
                for (int j = 0; j < map.getSize_y() ; j++) {
                    if(map.getStatus()[i][j]!=0){
                        agent.influenced(map.getMap()[i][j]);
                    }
                }
            }
            map.getQueue().poll();
        }
        System.out.println("---");
        Agent[][] agents = map.getMap();
        for (int i = 0; i <agents.length ; i++) {
            for (int j = 0; j <agents[i].length ; j++) {
                if(map.getStatus()[i][j]!=0) {
                    System.out.println();
                    System.out.println("id:"+agents[i][j].getId() +"---"+Arrays.toString(agents[i][j].getCount()));
                }
            }
        }
    }
    
}
