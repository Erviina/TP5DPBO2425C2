import java.sql.*;

public class Database {
    private Connection conn;    //objek koneksi untuk menyambungkan java ke database

    //constructor
    public Database() {
        try {
            // url yg digunakan database MysQl yg digunakan
            String url = "jdbc:mysql://localhost:3306/dbproduct";
            String user = "root"; // default user XAMPP
            String pass = "";     // default tanpa password

            //membuka koneksi ke database
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println(" Koneksi ke database berhasil!");
        } catch (SQLException e) {
            // Kalau koneksi gagal, tampilkan pesan error di console
            System.out.println(" Koneksi gagal: " + e.getMessage());
        }
    }
    // Method untuk mengembalikan objek koneksi
    public Connection getConnection() {

        return conn;
    }

    // Method untuk mengambil data dari database
    // Mengembalikan hasil query dalam bentuk ResultSet
    public ResultSet getData(String query) {
        try {
            // Membuat objek Statement untuk menjalankan query SQL
            Statement stmt = conn.createStatement();

            // Menjalankan query select dan mengembalikan hasilnya
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            // Jika terjadi error
            System.out.println("Error ambil data: " + e.getMessage());
            return null;
        }
    }

    // Method untuk mengubah data di database
    public int updateData(String query) {
        try {
            // membuat statement untuk menjalankan perintah SQL
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            // Jika ada kesalahan
            System.out.println("Error update data: " + e.getMessage());
            return 0;
        }
    }
}

