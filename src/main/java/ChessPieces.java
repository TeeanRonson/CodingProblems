import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class ChessPieces {


    public static boolean movePiece(String piece, int[] src, int[] dst) {

        HashMap<String, LinkedList<int[]>> db = new HashMap<>();
        LinkedList<int[]> rook = new LinkedList<>();
        rook.add(new int[] {8, 8});
        db.put("Rook", rook);

        return checkRook(db.get(piece), src, dst);
    }

    private static boolean checkPawn(int[] src, int[] dst) {



        return true;

    }
    //0 0 0 0 0 0 0 0
    //0 0 0 0 0 0 0 0
    //0 0 0 0 0 0 0 0
    //0 0 0 0 0 0 0 0
    //0 0 H 0 H 0 0 0
    //0 H 0 0 0 H 0 0
    //0 0 0 X 0 0 0 0
    //0 H 0 0 0 H 0 0


    private static boolean checkKnight(Integer[] dst) {

        HashSet<Integer[]> positions = new HashSet<>();
        positions.add(new Integer[] {0, 1});
        positions.add(new Integer[] {0, 5});
        positions.add(new Integer[] {2, 3});
        positions.add(new Integer[] {2, 5});
        positions.add(new Integer[] {3, 2});
        positions.add(new Integer[] {3, 4});

       for (Integer[] x: positions) {
          if (x[0] == dst[0] && x[1] == dst[1]) return true;
       }
        return false;
    }

    private static boolean checkRook(LinkedList<int[]> range, int[] src, int[] dst) {

        //if newX is not in my row || newY is not in my column
        if (src[0] != dst[0] && src[1] != dst[1]) {
            return false;
        }

        //we are in the same column
        if (src[0] == dst[0]) {
            if (src[0] + 7 >= dst[1]) {
                return true;
            }
        } else if (src[1] == dst[1]) {
            if (src[1] + 7 >= dst[1]) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

//        System.out.println(movePiece("Rook", new int[] {4, 4}, new int[] {7, 4}));
//        System.out.println(movePiece("Rook", new int[] {4, 4}, new int[] {4, 7}));
//        System.out.println(movePiece("Rook", new int[] {0, 0}, new int[] {5, 5}));

        System.out.println(checkKnight(new Integer[] {3, 4}));



    }
}
