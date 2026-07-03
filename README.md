# Knowledge Management System Putusan Pengadilan Narkotika

> **Tugas Besar Pemrograman Berorientasi Objek (PBO)**  
> Java JDK 25 • Maven • MVC • Console Application + JavaFX GUI

Aplikasi **Knowledge Management System (KMS) Putusan Pengadilan Narkotika** merupakan aplikasi berbasis Java untuk mengelola data putusan perkara narkotika. Sistem ini menerapkan arsitektur **Model-View-Controller (MVC)** agar pengelolaan data, proses bisnis, dan antarmuka pengguna dipisahkan dengan jelas.

Data yang dikelola meliputi nomor perkara, pengadilan, tanggal putusan, identitas terdakwa, jenis dan berat barang bukti, pasal yang dilanggar, peran terdakwa, vonis hukuman, denda, serta nama hakim.

---

## Anggota Kelompok

| Nama                     | NIM             | Kelas | Peran                                           | Branch Utama                    |
|--------------------------|-----------------|-------|-------------------------------------------------|---------------------------------|
| Najmul Akhyar Sutiyono   | 202510370110032 |   B   | UI/View Developer                               | feature/view                    |
| Lebda Kalandra Jambunada | 202510370110043 |   B   | Backend Developer / Controller Engineer         | feature/main-controller-util    |
| Erwin Susilo Wanto       | 202510370110013 |   B   | Developer / Model & Supporting Feature Engineer | feature/model                   |


---

## Tujuan Proyek

1. Menerapkan konsep **Object-Oriented Programming (OOP)** dalam pengelolaan data putusan narkotika.
2. Menerapkan arsitektur **Model-View-Controller (MVC)**.
3. Menggunakan `ArrayList` sebagai koleksi data dinamis.
4. Menyediakan validasi input dan *exception handling* agar aplikasi tidak berhenti ketika menerima input yang tidak valid.
5. Menerapkan kolaborasi tim menggunakan Git dan GitHub.

---

## Fitur Aplikasi

| Fitur                | Keterangan                                                                                                             |
|----------------------|------------------------------------------------------------------------------------------------------------------------|
| Tambah putusan       | Menambahkan data putusan baru melalui konsol atau form JavaFX.                                                         |
| Tampilkan semua data | Menampilkan daftar seluruh putusan dalam format tabel.                                                                 |
| Pencarian            | Mencari putusan berdasarkan nomor perkara atau nama terdakwa.                                                          |
| Filter data          | Menyaring data berdasarkan jenis narkotika, pengadilan, atau rentang vonis.                                            |
| Hapus putusan        | Menghapus data berdasarkan nomor perkara atau baris terpilih pada GUI.                                                 |
| Statistik ringkas    | Menampilkan total putusan, rata-rata vonis, rata-rata denda, jenis narkotika terbanyak, dan distribusi peran terdakwa. |
| Pengurutan data      | Mengurutkan putusan berdasarkan vonis paling kecil atau denda terbesar.                                                |
| Validasi input       | Menolak input angka yang tidak valid, data kosong, nilai negatif, dan nomor perkara duplikat.                          |
| Console View         | Antarmuka utama berbasis menu terminal.                                                                                |
| JavaFX GUI           | Antarmuka grafis dengan tabel, pencarian nama, filter jenis, form tambah data, hapus data, statistik, dan pengurutan.  |

---

## Implementasi Konsep OOP

| Konsep                  | Implementasi pada Proyek                                                                                        |
|-------------------------|-----------------------------------------------------------------------------------------------------------------|
| Class dan object        | Entitas utama direpresentasikan oleh class Putusan.                                                             |
| Enkapsulasi             | Seluruh field pada Putusan bersifat private dan diakses menggunakan getter/setter.                              | 
| Constructor overloading | Putusan memiliki constructor tanpa parameter, constructor lengkap, dan constructor ringkas.                     |
| Method overloading      | Method tampilkan() tersedia dalam bentuk tampilkan(), tampilkan(boolean detail), dan tampilkan(String prefix).  |
| Static field & method   | Putusan memiliki static int jumlahDibuat dan static getJumlahDibuat().                                          |
| Inheritance             | PutusanNarkotikaBerat extends Putusan untuk merepresentasikan putusan berkategori berat.                        |
| Interface               | Class Putusan mengimplementasikan interface Dapatdicetak.                                                       |
| Method overriding       | PutusanNarkotikaBerat melakukan override pada tampilkan(boolean), ringkasanSingkat(), dan toString().           | 
| ArrayList               | KnowledgeRepository menyimpan data melalui ArrayList<Putusan>.                                                  |
| Array statis            | DataSampel memakai array statis untuk data referensi; StatistikPutusan memakai String[] untuk distribusi peran. |
| Exception handling      | InputHandler menggunakan try-catch untuk menangani kesalahan input numerik dan teks kosong.                     |
| Enum                    | KategoriHukuman menentukan kategori vonis: Ringan, Sedang, atau Berat.                                          |
| Comparator              | KnowledgeRepository memakai `Comparator` untuk pengurutan vonis dan denda.                                      |

---

## Arsitektur MVC

```text
┌───────────────┐       Input / Aksi Pengguna       ┌───────────────────────┐
│     VIEW      │ ─────────────────────────────────▶│      CONTROLLER       │
│ ConsoleView   │                                    │ KnowledgeController   │
│ JavaFX GUI    │◀───────────────────────────────── │ Validasi & Proses     │
└───────────────┘       Hasil / Pesan / Data         └──────────┬────────────┘
                                                                  │
                                                                  ▼
                                                       ┌───────────────────────┐
                                                       │         MODEL         │
                                                       │ Putusan               │
                                                       │ KnowledgeRepository   │
                                                       │ StatistikPutusan      │
                                                       │ DataSampel            │
                                                       └───────────────────────┘
```

