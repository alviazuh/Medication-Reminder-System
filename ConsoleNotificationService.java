public class ConsoleNotificationService implements NotificationService {
    @Override
    public void kirimNotifikasi(String pesan) {
        System.out.println("[Notifikasi]: " + pesan);
    }
}
