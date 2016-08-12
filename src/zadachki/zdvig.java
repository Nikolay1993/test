package zadachki;

/**
 * Created by Николай on 06.08.2016.
 */
public class zdvig {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
//        for(int i = 0; i<arr.length; i++){
//            System.out.print(" "+ arr[i-1]);
//        }

//            int size = arr.length;
//            for (int i = 0; i < arr.length; i++) {
//                for (int j = arr.length - 1; j > 0; j--) {
//                    arr[j] = arr[j-1];
//                }
//                arr[0] = arr.length-1;
//                System.out.print(arr[i]);
        print(arr, 4);
    }
//            }
        public static void print ( int arr[], int number){

                for (int i = arr.length - number; i < arr.length; i++) {
                    System.out.print(arr[i]);
                }
                    for (int j = 0; j < arr.length - number; j++) {
                        System.out.print(arr[j]);

                    }
                    }
                }


//добавить проверку обработку цифры "если цифра больше чем размер масива то делить мою введенную цифру на размер массива и брать остаток от деления.

