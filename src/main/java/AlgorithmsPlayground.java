
public class AlgorithmsPlayground {


    public AlgorithmsPlayground() {


    }

   public static void calculate() {

        double a = 20;
        double sum = 0;

        for (int i = 0; i < 25; i++) {
            a = a*1.02;
            sum += a;
            System.out.println(sum);
        }

//       System.out.println(sum);



   }

    public static void main(String[] args) {

        calculate();



    }
}


