public class ThreadTest implements Runnable{
    public void sort(int[] a){
        int temp = a[0];
        a[0] = a[7];
        a[7] = temp;
    }


    @Override
    public void run()
    {
        System.out.println("4");
    }
}
