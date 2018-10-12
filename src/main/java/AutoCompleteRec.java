import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AutoCompleteRec {

    private Node root;
    private Integer counter;


    public AutoCompleteRec() {

        this.root = new Node();
        this.counter = 0;

    }

    /**
     * Reads the words.txt input file
     * @param filename
     */
    public void ReadFile(String filename) {

        root = new Node();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String currentWord;

            while((currentWord = br.readLine()) != null) {

                if (counter > 200 && counter < 250) {
                    add(currentWord);
                }
                counter++;

            }

        } catch (IOException e) {
            System.out.println("Exception with inputFile");
            e.printStackTrace();
        }
    }

    /**
     * Prints all the words in the dictionary, in alphabetical order,
     * one word per line.
     */
    public void print() {
        print("", root); // Calling private print method
    }


    /**
     * Outputs all the words stored in the dictionary
     * to the console, in alphabetical order, one word per line.
     * @param word the string obtained by concatenating prefixes on the way to this node
     * @param node the root of the tree
     */
    private void print(String word, Node node) {

        if(node.isWord == true) {
            System.out.println(word + node.prefix);
        }
        for(Node children: node.children) {
            if(children != null) {
                print(word + node.prefix, children);
            }
        }
    }

    /** Adds a given word to the dictionary.
     * @param word the word to add to the dictionary
     */
    public void add(String word) {
        root = add(word, root); // Calling private add method
    }


    /**
     * Adds words and creates the prefix tree
     * based on multiple base cases
     * @param word
     * @param node
     * @return
     */
    private Node add(String word, Node node) {

        //Base case
        if(node == null) {
            return null;
        }

        //Find the common prefix
        String comm = commonPrefix(word, node.prefix); //Common prefix

        //If the word being inserted matches an existing prefix, then it is a word and set it to true
        if(node.prefix.equals(word)) {
            node.isWord = true;
            return node;


            // If the common prefix equals to the current prefix at the node
            // For example: Inserting Apple when App is already in

        } else if(comm.equals(node.prefix)) {
            //Extract "le" from Apple

            String suffix = suffix(word, node.prefix);
            int indx = getIndexOfCharacter(suffix);

            //Check if the index of 'l' is null

            if (node.children[indx] == null) {
                Node newNode = new Node();
                newNode.set(suffix, true);
                node.children[indx] = newNode;
                return node;

            } else {

                // Repeat the process
                node.children[indx] = add(suffix, node.children[indx]);
                return node;
            }

        } else {
            //If two words have similar prefixes but the
            //existing word in the node is not just the prefix
            //For example: Adding Hamster when Hamburger already exists
            // We need to extract "Ham" from both words
            // Then place "ster" and "burger" in the children of "Ham"

            Node newNode = new Node();
            Node newNode1 = new Node();

            String common = commonPrefix(word, node.prefix);
            String suffix1 = suffix(node.prefix, word);
            String suffix2 = suffix(word, node.prefix);

            newNode.set(common, false);
            node.set(suffix1, node.isWord);

            int indx = getIndexOfCharacter(suffix1);
            newNode.children[indx] = node;

            int indx1 = getIndexOfCharacter(suffix2);
            newNode1.set(suffix2, true);

            newNode.children[indx1] = newNode1;
            return newNode;
        }

    }


    /**
     * Private method converts the the first letter of the input
     * to a number between 0 and 25 using ASCII code
     * @param word
     * @return
     */
    private int getIndexOfCharacter(String word) {


        char c = word.charAt(0);
        char a = '!';


        int index = (int) c - (int) a;


        return index;

    }

    /**
     * Finds the common prefix between word1 and word2
     * Returns the suffix of word1 without its prefix
     * @param word1
     * @param word2
     * @return
     */

    private String suffix(String word1, String word2) {

        int count = 0;
        String suffix = "";

        while (count < word1.length() && count < word2.length()) {
            char one = word1.charAt(count);
            char two = word2.charAt(count);
            if (one != two) {
                break;
            }
            count++;
        }

        suffix = word1.substring(count, word1.length());

        return suffix;
    }


    /**
     * Finds the common prefix between current and existing
     * @param current
     * @param existing
     * @return
     */
    private String commonPrefix(String current, String existing) {

        int count = 0;
        String prefix = "";

        while (count < current.length() && count < existing.length()) {
            char one = current.charAt(count);
            char two = existing.charAt(count);
            if (one != two) {
                break;
            }
            count++;
        }

        prefix = current.substring(0, count);

        return prefix;

    }

    private class Node {
        String prefix; // prefix stored in the node
        Node children[]; // array of children (26 children)
        boolean isWord; // true if by concatenating all prefixes on the path from the root to this node, we get a valid word

        private Node() {
            this.prefix = "";
            this.children = new Node[90]; // initialize the array of children
            this.isWord = false;
        }


        public void set(String letter, boolean isWord) {
            this.prefix = letter;
            this.isWord = isWord;
        }


    }

    public static void main(String[] args) {


        AutoCompleteRec ac = new AutoCompleteRec();

//        ac.ReadFile("words.txt");

        ac.add("whiff");
        ac.add("whyever");
        ac.add("whiff");
        ac.add("whiffable");
        ac.add("whiffed");
        ac.add("Whiffen");
        ac.add("whiffenpoof");

        ac.print();

    }
}
