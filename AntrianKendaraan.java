public class AntrianKendaraan {
    private Kendaraan[] antrian;
    private int head;
    private int tail;

    public AntrianKendaraan(int kapasitas) {
        antrian = new Kendaraan[kapasitas];
        head = 0;
        tail = 0;
    }

    public void tambahAntrian(Kendaraan k) {
        if (tail < antrian.length) {
            antrian[tail++] = k;
            System.out.println(">> Kendaraan masuk ke dalam antrian.");
        } else {
            System.out.println(">> Antrian penuh.");
        }
    }

    public Kendaraan layaniKendaraan() {
        if (isEmpty()) {
            return null;
        }
        return antrian[head++];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public int jumlahAntrian() {
        return tail - head;
    }

    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            for (int i = head; i < tail; i++) {
                System.out.println("Antrian Kendaraan:");
                antrian[i].tampilkanInformasi();
                System.out.println();
            }
        }
    }
}
