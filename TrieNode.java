import java.util.Collections;
import java.util.LinkedList;

public class TrieNode implements Comparable<TrieNode> {
    public char nodeChar;
    public boolean terminal;
    public LinkedList<TrieNode> childList;
    public int count;
    int level;
    boolean isvisit;
    public TrieNode(char c){
        childList = new LinkedList<TrieNode>();
        terminal =false;
        nodeChar=c;
        count=0;
        level=0;
        isvisit=false;
    }

    public  LinkedList<TrieNode> getChildList(){
        return this.childList;
    }

    public boolean isTerminal(){
        return this.terminal;
    }

    public  TrieNode subNode(char nextChar){
        if(childList !=null){
            for(TrieNode eachChild : childList){
                if(eachChild.nodeChar==nextChar){
                    return eachChild;
                }
            }
        }

        return null;
    }

    public int compareTo(TrieNode o){
        TrieNode other =o;
        if(this.nodeChar <other.nodeChar){
            return -1;
        }
        if (this.nodeChar == other.nodeChar)
            return 0;
        return 1;
    }

    @Override
    public String toString() {
        return this.nodeChar+"("+this.terminal+") ";
    }


}
