package skipList;

import java.time.temporal.Temporal;
import java.util.Random;
import java.util.Stack;

/**
 * @author Administrator
 */
public class SkipList<T> {
    SkipNode headNode;//头节点，入口
    int highLevel;//当前跳表索引层数
    Random random;// 用于投掷硬币
    final int MAX_LEVEL = 32;//最大的层

    SkipList(){
        random=new Random();
        headNode=new SkipNode(Integer.MIN_VALUE,null);
        highLevel=0;

    }

    public SkipNode search(int key) {
        SkipNode team = headNode;
        while (team != null){
            if (team.key == key){
                return team;
            }else if (team.right == null || team.right.key > key){
                team = team.down;
            }else {
                team = team.right;
            }
        }
        return null;
    }

    public void delete(int key){
        SkipNode team = headNode;
        while (team != null){
            if (team.right == null){
                team = team.down;
            }else if (team.right.key == key){
                team.right = team.right.right;
                team = team.down;
            }else if (team.right.key > key){
                team = team.down;
            }else {
                team = team.right;
            }
        }
    }

    public void add(SkipNode node){
        int key = node.key;
        SkipNode findNode = search(key);
        if (findNode != null){
            findNode.value = node.value;
            return;
        }
        Stack<SkipNode> stack = new Stack<>();
        SkipNode team = headNode;
        while (team != null){
            if (team.right == null){
                stack.add(team);
                team = team.down;
            }else if (team.right.key > key){
                stack.add(team);
                team = team.down;
            }else {
                team = team.right;
            }
        }
        int level = 1;
        SkipNode downNode = null;
        while (!stack.isEmpty()){
            team = stack.pop();
            //这个是要新加入的节点 第一次添加节点进来的时候，只有一层 就不用考虑是否有上一层了
            SkipNode nodeTeam = new SkipNode(node.key,node.value);
            nodeTeam.down = downNode;
            downNode = nodeTeam;
            if (team.right == null){
                //相当于右边已经没有了
                team.right = nodeTeam;
            }else {
                //相当于右边还有
                nodeTeam.right = team.right;
                team.right = nodeTeam;
            }
            if (level > MAX_LEVEL){
                break;
            }
            //在这里生成的随机数可能产生性能瓶颈，因为这个生成随机数底层为了保证随机数种子不一样，采用的是cas来保证种子的唯一性
            //所以在高并发情况下会产生性能瓶颈的 可以采用ThreadLocalRandom 来替代
            double num = random.nextDouble();
            if (num > 0.5){
                break;
            }
            level++;
            if (level > highLevel){
                highLevel = level;
                SkipNode highHeadNode = new SkipNode(Integer.MIN_VALUE,null);
                highHeadNode.down = headNode;
                headNode = highHeadNode;
                stack.add(headNode);
            }
        }

    }
    public void printList() {
        SkipNode teamNode=headNode;
        int index=1;
        SkipNode last=teamNode;
        while (last.down!=null){
            last=last.down;
        }
        while (teamNode!=null) {
            SkipNode enumNode=teamNode.right;
            SkipNode enumLast=last.right;
            System.out.printf("%-8s","head->");
            while (enumLast!=null&&enumNode!=null) {
                if(enumLast.key==enumNode.key)
                {
                    System.out.printf("%-5s",enumLast.key+"->");
                    enumLast=enumLast.right;
                    enumNode=enumNode.right;
                }
                else{
                    enumLast=enumLast.right;
                    System.out.printf("%-5s","");
                }

            }
            teamNode=teamNode.down;
            index++;
            System.out.println();
        }
    }

    /**
     * todo 作用和使用场景
     * @param args
     */
    public static void main(String[] args) {
        SkipList<Integer>list=new SkipList<Integer>();
        for(int i=1;i<20;i++)
        {
            list.add(new SkipNode(i,666));
        }
        list.printList();
        list.delete(4);
        list.delete(8);
        list.printList();
    }
}
