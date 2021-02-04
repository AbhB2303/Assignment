public class ThreadTest implements Runnable{
    public void sort(int[] a){
        int temp = a[0];
        a[0] = a[7];
        a[7] = temp;
    }

    public void Sort(int[] a, int[] aux, int lo, int hi)
    {
        if(hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        Sort(a, aux, lo, mid);
        Sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
        complete(aux, a);

    }


    public static void complete(int[] aux, int[] a){
        for(int i = 0; i < a.length; i++){
            a[i] = aux[i];
        }

    }

    public void merge(int[] a, int[] aux, int lo, int mid, int hi)
    {
        for(int k = lo; k <= hi; k++) aux[k] = a[k];//copy a[] into aux

        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++){
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }



    public static boolean less(int v, int w) {
        if(v<w) return true;
        else
            return false;
    }

    @Override
    public void run()
    {
        System.out.println("4");
    }
}
