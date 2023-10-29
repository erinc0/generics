import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static <E extends Comparable<E>> void main(String[] args) throws Exception {
        ArrayList<Integer>array = createRandomArray(0);  
         System.out.println(array);
         bubbleSort(array);
         System.out.println(array);
         mergeSort(array);
         System.out.println(array);
    }   

    public static  <E extends Comparable<E>> void mergeSort(ArrayList<E> array){
     mergeSort(array, 0, array.size()); //ok
    }

public static  <E extends Comparable<E>> void mergeSort(ArrayList<E> array, int start, int end){
    if(end - start <= 1) return;
    int middle = (start + end) / 2;
    mergeSort(array, start, middle);
    mergeSort(array, middle, end);
    merge(array, start, middle, end);
}

public static  <E extends Comparable<E>> void merge(ArrayList<E>array, int start, int middle, int end){
    int i = start, j =middle;
    ArrayList<E> mergedArray = new ArrayList<E> (end- start);
    while (i < middle && j <end){
        if (array.get(i).compareTo(array.get(j))>0){
            mergedArray.add(array.get(j));
            j++;
            } else{ 
            mergedArray.add(array.get(i));
            i++;
            }
        }
    while (i< middle){
        mergedArray.add(array.get(i));
        i++;
    }
    while (j < end) {
        mergedArray.add(array.get(j));
        j++;
    }
    for (i = start; i<end; i++){
        array.set(i, mergedArray.get(i-start));
    }
    }
    
    public static ArrayList<Integer> createRandomArray(int i){
        System.out.println("Please enter how many elements you would like in the array!");
        Scanner louis= new Scanner(System.in); 
        int q;
        q =louis.nextInt();
        ArrayList<Integer> array = new ArrayList< > ();
        louis.close();

        int miau;
        Random random = new Random(0);  
         for(miau = 0; miau < q; miau++){
         array.add(random.nextInt(1000));
         }
        return array;
}

    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> array){
        bubbleSort(array, 0, array.size());
}

    public static <E> void woof(ArrayList<E> array, int i, int k){
        E temp= array.get(i);
        array.set(i, array.get(k));
        array.set(k, temp);
}

    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> array, int start, int end){
        if (end - start <= 1)
        return;
        for (int i = start; i < end -1; i++){
        if (array.get(i).compareTo(array.get(i+1))>0){
        woof(array, i, i+1);

    }
  }
        bubbleSort(array, start, end -1);

}
}