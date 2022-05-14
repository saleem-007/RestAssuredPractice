public class Debug {
    public static void main(String[] args) {
        int[] arr = {9, 14, 3, 2, 43, 11, 58, 22};
       Debug d1=new Debug();
       d1.function(arr);
    }
        void function(int[] arr){
            for (int i = 0; i < arr.length; i++){
                int index = i;
                for (int j = i+1; j < arr.length-1; j++){
                    if (arr[j] < arr[index]){
                        index = j+1;
                    }
                }
                int number = arr[index];
                arr[index] = arr[i];
                arr[i] = number;
            }
        }
    }

