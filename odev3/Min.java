package recursion;

public class Min {
    int index;
    int min;
    int i = 0;
    Min[] stack = new Min[20]; 

    public Min(int index, int min) {
        this.index = index;
        this.min = min;
    }
    
    public Min(){
        
    }
    
    public void push(int index, int min){
        stack[i] = new Min(index, min);
        i++;
    }
    
    public void yazdir(){
        int boyut = 0;
        for(int i = 0; stack[i] != null; i++){
           System.out.println(i + 1 + ".ADIM => index: " + stack[i].index + "  min: " + stack[i].min); 
        }
    }
}
