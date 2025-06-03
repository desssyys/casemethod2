import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListAntrian antrian = new LinkedListAntrian();
        QueueTransaksi riwayat = new QueueTransaksi(100);

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
            sc.nextLine(); // buang newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Plat Nomor: ");
                    String plat = sc.nextLine();
                    System.out.print("Masukkan Jenis Kendaraan: ");
                    String tipe = sc.nextLine();
                    System.out.print("Masukkan Merek: ");
                    String merek = sc.nextLine();
                    Kendaraan k = new Kendaraan(plat, tipe, merek);
                    antrian.tambahAntrian(k);
                    break;

                case 2:
                    System.out.println("\n-- Daftar Antrian --");
                    antrian.tampilkanAntrian();
                    break;

                case 3:
                    System.out.println(">> Jumlah kendaraan dalam antrian: " + antrian.jumlahAntrian());
                    break;

                case 4:
                    Kendaraan dilayani = antrian.layaniKendaraan();
                    if (dilayani == null) {
                        System.out.println(">> Tidak ada kendaraan dalam antrian.");
                    } else {
                        System.out.println(">> Melayani kendaraan: " + dilayani.getPlatNomor());
                        System.out.print("Masukkan Jenis BBM: ");
                        String jenisBBM = sc.nextLine();
                        System.out.print("Masukkan Harga per liter: ");
                        double harga = sc.nextDouble();
                        System.out.print("Masukkan Jumlah liter: ");
                        double liter = sc.nextDouble();
                        sc.nextLine(); // buang newline

                        BBM bbm = new BBM(jenisBBM, harga);
                        TransaksiPengisian transaksi = new TransaksiPengisian(dilayani, bbm, liter);
                        riwayat.tambah(transaksi);
                        System.out.println(">> Transaksi berhasil dicatat.");
                    }
                    break;

                case 5:
                    System.out.println("\n-- Riwayat Transaksi --");
                    riwayat.tampilkanRiwayat();
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println(">> Pilihan tidak valid.");
            }

        } while (pilihan != 0);
    }
}
