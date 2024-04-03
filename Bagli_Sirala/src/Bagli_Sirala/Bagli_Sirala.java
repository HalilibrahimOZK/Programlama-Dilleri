package Bagli_Sirala;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Bagli_Sirala {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan sıralama algoritmasını seçmesini isteme
        System.out.println("Sıralama algoritması seçiniz:");
        System.out.println("1. Kabarcık Sıralaması (Bubble Sort)");
        System.out.println("2. Seçim Sıralaması (Selection Sort)");
        System.out.print("Seçiminiz: ");
        int siralamaAlgoritmasi = scanner.nextInt();

        System.out.print("Dosya adini girin: ");
        String dosyaAdi = scanner.nextLine();

        try {
            File file = new File(dosyaAdi);
            Scanner dosyaOkuyucu = new Scanner(file);

            int maxSize = 100; // Maksimum dizi boyutu
            Node[] orijinalDizi = new Node[maxSize]; // Orijinal dizimiz
            Node[] siraliDizi = new Node[maxSize]; // Sıralama işlemi için kullanılacak dizi

            int index = 0;
            while (dosyaOkuyucu.hasNextInt() && index < maxSize) {
                int x = dosyaOkuyucu.nextInt();
                Node node = new Node(x, index);
                orijinalDizi[index] = node; // Okunan her sayıyı orijinal diziye ekleme
                siraliDizi[index] = new Node(x, index); // Okunan her sayıyı sıralama dizisine ekleme
                index++;
            }

            // Seçilen sıralama algoritmasına göre sıralama yapma
            if (siralamaAlgoritmasi == 1) {
                // Kabarcık sıralaması
                for (int i = 0; i < index - 1; i++) {
                    for (int j = 0; j < index - i - 1; j++) {
                        if (siraliDizi[j].x > siraliDizi[j + 1].x) {
                            // Swap işlemi
                            Node temp = siraliDizi[j];
                            siraliDizi[j] = siraliDizi[j + 1];
                            siraliDizi[j + 1] = temp;
                        }
                    }
                }
            } else if (siralamaAlgoritmasi == 2) {
                // Seçim sıralaması
                for (int i = 0; i < index - 1; i++) {
                    int minIndex = i;
                    for (int j = i + 1; j < index; j++) {
                        if (siraliDizi[minIndex].x > siraliDizi[j].x) {
                            minIndex = j;
                        }
                    }

                    // Swap işlemi
                    Node temp = siraliDizi[minIndex];
                    siraliDizi[minIndex] = siraliDizi[i];
                    siraliDizi[i] = temp;
                }
            } else {
                System.out.println("Geçersiz sıralama algoritması seçimi!");
                return;
            }

            // Dizilerin yan yana yazdırılması
            System.out.println("X\t\tY\t\t\t\tX\t\tY");
            System.out.println("-----------------------------------------------------------------");
            for (int i = 0; i < index; i++) {
                System.out.println(orijinalDizi[i].x + "\t\t" + orijinalDizi[i].y + "\t\t|" +
                        "\t\t" + siraliDizi[i].x + "\t\t" + siraliDizi[i].y);
            }

            dosyaOkuyucu.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadi.");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("Geçersiz sıralama algoritması seçimi!");
            e.printStackTrace();
        }
    }
}

