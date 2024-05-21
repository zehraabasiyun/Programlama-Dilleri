package recursion;

import java.util.Scanner;

public class Recursion {
   
    static Min once0 = new Min();
    static Min sonra0 = new Min();

    static BinarySearch once = new BinarySearch();
    static BinarySearch sonra = new BinarySearch();

//    static int dizi[] = {43, 22, 30, 9, 45, 10, 35, 4, 1};
//    static int aranan = 43;


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int aranan, boyut;
        
        System.out.print("dizinin eleman sayisini giriniz: ");
        boyut = s.nextInt();
        
        int[] dizi = new int[boyut];
        
        System.out.println("dizi elemanlarini giriniz: ");
        for(int i = 0; i < boyut; i++)
            dizi[i] = s.nextInt();
        
        findMin(dizi, 0, dizi[0]);
        
        System.out.println("\nONCE");
        once0.yazdir();
        System.out.println("\nSONRA");
        sonra0.yazdir();
        
        System.out.println("***********************************************\n");
      
        System.out.print("aranan elemani giriniz: ");
        aranan = s.nextInt();
        
        shellSort(dizi);

        binarySearch(dizi, aranan, 0, (dizi.length - 1) / 2, dizi.length - 1);
        
        System.out.println("\nONCE");
        once.yazdir();
        System.out.println("\nSONRA");
        sonra.yazdir();
    }

    

    static void binarySearch(int dizi[], int aranan, int min, int mid, int max) {
        
        if (max < min) {
            System.out.println("sayi bulunamadi");
            return;
        }

        if (dizi[mid] == aranan) {
            System.out.println(mid + ". indekste bulundu");
            return;
        }

        if (aranan < dizi[mid])
            max = mid - 1;
        else
            min = mid + 1;
        
        once.push(min,mid,max);
        binarySearch(dizi, aranan, min, (max + min) / 2, max);
        sonra.push(min, mid, max);
    }

    public static void findMin(int dizi[], int index, int min) {
        if (index == dizi.length) {
            System.out.println("en kucuk eleman " + min);
            return;
        }

        if (dizi[index] < min) 
            min = dizi[index];
        
        once0.push(index, min);
        findMin(dizi, index + 1, min);
        sonra0.push(index, min);
    }

    public static void shellSort(int dizi[]) {
        int temp, gap, j;
        int n = dizi.length;

        for (gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += gap) {
                temp = dizi[i];
                for (j = i; j >= gap && dizi[j - gap] > temp; j -= gap) 
                    dizi[j] = dizi[j - gap];
                dizi[j] = temp;
            }
        }
    }
}
