import java.util.Arrays;
import java.util.Scanner;

public class Gramer {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] ozne = {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak",
            "Zeynelabidin", "Naki"};

        String[] nesne = {"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi",
            "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar",
            "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};

        String[] yuklem = {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};

        System.out.print("cumle giriniz: ");
        String cumle = s.nextLine().trim();

        String[] kelimeler = cumle.split("\\s+");
        
        boolean ozneKontrol = false, nesneKontrol = false, yuklemKontrol = false;

        if(Arrays.asList(ozne).contains(kelimeler[0]))
            ozneKontrol = true;           
        if(Arrays.asList(nesne).contains(kelimeler[1]))
            nesneKontrol = true;
        if(Arrays.asList(yuklem).contains(kelimeler[2]))
            yuklemKontrol = true; 
        
        if(ozneKontrol && nesneKontrol && yuklemKontrol)
            System.out.println("EVET");
        else
            System.out.println("HAYIR");       
    }
}