public class LinkedListAntrian {
    KendaraanNode head, tail;
    int size;

    public LinkedListAntrian() {
        head = tail = null;
        size = 0;
    }

    public void tambahAntrian(Kendaraan k) {
        KendaraanNode baru = new KendaraanNode(k);
        if (head == null) {
            head = tail = baru;
        } else {
            tail.next = baru;
            tail = baru;
        }
        size++;
        System.out.println(">> Kendaraan masuk ke dalam antrian.");
    }

    public Kendaraan layaniKendaraan() {
        if (head == null) {
            return null;
        }
        Kendaraan temp = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return temp;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int jumlahAntrian() {
        return size;
    }

    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            KendaraanNode bantu = head;
            int i = 1;
            while (bantu != null) {
                System.out.println("Antrian ke-" + i++);
                bantu.data.tampilkanInformasi();
                bantu = bantu.next;
            }
        }
    }
}
