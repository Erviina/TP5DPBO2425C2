-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 16 Okt 2025 pada 21.58
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";



--
-- Database: `dbproduct`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `produk`
--

CREATE TABLE `produk` (
  `id` varchar(10) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `harga` double DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `kategori` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `produk`
--

INSERT INTO `produk` (`id`, `nama`, `harga`, `stok`, `kategori`) VALUES
('P001', 'Laptop Asus', 8500000, 10, 'Elektronik'),
('P002', 'Mouse Logitech', 350000, 5, 'Elektronik'),
('P003', 'Keyboard Mechanical', 750000, 4, 'Elektronik'),
('P004', 'Roti Tawar', 15000, 11, 'Makanan'),
('P005', 'Susu UHT', 12000, 9, 'Minuman'),
('P006', 'Kemeja Putih', 125000, 7, 'Pakaian'),
('P007', 'Celana Jeans', 200000, 15, 'Pakaian'),
('P008', 'Pensil 2B', 3000, 10, 'Alat Tulis'),
('P009', 'Buku Tulis', 8000, 7, 'Alat Tulis'),
('P010', 'Air Mineral', 5000, 7, 'Minuman'),
('P011', 'Smartphone Samsung', 4500000, 8, 'Elektronik'),
('P012', 'Kue Brownies', 25000, 8, 'Makanan'),
('P013', 'Jaket Hoodie', 180000, 12, 'Pakaian'),
('P014', 'Pulpen Gel', 5000, 12, 'Alat Tulis'),
('P015', 'Teh Botol', 8000, 6, 'Minuman'),
('P016', 'SoundBar ', 3500000, 15, 'Elektronik');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`id`);
COMMIT;
