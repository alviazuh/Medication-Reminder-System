import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MedicationManager implements MedicationService {
    private List<Medication> daftarObat = new ArrayList<>();
    private NotificationService notifikasi;

    public MedicationManager(NotificationService notifikasi) {
        this.notifikasi = notifikasi;
    }

    @Override
    public void tambahObat(String nama, String jam) {
        daftarObat.add(new Medication(nama, jam));
        notifikasi.kirimNotifikasi("Obat ditambahkan: " + nama + " pada pukul " + jam);
    }

    @Override
    public void hapusObat(String nama) {
        boolean dihapus = daftarObat.removeIf(obat -> obat.nama.equalsIgnoreCase(nama));
        if (dihapus) {
            notifikasi.kirimNotifikasi("Obat dihapus: " + nama);
        } else {
            System.out.println("Obat tidak ditemukan: " + nama);
        }
    }

    @Override
    public void tampilkanDaftarObat() {
        if (daftarObat.isEmpty()) {
            System.out.println("Belum ada jadwal obat.");
        } else {
            System.out.println("Daftar Obat Saat Ini:");
            for (Medication obat : daftarObat) {
                System.out.println("- " + obat.nama + " pada pukul " + obat.jam);
            }
        }
    }

    @Override
    public void minumObat(String jamSaatIni) {
        Iterator<Medication> iterator = daftarObat.iterator();
        boolean adaObat = false;

        while (iterator.hasNext()) {
            Medication obat = iterator.next();
            if (obat.jam.equalsIgnoreCase(jamSaatIni)) {
                System.out.println("Saatnya minum obat: " + obat.nama);
                notifikasi.kirimNotifikasi("Obat " + obat.nama + " telah diminum pada pukul " + jamSaatIni);
                iterator.remove();
                adaObat = true;
            }
        }

        if (!adaObat) {
            System.out.println("Tidak ada obat yang perlu diminum pada pukul " + jamSaatIni);
        }
    }
}
