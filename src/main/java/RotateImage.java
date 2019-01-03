public class RotateImage {




    public static int[][] rotateImage(int[][] image) {


        int n = image.length;
        System.out.println(n/2);
        print(image);

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2); j++) {
                int temp = image[i][j];
                image[i][j] = image[n-1-j][i];
                image[n-1-j][i] = image[n-1-i][n-1-j];
                image[n-1-i][n-1-j] = image[j][n-1-i];
                image[j][n-1-i] = temp;
            }
        }
        print(image);
        return image;

    }

    public static void print(int[][] image) {

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image.length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {


        int[][] a = {{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}};


        rotateImage(a);




    }
}
