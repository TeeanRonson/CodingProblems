
public class DoublePivotQuickSort {

        public static void sort (int[] input){
            //input=shuffle(input);
            sort (input, 0, input.length-1);
        }

        private static void sort(int[] input, int lowIndex, int highIndex) {

            if (highIndex<=lowIndex) return;

            int pivot1=input[lowIndex];
            int pivot2=input[highIndex];


            if (pivot1>pivot2){
                swap(input, lowIndex, highIndex);
                pivot1=input[lowIndex];
                pivot2=input[highIndex];
                //sort(input, lowIndex, highIndex);
            }
            else if (pivot1==pivot2){
                while (pivot1==pivot2 && lowIndex<highIndex){
                    lowIndex++;
                    pivot1=input[lowIndex];
                }
            }


            int i=lowIndex+1;
            int lt=lowIndex+1;
            int gt=highIndex-1;

            while (i<=gt){

                if (input[i] < pivot1){
                    swap(input, i++, lt++);
                }
                else if (pivot2 < input[i]){
                    swap(input, i, gt--);
                }
                else{
                    i++;
                }

            }


            swap(input, lowIndex, --lt);
            swap(input, highIndex, ++gt);

            sort(input, lowIndex, lt-1);
            sort (input, lt+1, gt-1);
            sort(input, gt+1, highIndex);

    }

    private static void swap(int[] A, int first, int second) {


        int temp = A[first];
        A[first] = A[second];
        A[second] = temp;

    }

    public static void main(String[] args) {

        int[] A = {2, 7, 3, 5, 9, 6, 3, 2, 1, 8};

        DoublePivotQuickSort.sort(A, 0, A.length - 1);



    }







}
