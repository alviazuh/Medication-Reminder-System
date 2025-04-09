import java.util.Scanner;

public class MedicationReminderApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NotificationService notifikasi = new ConsoleNotificationService();
        MedicationService layananObat = new MedicationManager(notifikasi);

        while (true) {
            System.out.println("\n=== Sistem Pengingat Obat ===");
            System.out.println("1. Tambah Obat");
            System.out.println("2. Hapus Obat");
            System.out.println("3. Lihat Daftar Obat");
            System.out.println("4. Minum Obat");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); 
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama obat: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan jam minum obat : ");
                    String jam = scanner.nextLine();
                    layananObat.tambahObat(nama, jam);
                    break;
                case 2:
                    System.out.print("Masukkan nama obat yang ingin dihapus: ");
                    String namaHapus = scanner.nextLine();
                    layananObat.hapusObat(namaHapus);
                    break;
                case 3:
                    layananObat.tampilkanDaftarObat();
                    break;
                case 4:
                    System.out.print("Masukkan jam saat ini: ");
                    String jamSekarang = scanner.nextLine();
                    layananObat.minumObat(jamSekarang);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan Sistem Pengingat Obat!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
