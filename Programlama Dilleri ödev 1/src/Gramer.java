 import java.util.Scanner;

public class Gramer {

    private static final String[] OZNE = {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin", "Naki"};
    private static final String[] NESNE = {"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma",
            "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};
    private static final String[] YUKLEM = {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Cümleyi giriniz: ");
        String cumle = scanner.nextLine().toLowerCase();

        String[] kelimeler = new String[3];
        int kelimeSayisi = 0;
        for (int i = 0; i < cumle.length(); i++) {
            if (Character.isWhitespace(cumle.charAt(i))) {
                continue;
            }
            if (kelimeSayisi == 3) {
                System.out.println("Cümle hatalı! Üçten fazla kelimeden oluşmamalıdır.");
                return;
            }
            kelimeler[kelimeSayisi++] = "";
            while (i < cumle.length() && !Character.isWhitespace(cumle.charAt(i))) {
                kelimeler[kelimeSayisi - 1] += cumle.charAt(i++);
            }
        }
        if (kelimeSayisi != 3) {
            System.out.println("Cümle hatalı! Üç kelimeden oluşmalıdır.");
            return;
        }
        boolean ozneVar = false;
        boolean nesneVar = false;
        boolean yuklemVar = false;
        for (String kelime : kelimeler) {
            if (ozneVar && nesneVar && yuklemVar) {
                break;
            }
            for (String ozne : OZNE) {
                if (ozne.toLowerCase().equals(kelime)) {
                    ozneVar = true;
                    break;
                }
            }
            if (!ozneVar) {
                continue;
            }
            for (String nesne : NESNE) {
                if (nesne.toLowerCase().equals(kelime)) {
                    nesneVar = true;
                    break;
                }
            }
            if (!nesneVar) {
                continue;
            }
            for (String yuklem : YUKLEM) {
                if (yuklem.toLowerCase().equals(kelime)) {
                    yuklemVar = true;
                    break;
                }
            }
        }
        if (ozneVar && nesneVar && yuklemVar) {
            System.out.println("Evet, cümle gramer kurallarına uyuyor.");
        } else {
            System.out.println("Hayır, cümle gramer kurallarına uymuyor.");
        }
    }
}