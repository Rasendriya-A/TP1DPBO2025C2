<h1 align="center">Latihan Modul dan Tugas Praktikum 1</h1>

<h3 align="left">Janji</h3>
Saya Rasendriya Andhika dengan NIM 2305309 mengerjakan Latihan Modul dan Tugas Praktikum 1 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

<h3 align="left">Desain Program</h3>
Program terdiri dari 1 class yaitu DPR
Didalam class PetShop memiliki 4 Atribut, yaitu :
1. ID
2. Nama
3. Kategori
4. Harga
lalu untuk bahasa PHP ada atribut tambahan yaitu :
5. Foto

<h3 align="left">Alur Program</h3>
1. Menampilkan semua produk
   - Menu ini digunakan untuk melihat daftar semua produk yang sudah terdaftar.  
   - Jika belum ada produk yang terdaftar, akan muncul pesan bahwa daftar produk masih kosong.  

2. Menambahkan produk
   - Menu ini digunakan untuk menambahkan produk baru ke dalam sistem.  
   - Pengguna akan diminta memasukkan ID, kategori, nama, dan harga produk.  
   - Program akan memeriksa apakah ID yang dimasukkan sudah ada atau belum. Jika ID sudah ada, produk tidak bisa ditambahkan.  

3. Mengubah produk
   - Menu ini digunakan untuk mengubah atribut dari produk yang sudah ada.  
   - Pengguna harus memasukkan nama produk yang ingin diubah, lalu memilih atribut yang akan diubah (ID, kategori, nama, atau harga).  
   - Jika produk dengan nama yang dimasukkan tidak ditemukan, perubahan tidak dapat dilakukan.  

4. Menghapus produk
   - Menu ini digunakan untuk menghapus produk berdasarkan nama produk.  
   - Jika produk ditemukan, produk akan dihapus dari daftar.  
   - Jika produk tidak ditemukan, akan muncul pesan bahwa produk tidak dapat dihapus karena tidak terdaftar.  

5. Mencari produk 
   - Menu ini digunakan untuk mencari produk berdasarkan nama produk.  
   - Jika produk ditemukan, informasi produk akan ditampilkan.  
   - Jika produk tidak ditemukan, akan muncul pesan bahwa produk tidak tersedia.  

6. Selesai (Keluar dari program)  
   - Menu ini digunakan untuk keluar dari program.  

<h3 align="left">Aturan dalam program</h3>  
1. ID sebagai Primary Key 
  - ID produk harus unik (tidak boleh ada ID yang sama saat menambahkan atau mengubah produk).  
  - Saat mengubah data, ID tidak boleh diganti dengan ID yang sudah ada.  
  - Saat menambahkan produk, jika ID sudah ada, produk tidak bisa ditambahkan.  

2. Penghapusan berdasarkan Nama Produk
  - Untuk menghapus produk, pengguna harus memasukkan nama produk. Jika nama produk tidak ditemukan, penghapusan tidak bisa dilakukan.  

3. Perubahan data berdasarkan Nama Produk
  - Untuk mengubah produk, pengguna harus memasukkan nama produk. Jika nama produk tidak ditemukan, data tidak bisa diubah.  