### Pembagian Tanggung Jawab MVC

- **Model** mengelola data putusan, repository, statistik, kategori hukuman, dan data sampel.
- **View** menampilkan menu, tabel, form input, dialog, serta pesan kepada pengguna.
- **Controller** menerima permintaan dari View, melakukan validasi dan proses bisnis, lalu meneruskan hasil ke View.
- View tidak mengakses `KnowledgeRepository` secara langsung.
- Seluruh proses tambah, cari, filter, hapus, statistik, dan pengurutan diproses melalui `KnowledgeController`.

---

## Struktur Proyek

```text
kms_java/
├── pom.xml
├── README.md
├── .gitignore
└── src/
    └── main/
        └── java/
            ├── app/
            │   └── Main.java
            ├── controller/
            │   └── KnowledgeController.java
            ├── model/
            │   ├── Dapatdicetak.java
            │   ├── DataSampel.java
            │   ├── KategoriHukuman.java
            │   ├── KnowledgeRepository.java
            │   ├── Putusan.java
            │   ├── PutusanNarkotikaBerat.java
            │   └── StatistikPutusan.java
            ├── util/
            │   └── InputHandler.java
            └── view/
                ├── ConsoleView.java
                ├── JavaFXApp.java
                └── JavaFXController.java
```

---

## Dataset

Aplikasi menyediakan **55 data sampel putusan** yang dimuat otomatis melalui class berikut:

```text
src/main/java/model/DataSampel.java
```

Data sampel dibuat dengan metode *hard-coded* melalui:

```java
DataSampel.generate();
```

Seluruh data sampel bersifat **fiktif atau sintetis** dan digunakan untuk mendemonstrasikan fitur tambah, tampilkan, pencarian, filter, penghapusan, statistik, dan pengurutan data.

Beberapa objek dibuat sebagai `PutusanNarkotikaBerat` untuk menunjukkan penerapan pewarisan dan polimorfisme.

> Parsing PDF putusan asli menggunakan Apache PDFBox belum diimplementasikan. Dependency PDFBox telah tersedia pada `pom.xml` sebagai persiapan pengembangan fitur bonus.

---

## Prasyarat

Pastikan perangkat telah memiliki:

- JDK 25
- Maven 3.8+
- IDE Java, seperti IntelliJ IDEA, Eclipse, atau NetBeans
- Git untuk kolaborasi dan version control

> Proyek ini menggunakan Java JDK 25 sebagai lingkungan pengembangan dan target kompilasi aplikasi.

---

## Cara Kompilasi

Buka terminal pada folder utama proyek, lalu jalankan:

```bash
mvn clean compile
```

Jika proses berhasil, Maven akan membuat folder `target/`.

---

## Cara Menjalankan

### 1. Menjalankan Versi Konsol

```bash
mvn exec:java
```

Atau melalui IDE:

```text
Jalankan class: src/main/java/app/Main.java
```

Menu konsol yang tersedia:

```text
1. Tambah Putusan Baru
2. Tampilkan Semua Putusan
3. Cari Putusan
4. Filter Putusan
5. Hapus Putusan
6. Tampilkan Statistik
7. Urutkan Data
8. Keluar
```

### 2. Menjalankan Versi JavaFX GUI

```bash
mvn javafx:run
```

Atau melalui IDE:

```text
Jalankan class: src/main/java/view/JavaFXApp.java
```

### 3. Membuat dan Menjalankan File JAR

```bash
mvn clean package
java -jar target/kms_java.jar
```

Perintah tersebut menjalankan aplikasi konsol dengan entry point `app.Main`.

---

## Validasi dan Penanganan Error

Class `InputHandler` menangani kesalahan input menggunakan mekanisme `try-catch`, antara lain:

- Pengguna memasukkan teks pada field yang seharusnya berupa angka.
- Pengguna memilih menu di luar batas pilihan yang tersedia.
- Pengguna memasukkan teks kosong.
- Nilai umur, berat barang bukti, vonis, atau denda tidak memenuhi batas minimum.
- Nomor perkara yang dimasukkan sudah tersedia di repository.
- Data putusan tidak lengkap atau tidak dapat dikonversi ke tipe data yang sesuai.

Aplikasi akan menampilkan pesan kesalahan dan meminta pengguna memasukkan data kembali tanpa menghentikan program.

---

## Strategi Git dan Kolaborasi

| Branch                       | Tujuan                                                                         | Penanggung Jawab                     |
|------------------------------|--------------------------------------------------------------------------------|--------------------------------------|
| main                         | Menyimpan kode final yang stabil dan siap dikumpulkan.                         | Seluruh anggota melalui Pull Request |
| feature/model                | Mengembangkan entity, repository, statistik, data sampel, enum, dan interface. | Erwin Susilo Wanto                   |
| feature/view                 | Mengembangkan ConsoleView dan JavaFX GUI.                                      | Najmul Akhyar Sutiyono               |
| feature/main-controller-util | Mengembangkan controller, validasi input, Main, dan integrasi fitur.           | Lebda Kalandra Jambunada             |

### Aturan Commit

Gunakan pesan commit yang deskriptif, contohnya:

```text
feat: tambah filter rentang vonis pada controller
feat: buat antarmuka JavaFX untuk tabel putusan
fix: tolak nomor perkara yang sudah terdaftar
refactor: pisahkan perhitungan statistik ke StatistikPutusan
docs: lengkapi README proyek PBO
```

Alur kolaborasi yang digunakan:

```text
feature/* -> Pull Request -> develop -> Pull Request -> main
```

---

## Video Demo

**Tautan Video Demo:**  
[]
