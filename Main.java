import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Kendaraan[] antrian = new Kendaraan[100];
        TransaksiPengisian[] riwayatTransaksi = new TransaksiPengisian[100];

        int head = 0, tail = 0;
        int totalTransaksi = 0;
        int pilihan;

        do {
            System.out.println("\n--- Menu SPBU ---");
            System.out.println("1. Tambah Antrian Kendaraan");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Cek Jumlah Antrian Kendaraan");
            System.out.println("4. Layani Kendaraan");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Plat Nomor: ");
                    String plat = sc.nextLine();
                    System.out.print("Masukkan Jenis Kendaraan: ");
                    String tipe = sc.nextLine();
                    System.out.print("Masukkan Merk: ");
                    String merek = sc.nextLine();

                    antrian[tail++] = new Kendaraan(plat, tipe, merek);
                    System.out.println(">> Kendaraan masuk ke dalam antrian.");
                    break;

                case 2:
                    System.out.println("\n-- Antrian Kendaraan --");
                    if (tail == head) {
                        System.out.println("Antrian kosong.");
                    } else {
                        for (int i = head; i < tail; i++) {
                            System.out.println("Antrian Kendaraan:");
                            antrian[i].tampilkanInformasi();
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    System.out.println(">> Jumlah kendaraan dalam antrian: " + (tail - head));
                    break;

                case 4:
                    if (head == tail) {
                        System.out.println(">> Tidak ada kendaraan dalam antrian.");
                    } else {
                        Kendaraan dilayani = antrian[head++];
                        System.out.println("Petugas melayani " + dilayani.getPlatNommor());

                        System.out.print("Masukkan Jenis BBM: ");
                        String jenisBBM = sc.nextLine();
                        System.out.print("Masukkan Harga per liter: ");
                        double harga = sc.nextDouble();
                        System.out.print("Masukkan Jumlah liter: ");
                        double liter = sc.nextDouble();
                        sc.nextLine();

                        BBM bbm = new BBM(jenisBBM, harga);
                        TransaksiPengisian transaksi = new TransaksiPengisian(dilayani, bbm, liter);
                        riwayatTransaksi[totalTransaksi++] = transaksi;

                        System.out.println(">> Transaksi berhasil dicatat.");
                    }
                    break;

                case 5:
                    System.out.println("\n-- Riwayat Transaksi --");
                    if (totalTransaksi == 0) {
                        System.out.println("Belum ada transaksi.");
                    } else {
                        System.out.println("Daftar Transaksi:");
                        for (int i = 0; i < totalTransaksi; i++) {
                            riwayatTransaksi[i].tampilkanInformasi();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }

        } while (pilihan != 0);
    }
}
