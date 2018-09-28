import java.util.ArrayList;

public class Kakao5 {

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        Node[] nodeList = new Node[nodeinfo.length];
        for(int i=0; i<nodeinfo.length;i++){
            int nodex= nodeinfo[i][0];
            int nodey= nodeinfo[i][1];
            int nodenum=i+1;
            nodeList[i]= new Node(nodex,nodey,nodenum);
        }
        sortNode(nodeList);
        Tree findRoute = new Tree(nodeList[0]);
        for(int i=1; i<nodeList.length; i++){
            findRoute.addNode(nodeList[i],findRoute.root);
        }

        findRoute.postorder(findRoute.root);
        findRoute.preorder(findRoute.root);


        answer = new int[2][findRoute.postorderList.size()];
        for(int i=0; i<2; i++){
            for(int j=0;j<findRoute.postorderList.size(); j++){
                if(i==0)
                    answer[i][j] = findRoute.preorderList.get(j);
                else
                    answer[i][j]= findRoute.postorderList.get(j);
            }
        }
        return answer;

    }

    public void sortNode(Node[] inputList){
        int max;
        for(int i=0; i<inputList.length; i++){
            max=inputList[i].y;
            for(int j=i+1; j<inputList.length; j++){
                if(max<inputList[j].y){
                    max=inputList[j].y;
                    Node temp = inputList[i];
                    inputList[i]= inputList[j];
                    inputList[j]=temp;
                }
            }
        }
    }
    public class Node{
        int num;
        int x;
        int y;
        Node left;
        Node right;


        public Node(int inputX,int inputY, int inputNum){
            x=inputX;
            y=inputY;
            num = inputNum;
            this.left=null;
            this.right=null;

        }
        public Node left(){
            return this.left;
        }
        public void setLeft(Node inputNode){
            this.left= inputNode;
        }

        public Node right(){
            return this.right;
        }

        public void setRight(Node inputNode){
            this.right = inputNode;
        }


    }

    public class Tree{
        Node root;
        ArrayList<Integer> preorderList = new ArrayList<Integer>();
        ArrayList<Integer> postorderList = new ArrayList<Integer>();

        public Tree(Node rootNode){
            this.root = rootNode;

        }

        public void addNode(Node inputNode, Node rootNode){
            if(rootNode !=null) {
                if (inputNode.x < rootNode.x) {
                    if (rootNode.left() != null) {
                        addNode(inputNode, rootNode.left());
                    } else {
                        rootNode.setLeft(inputNode);

                    }
                } else if (inputNode.x > rootNode.x) {
                    if (rootNode.right() != null) {
                        addNode(inputNode, rootNode.right());
                    } else {
                        rootNode.setRight(inputNode);

                    }
                }
            }
        }

        public void preorder(Node temp){
            if(temp!=null)
                preorderList.add(temp.num);
            if(temp.left()!=null)
                preorder(temp.left());
            if(temp.right()!=null)
                preorder(temp.right());

        }

        public void postorder(Node temp){
            if(temp.left()!=null)
                postorder(temp.left());

            if(temp.right()!=null)
                postorder(temp.right());
            if(temp !=null)
                postorderList.add(temp.num);
        }


    }

    public static void main(String[] args) {

    }
}
