public interface MedicationService {
    void tambahObat(String nama, String jam);
    void hapusObat(String nama);
    void tampilkanDaftarObat();
    void minumObat(String jamSaatIni);
}
