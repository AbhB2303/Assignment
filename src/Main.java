import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Thread t = new Thread(new ThreadTest()); //single thread declaration
        Thread[] Threads = new Thread[10]; //array of threads
        for(int i = 0; i<= Threads.length-1; i++)//filling threads
        {
            Threads[i] = new Thread(new ThreadTest());
        }

        int[] InputValues = new int[8];

        try{
            File file = new File("Input.txt");
            Scanner scan = new Scanner(file);
            for(int i = 0; i < 8; i++){
                InputValues[i] = scan.nextInt();
            }


        } catch(IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }


        ThreadTest test = new ThreadTest();
        test.sort(InputValues);
        t.start();

        try{
            t.join();
        } catch(Exception e){
            e.printStackTrace();
        }

        for(int i = 0; i < 8; i++){
                    System.out.println(InputValues[i]);

                }

      try{
          FileWriter MyWriter = new FileWriter("Output.txt");
          MyWriter.write("Tell me this worked");
          MyWriter.close();
          System.out.println("Wrote to the file");
      } catch (IOException e)
        {
            System.out.println("It fucking didn't work :(");
            e.printStackTrace();
        }
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
}
