import java.io.FileWriter;
import java.io.IOException;

public class Merge implements Runnable {
    public int[] array;//input array
    //getter and setter for the array
    public int[] getArray() {
        return array;
    }
    public void setArray(int[] array) {
        this.array = array;
    }

    //constructors:


    public Merge(int[] input) {//called at first instance of merge being created
        this.array = new int[input.length];
        array = input;
    }

    //constructor to merge together sorted partitions
    //called after sorting is complete
    public Merge(int[] input1, int[] input2) {  //mid is the start of the second array

        array = new int[input1.length+input2.length]; //set array to new array of size of input1 and input2 combined
        int mid = input1.length; //define a mid for the new array

        for (int i = 0; i < mid; i++) { //copy input1 into the array
            array[i] = input1[i];
        }

        for (int i = mid; i < array.length; i++) { //copy input2 into the array
            array[i] = input2[i-mid];
        }

        if (array[mid - 1] <= array[mid]) { //check if merging needs to occur
            // (if rightmost value in left partition >= leftmost part of second partition, the array is already sorted)
           return;
        }

        //set values for pointers of the two partition
        int i = 0;
        int j = mid;

        int auxIndex = 0; //index to step through auxiliary array

        int[] aux = new int[array.length]; //declare auxiliary array with the same size as the array length

        while ((i < mid) && (j < array.length)) //iterate through the left and right partitions using pointer values
        {
            if (array[i] < array[j]) //if the value pointed to on the left is less than the value on the right
            {
                aux[auxIndex++] = array[i++]; //next value in auxiliary array
            } else
            {
                aux[auxIndex++] = array[j++]; //
            }
        }

        //only one of these for loops will run in a merge
        for (int k = i; k < mid; k++) { //insert any leftover values from the left hand side
            aux[auxIndex++] = array[k];
        }
        for (int k = j; k < array.length; k++) { //insert any leftover values from the right hand side
            aux[auxIndex++] = array[k];
        }



        for (int k = 0; k < aux.length; k++) { //copy auxiliary back into the original array

            array[k] = aux[k];

        }
    }

    private int[] getArraySlice(int lo, int hi) {//the array includes lo but not hi
        int[] temp = new int[hi - lo]; //create a temporary array to be returned at the end as a new array
        int TempSpot = 0; //create an index to iterate through the temporary array
        for (int i = lo; i < hi; i++) {

            temp[TempSpot] = array[i];
            TempSpot++;
        } //iterate and assign values to temp array
        return temp; //return the array
    }

    private void sort() { //sorting function to be called from runnable

        int[] arr; //define a new array to take on the sliced arrays
        if(array.length <= 1) //if array size is one or the array is empty, return; base case for sort
        {
            return;
        }
        int mid = (array.length)/ 2; //define new mid for an array of size bigger than 1
        arr = getArraySlice(0, mid); //slice the left side of the array to be sent into the left thread
        Merge left =  new Merge(arr); //create merge object for left partition
        Thread leftThread = new Thread(left); //instantiate thread for the left partition
        leftThread.start(); //start the sort of the left partition
        OutputToFile("New thread started: " + leftThread.getName());

        //repeat above process for the right hand side of the array
        arr = getArraySlice(mid, array.length);
        Merge right = new Merge(arr);
        Thread rightThread = new Thread(right);
        rightThread.start();
        OutputToFile("New thread started: " + rightThread.getName());

        //join threads when fully sorted
        try {

            leftThread.join();
            OutputToFile("Finish Thread: " + leftThread.getName());
            rightThread.join();
            OutputToFile("Finish Thread: " + rightThread.getName());


        } catch (Exception e) {
            e.printStackTrace();
        }

        Merge combine = new Merge(left.getArray(), right.getArray()); //instantiate merge constructor to implement merge
        array = combine.getArray(); //assign array the final sorted and merged array to be sent to output text file

    }



    @Override
    public void run(){

        sort();

    }

    public void OutputToFile(String OutputString) //function to write file output given an array to write
    {
        try { //write to output file
            FileWriter WriteToOutput = new FileWriter("Output.txt", true); //create file writer
                WriteToOutput.write(OutputString + "\n");

            WriteToOutput.close(); //close out the file writer
            //System.out.println("Wrote to the file"); //confirm that the file was written to
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }


}
