import java.util.*;

public class Trie {
    private TrieNode root;
    public int cnt;

    public Trie(){
        root = new TrieNode('\u0000');
        cnt=0;
    }

    public void insert(String word){
        if(search(word)) return;
        TrieNode current = root;
        for(char ch: word.toCharArray()){
            TrieNode child = current.subNode(ch);
            if(child!=null){
                current=child;
            }
            else {
                TrieNode temp = new TrieNode(ch);
                temp.level=current.level+1;
                current.getChildList().add(temp);
                current = current.subNode(ch);
            }
            current.count++;
        }
        current.terminal=true;
    }

    public boolean search(String word){
        TrieNode current = root;

        for(char c: word.toCharArray()){
            if(current.subNode(c)==null) return false;
            else{
                current= current.subNode(c);
            }
        }
        if(current.isTerminal()) return true;
        return false;
    }

    public void remove(String word){
        if(!search(word)) return;
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            TrieNode child = current.subNode(ch);
            if(child.count==1){
                current.getChildList().remove(child);
                return;
            }
            else{
                child.count--;
                current=child;
            }
        }
        current.terminal=false;
    }
    public Iterator<String> iterator() {
        Set<String> elementsInTrie = new TreeSet<String>();

        recursiveCallPrint(root, "", elementsInTrie); // 저장된 데이터를 elementsInTrie에 저장
        Iterator<String> elementsInTrieSet = elementsInTrie.iterator();

        return elementsInTrieSet;
    }

    private void recursiveCallPrint(TrieNode currNode, String key, Set<String> elementsInTrie) {
        // adding only the words
        if (currNode.terminal) {
            elementsInTrie.add(key);
        }

        LinkedList<TrieNode> children = currNode.childList;
        Iterator<TrieNode> childIter = children.iterator();

        String sKey = key;

        while (childIter.hasNext()) {
            TrieNode nextNode = childIter.next();
            // 문자열 합치기 (키+문자)
            String s = sKey + nextNode.nodeChar;
            // 재귀 호출 (다음 노드, 키값, 저장셋)
            recursiveCallPrint(nextNode, s, elementsInTrie);
        }
    }

    public void printWord() {

        System.out.println("▶Elements in the TRIE are :");

        Iterator<String> itr = iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("===================");
    }

    public void cal() {
        TrieNode current = root;
        Stack<TrieNode> st = new Stack<TrieNode>();
        st.add(current);
        current.isvisit=true;
        while (!st.isEmpty()) {
            boolean isvisit = false;
            current = st.peek();
                for(int i=0; i<current.getChildList().size();i++){

                    TrieNode temp = current.getChildList().get(i);
                    if(temp.isvisit)continue;
                    isvisit = true;
                    if (temp.count == 1) {
                        cnt += temp.level;
                        isvisit=false;
                        continue;
                    }
                    if (temp.terminal) {
                        cnt += temp.level;

                    }
                    temp.isvisit=true;
                    st.push(temp);
                    break;
                }

            if (!isvisit) {
                st.pop();
            }

        }
    }


}
