import java.util.Arrays;
import java.util.Scanner;

public class Gramer {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] ozne = {"ben", "sen", "hasan", "nurşah", "elif", "abdulrezzak",
            "zeynelabidin", "naki"};

        String[] nesne = {"bahçe", "okul", "park", "sınıf", "yarın", "pazartesi",
            "salı", "çarşamba", "perşembe", "cuma", "cumartesi", "pazar",
            "merkez", "ev", "kitap", "defter", "güneş", "beydağı"};

        String[] yuklem = {"gitmek", "gelmek", "okumak", "yazmak", "yürümek", "görmek"};

        System.out.print("cumle giriniz: ");
        String cumle = s.nextLine().trim().toLowerCase();

        String[] kelimeler = cumle.split("\\s+");
        
        boolean ozneKontrol = false, nesneKontrol = false, yuklemKontrol = false;

        if(Arrays.asList(ozne).contains(kelimeler[0]))
            ozneKontrol = true;           
        if(Arrays.asList(nesne).contains(kelimeler[1]))
            nesneKontrol = true;
        if(Arrays.asList(yuklem).contains(kelimeler[2]))
            yuklemKontrol = true; 
        
        if(ozneKontrol && nesneKontrol && yuklemKontrol && kelimeler.length == 3)
            System.out.println("EVET");
        else
            System.out.println("HAYIR");       
    }
}
