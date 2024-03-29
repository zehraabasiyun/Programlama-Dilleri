import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner s = new Scanner(System.in);
        System.out.print("dosya adini giriniz: ");
        String dosyaAdi = s.nextLine();

        int satirSayisi = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            while (reader.readLine() != null)
                satirSayisi++;
        }

        int[] dizi = new int[satirSayisi];

        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            int indeks = 0;
            String dosyaSatir;
            while ((dosyaSatir = reader.readLine()) != null)
                dizi[indeks++] = Integer.parseInt(dosyaSatir);
        }
        
        int n = dizi.length;
        bagliListe[] bl = new bagliListe[n];
        bagliListe[] bl2 = new bagliListe[n];

        for (int i = 0; i < n; i++){
            bl[i] = new bagliListe(dizi[i], i);
            bl2[i] = new bagliListe(dizi[i], i);
        }

        bagliListe[] temp = new bagliListe[n];

        for (int i = 0; i < n; i++) 
            temp[i] = bl[i];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (temp[j].veri > temp[j + 1].veri) {
                    bagliListe t = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = t;
                }
            }
        }

        int adres = temp[0].adres;
        
        for (int i = 0; i < n - 1; i++) 
            temp[i].adres = temp[i + 1].adres;

        temp[n - 1].adres = adres;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[j].veri == bl[i].veri) 
                    bl[i].adres = temp[j].adres;
            }
        }
        
        System.out.println("\nSIRALANMAMIS            SIRALANMIS");
        for(int i = 0; i < n; i++){
            System.out.println(bl2[i].veri + " => " + bl2[i].adres + "                  " + bl[i].veri + " => " + bl[i].adres);
        }
    }
}