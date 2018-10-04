public class Kakao_5 {

    public static void main(String[] args) {
        Trie tree = new Trie();
        tree.insert("word");
        tree.insert("war");
        tree.insert("warrior");
        tree.insert("world");
        tree.cal();
        System.out.println(tree.cnt);
    }
}
