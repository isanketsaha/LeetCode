package StudyPlan.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class CloneGraph {

    public static void main(String[] args) {
//        new CloneGraph().cloneGraph();
    }
    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> map = new HashMap<>();
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        Node startPoint = null;
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            Node vertex =  map.getOrDefault(pop.val, new Node(pop.val, new ArrayList()));
            if(startPoint == null){
                startPoint =  vertex;
            }
            for(Node n : pop.neighbors){
                Node child =  map.getOrDefault(n.val, new Node(n.val, new ArrayList()));
                vertex.neighbors.add(child);
                stack.push(child);
            }
        }
        return startPoint;
    }
}
