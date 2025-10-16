public class Product {
    // atribut produk
    private String id;          // kode unik untuk setiap produk
    private String nama;        // nama produk
    private double harga;       // harga produk
    private int stok;           // jumlah stok yg tersedia
    private String kategori;    // kategori produk

    // constructor utuk mengisi data awal
    public Product(String id, String nama, double harga, int stok, String kategori) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
    }

    // setter untuk mengubah nilai atribut
    public void setId(String id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setStok(int stok) {this.stok = stok;}


    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    // bagian getter untuk mengambil nilai produk
    public String getId() {
        return this.id;
    }

    public String getNama() {
        return this.nama;
    }

    public double getHarga() {
        return this.harga;
    }

    public int getStok() {return stok;}


    public String getKategori() {
        return this.kategori;
    }

}