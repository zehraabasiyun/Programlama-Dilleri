package recursion;

public class BinarySearch {
    int min, mid, max, i = 0;
    BinarySearch[] stack = new BinarySearch[20];

    public BinarySearch(int min, int mid, int max) {
        this.min = min;
        this.mid = mid;
        this.max = max;
    }
    public BinarySearch(){
        
    }
    
    public void push(int min, int mid, int max){
        stack[i++] = new BinarySearch(min,mid,max);
    }
    
    public void yazdir(){
        int boyut = 0;
        for(int i = 0; stack[i] != null; i++)
           System.out.println(i + 1 + ".ADIM => min: " + stack[i].min + "  mid: " + stack[i].mid + "  max: " + stack[i].max); 
    }
}
