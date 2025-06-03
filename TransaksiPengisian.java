public class TransaksiPengisian {
    Kendaraan kendaraan;
    BBM bbm;
    double liter;
    double totalBayar;

    public TransaksiPengisian(Kendaraan kendaraan, BBM bbm, double liter) {
        this.kendaraan = kendaraan;
        this.bbm = bbm;
        this.liter = liter;
        this.totalBayar = liter * bbm.getHargaPerLiter();
    }

    public void tampilkanInformasi() {
        System.out.println("Plat: " + kendaraan.getPlatNomor());
        System.out.println("BBM: " + bbm.getNamaBBM());
        System.out.println("Liter: " + liter);
        System.out.println("Total Bayar: Rp " + totalBayar);
    }
}
