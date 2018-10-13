package geeksforgeek.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ProductLessThanK {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int noOfTestCase = Integer.parseInt(bf.readLine());

        String[] elements = null;
        /*
         * for(int k=0,l=0;k<elements.length,l<elements.length; k++,l++) {
         * 
         * }
         */
        for (int i = 0; i < noOfTestCase; i++) {

            String[] noOfTest = bf.readLine().split(" ");
            elements = bf.readLine().split(" ");
            int counter = 0;
            int productValueCount = 0;

            int a = Integer.parseInt(elements[counter]);
            int count = counter + 1;
            int product = 1;
            boolean iscontinous = false;
            int k = 0;
            counter++;
            ArrayList<Integer> hs = new ArrayList<>();
            int currentValue = 0;
            while (count <= elements.length) {
                if ((currentValue < elements.length)
                        && (Integer.parseInt(elements[currentValue]) < Integer.parseInt(noOfTest[1]))) {
                    hs.add(Integer.parseInt(elements[currentValue]));
                    productValueCount++;

                }
                currentValue++;
                iscontinous = false;
                if (counter < elements.length)
                    product *= a * Integer.parseInt(elements[counter]);
                else product = Integer.parseInt(noOfTest[1]);
                if (product < Integer.parseInt(noOfTest[1])) {
                    a = 1;
                    productValueCount++;
                    counter++;
                }
                else {
                    if (count < elements.length)
                        a = Integer.parseInt(elements[count]);
                    k = count;
                    counter = count + 1;
                    count++;
                    product = 1;
                }
                k++;

            }
            System.out.println(productValueCount);
        }
    }
}
