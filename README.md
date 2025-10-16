Saya Ervina Kusnanda dengan NIM 2409082 mengerjakan Tugas Praktikum 5 dalam mata kuliah Desain Pemogramana Berorientasi Objek untuk keberkahanNya 
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin

**Desain Program**

terdiri dari tiga bagian utama, yaitu:

1. Kelas Product
   Kelas ini berfungsi sebagai model data yang merepresentasikan satu produk. Di dalamnya terdapat atribut seperti id, nama, harga, stok, dan kategori.
   Kelas ini juga memiliki getter dan setter untuk setiap atribut agar data bisa diakses dan diubah dengan cara yang aman.

2. Kelas Database
   Kelas ini bertanggung jawab untuk mengatur koneksi antara program dan database MySQL.
   Di dalamnya terdapat fungsi untuk menjalankan perintah SQL seperti:
   - getData() untuk mengambil data (SELECT)
   - updateData() untuk menambah, mengubah, dan menghapus data (INSERT, UPDATE, DELETE).
   Saat program dijalankan, kelas ini langsung mencoba membuat koneksi ke database menggunakan JDBC (Java Database Connectivity).

3. Kelas ProductMenu
   Kelas ini merupakan bagian utama program yang menampilkan tampilan antarmuka (GUI) menggunakan Java Swing.
   Di sini, pengguna dapat:
   - Melihat daftar produk yang sudah tersimpan di database.
   - Menambah produk baru dengan mengisi form dan menekan tombol Add.
   - Mengubah data produk dengan memilih baris di tabel dan menekan tombol Update.
   - Menghapus produk yang dipilih dengan tombol Delete.
   - Mengosongkan form input menggunakan tombol Cancel.
     
   Program juga menampilkan pesan atau peringatan kepada pengguna, misalnya:
   - Jika ada kolom input yang masih kosong.
   - Jika ID produk sudah ada di database (untuk menghindari duplikasi).
   - Jika data berhasil ditambah, diubah, atau dihapus.

**Alur Program**

Program dimulai

1. Kelas ProductMenu dijalankan, menampilkan jendela utama aplikasi.
   Di dalam constructor, program langsung:
   - Membuat koneksi ke database (melalui Database db = new Database();)
   - Mengambil semua data dari tabel produk untuk ditampilkan di tabel GUI.
   - Menampilkan Data Awal
   - Method setTable() menjalankan perintah SQL SELECT * FROM produk.
   - Data yang diambil dari database diubah ke dalam bentuk baris tabel (DefaultTableModel) dan ditampilkan di aplikasi.

2. Menambah Data (Add)
   Pengguna mengisi form (ID, nama, harga, stok, kategori).
   Saat klik tombol Add:
   - Program mengecek apakah semua kolom sudah diisi.
   - Mengecek apakah ID produk sudah ada di database (menghindari duplikasi).
   - Jika valid, data disimpan ke database dengan perintah INSERT INTO produk VALUES (...).
   - Tabel di-refresh dan menampilkan data terbaru.

3. Mengubah Data (Update)
   Pengguna klik salah satu baris pada tabel.
   Data produk akan muncul di form input. Setelah diubah dan tombol Update ditekan:
   - Program menjalankan perintah SQL UPDATE produk SET ... WHERE id = ...
   - Data di database berubah, dan tabel di GUI diperbarui.

4. Menghapus Data (Delete)
   Pengguna pilih baris produk lalu klik tombol Delete.
   - Muncul dialog konfirmasi.
   - Jika dikonfirmasi, data dihapus dengan perintah DELETE FROM produk WHERE id = ....
   - Tabel langsung diperbarui.

5. Membersihkan Form (Cancel)
   - Tombol Cancel mengosongkan semua input dan mengembalikan tombol “Update” menjadi “Add”.
   - Interaksi Real-time
   - Slider stok (JSlider) secara otomatis menampilkan nilai di label saat digeser.

Pengguna akan mendapat umpan balik dialog informasi atau peringatan (misalnya: “Data berhasil ditambahkan!” atau “Semua kolom harus diisi!”).

**Dokumentasi**

coba add produk
![add produk](https://github.com/Erviina/TP5DPBO2425C2/blob/main/dokumentasi/add%20data%20di%20tabel.png?raw=true)

data berhasil di tambahkan
![add produk](https://github.com/Erviina/TP5DPBO2425C2/blob/main/dokumentasi/data%20berhasil%20di%20tambahkan.png?raw=true)

pada database data juga bertambah
![add produk](https://github.com/Erviina/TP5DPBO2425C2/blob/main/dokumentasi/nambah%20pada%20dbproduct.png?raw=true)

coba update data
![update produk](https://github.com/Erviina/TP5DPBO2425C2/blob/main/dokumentasi/update%20data.png?raw=true)

berhasil update
![update produk](https://github.com/Erviina/TP5DPBO2425C2/blob/main/dokumentasi/berhasil%20update%20data.png?raw=true)

update pada table
![update produk](https://github.com/Erviina/TP5DPBO2425C2/blob/main/dokumentasi/update%20tabel.png?raw=true)

update pada database
![update produk](https://github.com/Erviina/TP5DPBO2425C2/blob/main/dokumentasi/update%20pada%20dbproduct.png?raw=true)

coba hapus data
![delete produk](https://github.com/Erviina/TP5DPBO2425C2/blob/main/dokumentasi/delete%20data.png?raw=true)

data berhasil di hapus
![delete produk](https://github.com/Erviina/TP5DPBO2425C2/blob/main/dokumentasi/berhasil%20delete.png?raw=true)

data terhapus di tabel
![delete produk](https://github.com/Erviina/TP5DPBO2425C2/blob/main/dokumentasi/data%20kehapus%20di%20tabel.png?raw=true)

data terhapus dalam database
![delete produk](https://github.com/Erviina/TP5DPBO2425C2/blob/main/dokumentasi/delete%20pada%20dbproduct.png?raw=true)

