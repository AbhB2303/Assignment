import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        int[] InputValues = InputReader(); //read input from files and assign to array

        Merge merge = new Merge(InputValues, 1); //create merge object and assign InputValues by passing through constructor
        merge.run(); //run the thread


        int[] OutputValues = merge.getArray(); //grab final sorted array and set it to output array to be written to text file

        //output sorted values to console
        for(int i = 0; i < OutputValues.length; i++){
            System.out.println(OutputValues[i]);
        }

       // OutputToFile(OutputValues);//writes output to output.txt
    }



    public static int[] InputReader() //function to read file input
    {
        int[] InputValues = new int[8];
        try{ //read inputs and assign to array
            File file = new File("Input.txt"); //define new file
            Scanner scan = new Scanner(file); //scan file
            for(int i = 0; i < InputValues.length; i++){ //read through each line of file
                InputValues[i] = scan.nextInt();
            }


        } catch(IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return InputValues; //return values read from the input
    }

    public static void OutputToFile(int[] arr) //function to write file output given an array to write
    {
        try { //write to output file
            FileWriter WriteToOutput = new FileWriter("Output.txt"); //create file writer

            for (int i = 0; i < arr.length; i++) { //write each array value into file line by line
                WriteToOutput.write(arr[i] + "\n");
            }

            WriteToOutput.close(); //close out the file writer
            System.out.println("Wrote to the file"); //confirm that the file was written to
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
