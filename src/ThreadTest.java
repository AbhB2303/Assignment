public class ThreadTest implements Runnable{

    //global instance variables
    private int[] OriginalArray = new int[8];
    private int[] aux = new int[8];
    private int hi;
    private int lo;
    private int mid;

    public int getHi() {
        return hi;
    }

    public void setHi(int hi) {
        this.hi = hi;
    }

    public int getLo() {
        return lo;
    }

    public void setLo(int lo) {
        this.lo = lo;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = lo + (hi - lo) / 2;
    }

    public void Sort(int[] a){

        for(int i = 0; i<a.length; i++){
            OriginalArray[i]=a[i];
        }
        Sort(OriginalArray, aux, 0, OriginalArray.length - 1);
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
        ThreadTest t1 = new ThreadTest();
        t1.setMid(t1.getLo() + (t1.getHi() - t1.getLo()) / 2);
        //t1.setHi();



        if(hi <= lo) return;
        mid = lo + (hi - lo) / 2;
        Sort(OriginalArray, aux, lo, mid);
        Sort(OriginalArray, aux, mid + 1, hi);
        merge(OriginalArray, aux, lo, mid, hi);
        complete(aux, OriginalArray);



    }





}
