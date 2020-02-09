import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int index(int[] arr, int x,int start){

        int length = arr.length;
        for(int i=start;i<length;i++)
        {
            if(arr[i] == x)
                return i;
        }
        return -1;
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int length = arr.length;
        int swaps = 0;
        int ind = 0;
        int temp = 0;
        int count = 0;
        for(int i=0;i<length;i++)
        {
            if(i+1 != arr[i])
            {
                count++;
                ind = index(arr,i+1,i);
                if(ind != -1){
                    temp = arr[i];
                    arr[i] = arr[ind];
                    arr[ind] = temp;
                }
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
