import java.util.HashMap;

public class SuffixTrie {


    private TreeNode root;


    public SuffixTrie() {
        this.root = new TreeNode();
    }


    public void buildSuffixTrie(String[] words) {


        for (String word: words) {
            char[] wordArray = word.toCharArray();
            TreeNode curr = this.root;
            for (char c: wordArray) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TreeNode(c));
                }
                curr = curr.children.get(c);
            }
            curr.isWord();
        }

    }

    private boolean checkWord(String word) {


        TreeNode curr = this.root;
        for (char c: word.toCharArray()) {
            if (curr.children.get(c) == null) {
                break;
            }
            System.out.println(curr.children.get(c).letter);
            if (curr.children.get(c).isWord) {
                return true;
            }
            curr = curr.children.get(c);
        }

        return false;
    }

    private class TreeNode {
        HashMap<Character, TreeNode> children;
        char letter;
        boolean isWord;

        private TreeNode(char letter) {
            this.children = new HashMap<>();
            this.letter = letter;
            this.isWord = false;
        }

        private TreeNode() {
            this.children = new HashMap<>();
        }


        private char getLetter() {
            return this.letter;
        }

        private void isWord() {
            this.isWord = true;
        }
    }




    public static void main(String[] args) {


        String[] sArray = { "bat", "ball", "barrage", "barrier", "bell"};
        SuffixTrie st = new SuffixTrie();

        st.buildSuffixTrie(sArray);

        System.out.println(st.checkWord("bat"));
        System.out.println(st.checkWord("ball"));
        System.out.println(st.checkWord("barrage"));
        System.out.println(st.checkWord("cat"));







    }
}
