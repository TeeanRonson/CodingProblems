

    import java.util.*;

    public class AutoCompleteIter {

        private TreeNode root;

        /**
         * Constructor
         *
         */
        public AutoCompleteIter() {
            this.root = new TreeNode();

        }

        public void fillLibrary(String[] library) {

            for(String word: library) {
                char[] cArray = word.toCharArray();
                TreeNode curr = this.root;
                for (int i = 0; i < cArray.length; i++) {
                    if (curr.getChildren().get(cArray[i]) == null) {
                        curr.getChildren().put(cArray[i], new TreeNode(cArray[i]));
                    }
                    curr = curr.getChildren().get(cArray[i]);
                }
                curr.isWord();
            }

        }


        public List<String> completer(String prefix) {

            List<String> result = new ArrayList<>();
            char[] pref = prefix.toCharArray();
            TreeNode node = this.root;
            for (char c: pref) {
                if (node == null) {
                    return result;
                }
                node = node.children.get(c);
            }

            helpComplete(result, node, new StringBuilder(prefix));

            return result;
        }

        private void helpComplete(List<String> result, TreeNode node, StringBuilder builder) {

            if (node == null) {
                return;
            }

            if (node.isWord) {
                result.add(builder.toString());
            }

            for (TreeNode next: node.children.values()) {
                builder.append(next.cha);
                helpComplete(result, node, builder);

            }
        }

        public void printTree() {
            print("", this.root);

        }

        private void print(String word, TreeNode node) {

            if (node.isWord == true) {
                System.out.println(word);
            }

            for (Character cha: node.children.keySet()) {
                TreeNode next = node.children.get(cha);
                if (next != null) {
                    print(word + next.cha, next);
                }
            }

        }

        private class TreeNode {
            private HashMap<Character, TreeNode> children;
            private char cha;
            private boolean isWord;

            private TreeNode(char cha) {
                this.cha = cha;
                this.children = new HashMap<>();
                this.isWord = false;
            }

            private TreeNode() {
                this.children = new HashMap<>();
            }

            private void isWord() {
                this.isWord = true;
            }

            HashMap<Character, TreeNode> getChildren() {
                return this.children;
            }
        }

        public static void main(String[] args) {

            String[] sArray = { "bat", "ball", "barrage", "barrier", "bell"};
            String[] sArray2 = {
                    "whids",
                    "whyever",
                    "whiff",
                    "whiffable",
                    "whiffed",
                    "Whiffen",
                    "whiffenpoof",
                    "whiffer",
                    "whiffers",
                    "whiffet",
                    "whiffets",
                    "whiffy",
                    "whiffing",
                    "whiffle",
                    "whiffled",
                    "whiffler",
                    "whifflery",
                    "whiffleries",
                    "whifflers",
                    "whiffles",
                    "whiffletree",
                    "whiffletrees",
                    "whiffling",
                    "whifflingly",
                    "whiffs",
                    "whyfor",
                    "whift",
                    "Whig"
            };

            AutoCompleteIter a = new AutoCompleteIter();

            a.fillLibrary(sArray2);

            a.printTree();

            System.out.println(a.completer(""));


//        System.out.println(a.complete("whi"));
//
//        System.out.println(a.complete("ba"));
//        System.out.println(a.complete("be"));
//        System.out.println(a.complete("a"));
//        System.out.println(a.complete(""));

            //fizz buzz:
//        for (int i = 1; i <= 100; i++) {
//
//            if (i % 5 == 0 && i % 3 == 0) System.out.println("fizz buzz");
//            else if (i % 3 == 0) System.out.println("buzz");
//            else if (i % 5 == 0) System.out.println("fizz");
//            else System.out.println(i);
//        }

        }
}
