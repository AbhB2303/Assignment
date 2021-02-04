import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        int[] InputValues = InputReader(); //read input from files and assign to array

        ThreadTest merge = new ThreadTest();
        Thread t = new Thread(merge); //single thread declaration

        merge.Sort(InputValues); //create au array
        t.start(); //start thread

        try{
            t.join();
        } catch(Exception e){
            e.printStackTrace();
        }


       OutputToFile();//writes output to output.txt


        //3304  8221  26849 14038  1509 6367 7856 21362
        //3304  8221  26849 14038 | 1509 6367 7856 21362
        //3304  8221 | 26849 14038 | 1509 6367 7856 21362
        //3304 | 8221 | 26849 14038 | 1509 6367 7856 21362
        //3304 | 8221 | 26849 | 14038 | 1509 6367 7856 21362
        //last divide on left... begin conquer:
        //26849  3304 | 14038 | 8221 | 1509 6367 7856 21362
        //3304 | 8221 | 26849 | 10438 | 1509 6367 7856 21362

        //3304  8221  26849 14038  1509 6367 7856 21362
        //3304  8221  26849 14038  1509 6367 7856 21362

        //3304  8221  26849 14038  1509 6367 7856 21362


    }



    public static int[] InputReader()
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
        return InputValues;
    }

    public static void OutputToFile(/*int[] arr*/)
    {
        try{ //write to output file
            FileWriter MyWriter = new FileWriter("Output.txt");
            MyWriter.write("something");
            /*for (int i = 0 ; i <= arr.length-1; i++)
            {
                MyWriter.write(arr[i]);
            }*/
            MyWriter.close();
            System.out.println("Wrote to the file");
        } catch (IOException e)
        {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
