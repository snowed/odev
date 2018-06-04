package nonprime;

//Bu �devde dosyadan veri okuma, dosyaya veri yazma
//asal say� kontrol� ve matrisin diagonal toplam�n� bulma metodlar� vard�r
//fakat dosyadan al�nan ��gen �eklindeki dizilimin
//matrise at�lmas� ve diagonal toplam�n�n bulunmmas� kodu
//yaz�lamam��t�r.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.StringTokenizer;

public class odev {

	private static void DosyaYaz(String metin) {
		try {
			File dosya = new File("C:\\dev2\\workspace\\nonprime\\odev.txt");
			// InputStream file=new FileInputStream(dosya);
			FileWriter yazici = new FileWriter(dosya);
			BufferedWriter yaz = new BufferedWriter(yazici);
			yaz.write(metin);
			yaz.close();

			System.out.println("Yazma ��lemi Ba�ar�l�");
		} catch (Exception hata) {
			hata.printStackTrace();
		}
	}

	private static void DosyaOku() {
		try {
			File dosya = new File("C:\\dev2\\workspace\\nonprime\\odev.txt");
			BufferedReader okuyucu = null;
			okuyucu = new BufferedReader(new FileReader(dosya));
			String satir = okuyucu.readLine();

			while (satir != null) {
				System.out.println(satir);
				satir = okuyucu.readLine();
			}

		} catch (Exception hata) {
			hata.printStackTrace();
		}
	}

	private static Integer asalKontrol(int gelenSayi) {
		int sayac = 0;
		for (int i = 2; i < gelenSayi; i++) {
			if (gelenSayi % i == 0) {
				sayac++;
			}
		}
		if (sayac == 0) {
			return 0;
		} else {
			return gelenSayi;
		}
	}

	private static int altUcgen(int m[][]) {
		int toplam = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i < j) {
					m[i][j] = 0;
				}
			}
			toplam += m[i][i];
		}
		return toplam;
	}

	public static void main(String[] args) throws Exception {
		// DosyaYaz("*1"+'\n'+"*8 4\n2 *6 9\n8 5 *9 3");
		DosyaOku();
		try {
			File dosya = new File("C:\\dev2\\workspace\\nonprime\\odev.txt");
			BufferedReader okuyucu = null;
			okuyucu = new BufferedReader(new FileReader(dosya));
			String satir = okuyucu.readLine();
			// String line;
			try {
				// bos sat�r olana kadar dosyay� oku
				while ((satir = okuyucu.readLine()) != null) {
					System.out.println(satir);
					// satirlari bosluklara gore bol
					StringTokenizer st = new StringTokenizer(satir);
					// dosyan�n sat�rlar�n� okuyup atama yapacag�m diziyi
					// tan�mlad�m.
					int[][] x = new int[3][3];
					while (st.hasMoreElements()) {
						// diagonel okumak i�in kare matrisin alt ��gen
						// matrisini olu�tural�m ve diagonel elemanlar�n
						// toplamlar�n� alal�m
						altUcgen(x);
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}