public class Kendaraan {
    String platNomor;
    String tipe; 
    String merek;

    public Kendaraan(String platNomor, String tipe, String merek) {
        this.platNomor = platNomor;
        this.tipe = tipe;
        this.merek = merek;
    }

    public String getPlatNommor() {
        return platNomor;
    }

    public void tampilkanInformasi() {
        System.out.println("Plat Nomor : " + platNomor);
        System.out.println("Tipe : " + tipe);
        System.out.println("Merek: " + merek);
    }
}
