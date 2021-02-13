import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int size = 8; //value assigned for size of array to be read
        int[] InputValues = new int[size]; //read input from files and assign to array
        OutputToFile(null, false); //clear current output.txt
        InputValues = InputReader(size); //read input of length size and save in inputvalues array
        Merge merge = new Merge(InputValues); //create merge object and assign InputValues by passing through constructor
        merge.run(); //run the thread

        int[] OutputValues = merge.getArray(); //grab final sorted array and set it to output array to be written to text file

        OutputToFile(OutputValues, true);//writes output to output.txt
    }


    public static int[] InputReader(int size) //function to read file input
    {
        int[] InputValues = new int[size];
        try { //read inputs and assign to array
            File file = new File("Input.txt"); //define new file
            Scanner scan = new Scanner(file); //scan file
            for (int i = 0; i < InputValues.length; i++) { //read through each line of file
                InputValues[i] = scan.nextInt();
            }


        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return InputValues; //return values read from the input
    }


    public static void OutputToFile(int[] arr, boolean append) //function to write file output given an array to write
    {
        try { //write to output file
            FileWriter WriteToOutput = new FileWriter("Output.txt", append); //create file writer
            if (arr != null) {
                for (int i = 0; i < arr.length; i++) { //write each array value into file line by line
                    WriteToOutput.write(arr[i] + "\n");
                }
            }
            else
            {
                WriteToOutput.write("");
            }
            WriteToOutput.close(); //close out the file writer
            //System.out.println("Wrote to the file"); //confirm that the file was written to
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
