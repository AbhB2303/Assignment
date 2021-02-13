public class OGmerge {
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        for(int k = lo; k <= hi; k++) aux[k] = a[k];//copy a[] into aux

        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++){
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if(hi <= lo) return;
        int mid = (hi - lo) / 2;
        sort(a, aux, lo, mid); //left side partition
        sort(a, aux, mid + 1, hi); //right side partition
        merge(a, aux, lo, mid, hi); //merge
    }

    public static void sort(Comparable[] a){
        //initial sort call creates aux array for copy
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }


}
