import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class ProductMenu extends JFrame {

    public static void main(String[] args) {
        // buat object window
        ProductMenu menu = new ProductMenu();

        // mengatur ukuran window
        menu.setSize(700, 600);

        // letakkan window di tengah layar
        menu.setLocationRelativeTo(null);

        // isi tampilan
        menu.setContentPane(menu.mainPanel);

        // ubah warna background
        menu.getContentPane().setBackground(Color.WHITE);

        // tampilkan ke layar
        menu.setVisible(true);

        // agar program ikut berhenti saat window diclose
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // atribut GUI atau komponen tampilan
    private JPanel mainPanel;
    private JTextField idField;
    private JTextField namaField;
    private JTextField hargaField;
    private JTable productTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox<String> kategoriComboBox;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel idLabel;
    private JLabel namaLabel;
    private JLabel hargaLabel;
    private JLabel kategoriLabel;
    private JLabel stokLabel;
    private JLabel stokValueLabel;
    private JSlider stokSlider;

    // atribut tambahan
    private Database db;            // objek untuk koneksi database
    private int selectedIndex = -1; // menyimpan baris tabel yang diklik

    // constructor
    public ProductMenu() {
        // hubungkan ke database
        db = new Database();

        // tampilkan data dari DB di tabel
        productTable.setModel(setTable());

        // ubah styling title
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));

        // atur isi combo box
        String[] kategoriData = {"???", "Elektronik", "Makanan", "Minuman", "Pakaian", "Alat Tulis"};
        kategoriComboBox.setModel(new DefaultComboBoxModel<>(kategoriData));

        // sembunyikan tombol delete
        deleteButton.setVisible(false);

        // tampilkan nilai stok slider di label
        stokSlider.addChangeListener(e -> stokValueLabel.setText(String.valueOf(stokSlider.getValue())));

        // tombol add/update
        addUpdateButton.addActionListener(e -> {
            String action = addUpdateButton.getText();
            if (action.equals("Add")) {
                insertData();
            } else if (action.equals("Update")) {
                if (selectedIndex >= 0) {
                    updateData();
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih dulu data yang ingin diubah!", "Tidak ada data dipilih", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // tombol delete
        deleteButton.addActionListener(e -> {
            int selectedRow = productTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Pilih dulu produk yang ingin dihapus!", "Tidak ada produk dipilih", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(null, "Apakah kamu yakin ingin menghapus produk ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                deleteData();
                deleteButton.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Penghapusan dibatalkan.", "Dibatalkan", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // tombol cancel
        cancelButton.addActionListener(e -> clearForm());

        // klik tabel
        productTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedIndex = productTable.getSelectedRow();

                String curId = productTable.getModel().getValueAt(selectedIndex, 1).toString();
                String curNama = productTable.getModel().getValueAt(selectedIndex, 2).toString();
                String curHarga = productTable.getModel().getValueAt(selectedIndex, 3).toString();
                String curStok = productTable.getModel().getValueAt(selectedIndex, 4).toString();
                String curKategori = productTable.getModel().getValueAt(selectedIndex, 5).toString();

                idField.setText(curId);
                namaField.setText(curNama);
                hargaField.setText(curHarga);
                stokSlider.setValue(Integer.parseInt(curStok));
                kategoriComboBox.setSelectedItem(curKategori);

                addUpdateButton.setText("Update");
                deleteButton.setVisible(true);
            }
        });
    }

    // tampilkan tabel dari database
    public final DefaultTableModel setTable() {
        Object[] cols = {"No", "ID Produk", "Nama", "Harga", "Stok", "Kategori"};
        DefaultTableModel tmp = new DefaultTableModel(null, cols);

        try {
            ResultSet rs = db.getData("SELECT * FROM produk");
            int i = 1;
            while (rs.next()) {
                Object[] row = {
                        i++,
                        rs.getString("id"),
                        rs.getString("nama"),
                        rs.getDouble("harga"),
                        rs.getInt("stok"),
                        rs.getString("kategori")
                };
                tmp.addRow(row);
            }
        } catch (Exception e) {
            System.out.println("Error setTable: " + e.getMessage());
        }

        return tmp;
    }

    // tambah data ke database
    public void insertData() {
        try {
            String id = idField.getText();
            String nama = namaField.getText();
            double harga = Double.parseDouble(hargaField.getText());
            int stok = stokSlider.getValue();
            String kategori = kategoriComboBox.getSelectedItem().toString();

            if (id.isEmpty() || nama.isEmpty() || kategori.equals("???")) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!");
                return;
            }

            ResultSet rs = db.getData("SELECT * FROM produk WHERE id='" + id + "'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "ID sudah ada!");
                return;
            }

            String sql = "INSERT INTO produk VALUES ('" + id + "', '" + nama + "', " + harga + ", " + stok + ", '" + kategori + "')";
            db.updateData(sql);

            JOptionPane.showMessageDialog(null, "Produk berhasil ditambahkan!");
            productTable.setModel(setTable());
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menambah data: " + e.getMessage());
        }
    }

    // update data ke database
    public void updateData() {
        try {
            String id = idField.getText();
            String nama = namaField.getText();
            double harga = Double.parseDouble(hargaField.getText());
            int stok = stokSlider.getValue();
            String kategori = kategoriComboBox.getSelectedItem().toString();

            String sql = "UPDATE produk SET nama='" + nama + "', harga=" + harga +
                    ", stok=" + stok + ", kategori='" + kategori + "' WHERE id='" + id + "'";
            db.updateData(sql);

            JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
            productTable.setModel(setTable());
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal update data: " + e.getMessage());
        }
    }

    // hapus data dari database
    public void deleteData() {
        try {
            String id = idField.getText();
            String sql = "DELETE FROM produk WHERE id='" + id + "'";
            db.updateData(sql);

            JOptionPane.showMessageDialog(null, "Produk berhasil dihapus!");
            productTable.setModel(setTable());
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal hapus data: " + e.getMessage());
        }
    }

    // bersihkan form input
    public void clearForm() {
        idField.setText("");
        namaField.setText("");
        hargaField.setText("");
        stokSlider.setValue(0);
        kategoriComboBox.setSelectedIndex(0);

        addUpdateButton.setText("Add");
        deleteButton.setVisible(false);
        selectedIndex = -1;
    }
}
