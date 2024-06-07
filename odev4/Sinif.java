
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Sinif {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("dosya adini giriniz: ");
        String dosyaAdi = scanner.nextLine();
        int boyut = 0;
        String[] sinif = new String[100];

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            String dosyaSatir;
            while ((dosyaSatir = br.readLine()) != null) {
                String[] kelimeler = dosyaSatir.split("\\s+");
                for (String kelime : kelimeler) {
                    sinif[boyut++] = kelime;
                }
            }
        }
        
        System.out.println();
        String[] struct = new String[100];
        String[] baseClass = new String[boyut];
        String[] subClass = new String[boyut];

        int i = 0, k = 0, j = 0;
        if (sinif[i].equals("class")) {
            do {
                baseClass[j++] = sinif[i++];
                k = i;
            } 
            while (!sinif[i - 1].equals("}"));
        }

        j = 0;
        if (sinif[k].equals("class")) {
            do {
                subClass[j++] = sinif[k++];
            } 
            while (!sinif[k - 1].equals("}"));
        }

        //BASE CLASS 'I STRUCT A EKLEME
        j = 0;
        for (i = 0; i < baseClass.length && baseClass[i] != null; i++) {
            if (baseClass[i].equals("class")) {
                struct[j++] = "Struct";
                struct[j++] = baseClass[++i];
            } 
            else if (baseClass[i].equals("{") || baseClass[i].equals("}")) {
                struct[j++] = baseClass[i];
            } 
            else if (baseClass[i].equals("public") || baseClass[i].equals("private")) {
                struct[j++] = baseClass[++i];
                struct[j++] = baseClass[++i];
            }
        }

        //SUB CLASS 'I STRUCT 'A EKLEME
        for (i = 0; i < subClass.length && subClass[i] != null; i++) {
            if (subClass[i].equals("class")) {
                struct[j++] = "Struct";
                struct[j++] = subClass[++i];
            } 
            else if (subClass[i].equals("{"))
                struct[j++] = subClass[i];
            
            else if (subClass[i].equals("public") || subClass[i].equals("private")) {
                struct[j++] = subClass[i + 1];
                struct[j++] = subClass[i + 2];
            }
        }

        //MİRAS ALMA 
        boolean esitMi;
        for (i = 0; baseClass[i] != null && i < baseClass.length; i++) {
            esitMi = false;
            if (baseClass[i].equals("public") || baseClass[i].equals("private")) {
                for (k = 0; k < subClass.length && subClass[i] != null; k++) {
                    if (baseClass[i + 1].equals(subClass[k]) && baseClass[i + 2].equals(subClass[k + 1]))
                        esitMi = true;
                }
                if (!esitMi && !baseClass[i].equals("private")) {
                    struct[j++] = baseClass[i + 1];
                    struct[j++] = baseClass[i + 2];
                }
            }
        }

        for (i = 0; subClass[i] != null && i < subClass.length; i++) {
            if (subClass[i].equals("}")) 
                struct[j] = subClass[i];
        }

        for (i = 0; struct[i] != null; i++) {
            System.out.print(struct[i] + " ");
            if ((struct[i].contains(";") || struct[i].equals("{")) ){
                if(struct[i + 1].equals("}"))
                    System.out.println("");
                else{
                    System.out.println();
                    System.out.print("    ");
                }               
            }
            
            else if(struct[i].equals("}"))
                System.out.println("\n");               
        }
    }
}

