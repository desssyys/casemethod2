public class QueueTransaksi {
    TransaksiPengisian[] data;
    int head, tail, size;

    public QueueTransaksi(int kapasitas) {
        data = new TransaksiPengisian[kapasitas];
        head = tail = size = 0;
    }

    public void tambah(TransaksiPengisian t) {
        if (size == data.length) {
            System.out.println(">> Riwayat transaksi penuh.");
            return;
        }
        data[tail] = t;
        tail = (tail + 1) % data.length;
        size++;
    }

    public void tampilkanRiwayat() {
        if (size == 0) {
            System.out.println("Belum ada transaksi.");
        } else {
            int i = head;
            for (int j = 0; j < size; j++) {
                System.out.println("Transaksi ke-" + (j + 1));
                data[i].tampilkanInformasi();
                i = (i + 1) % data.length;
            }
        }
    }
}
