#include "petshop.cpp"

int main() {
    int n;
    cout << "Masukkan jumlah maksimal produk: ";
    cin >> n;

    petshop jangki[n]; // Array statis untuk menyimpan produk
    int jumlahProduk = 0; // Variabel untuk melacak jumlah produk yang tersimpan
    int menu; // Variabel menu utama

    do {
        // Tampilkan menu utama
        cout << "\nMenu:\n";
        cout << "1. Menampilkan semua produk\n";
        cout << "2. Menambahkan produk\n";
        cout << "3. Mengubah produk\n";
        cout << "4. Menghapus produk\n";
        cout << "5. Mencari produk\n";
        cout << "6. Selesai\n";
        cout << "Masukkan pilihan Anda: ";
        cin >> menu;

        switch (menu) 
        {
            case 1: 
            {
                // Menampilkan semua produk
                if (jumlahProduk == 0) 
                {
                    cout << "Belum ada produk yang terdaftar.\n";
                } 
                else 
                {
                    cout << "Daftar Produk:\n";
                    for(int i = 0; i < jumlahProduk; i++) 
                    {
                        cout << "ID: " << jangki[i].getId() << ", ";
                        cout << "Kategori: " << jangki[i].getKategoriProduk() << ", ";
                        cout << "Nama: " << jangki[i].getNamaProduk() << ", ";
                        cout << "Harga: " << jangki[i].getHargaProduk() << "\n";
                    }
                }
                break;
            }
            case 2: 
            {
                // Menambahkan produk
                if (jumlahProduk >= n) 
                {
                    cout << "Array penuh. Tidak dapat menambahkan produk baru.\n";
                } 
                else 
                {
                    string id, kategori, nama;
                    int harga;

                    cout << "Masukkan ID produk: ";
                    cin >> id;
                    cout << "Masukkan kategori produk: ";
                    cin >> kategori;
                    cout << "Masukkan nama produk: ";
                    cin.ignore();
                    getline(cin, nama);
                    cout << "Masukkan harga produk: ";
                    cin >> harga;

                    // Cek apakah ID produk sudah ada
                    bool idAda = false;
                    int i = 0;
                    while ((i < jumlahProduk) && (idAda == false))
                    {
                        if (jangki[i].getId() == id) 
                        {
                            idAda = true;
                        }
                        i++;
                    }

                    if (idAda) 
                    {
                        cout << "Produk dengan ID tersebut sudah ada. Tambah produk ditolak.\n";
                    } 
                    else 
                    {
                        // Menggunakan setter untuk mengisi data
                        jangki[jumlahProduk].setId(id);
                        jangki[jumlahProduk].setKategoriProduk(kategori);
                        jangki[jumlahProduk].setNamaProduk(nama);
                        jangki[jumlahProduk].setHargaProduk(harga);
                        jumlahProduk++;
                        cout << "Produk berhasil ditambahkan.\n";
                    }
                }
                break;
            }
            case 3: 
            {
                // Mengubah produk
                string nama;
                cout << "Masukkan nama produk yang ingin diubah: ";
                cin.ignore();
                getline(cin, nama);

                bool ditemukan = false;
                for (int i = 0; i < jumlahProduk; i++) 
                {
                    if (jangki[i].getNamaProduk() == nama) 
                    {
                        ditemukan = true;
                        int pilihan;
                        cout << "Atribut apa yang ingin Anda ubah?\n";
                        cout << "1. ID\n2. Kategori\n3. Nama\n4. Harga\n";
                        cout << "Masukkan pilihan: ";
                        cin >> pilihan;

                        switch (pilihan) 
                        {
                            case 1: 
                            {
                                string newId;
                                cout << "Masukkan ID baru: ";
                                cin >> newId;
                                jangki[i].setId(newId);
                                cout << "ID berhasil diubah.\n";
                                break;
                            }
                            case 2: 
                            {
                                string newKategori;
                                cout << "Masukkan kategori baru: ";
                                cin >> newKategori;
                                jangki[i].setKategoriProduk(newKategori);
                                cout << "Kategori berhasil diubah.\n";
                                break;
                            }
                            case 3: 
                            {
                                string newNama;
                                cout << "Masukkan nama baru: ";
                                cin.ignore();
                                getline(cin, newNama);
                                jangki[i].setNamaProduk(newNama);
                                cout << "Nama berhasil diubah.\n";
                                break;
                            }
                            case 4: 
                            {
                                int newHarga;
                                cout << "Masukkan harga baru: ";
                                cin >> newHarga;
                                jangki[i].setHargaProduk(newHarga);
                                cout << "Harga berhasil diubah.\n";
                                break;
                            }
                            default:
                                cout << "Pilihan tidak valid.\n";
                        }
                        break;
                    }
                }

                if (!ditemukan) 
                {
                    cout << "Produk dengan nama tersebut tidak ditemukan.\n";
                }
                break;
            }
            case 4: 
            {
                // Menghapus produk
                string nama;
                cout << "Masukkan nama produk yang ingin dihapus: ";
                cin.ignore();
                getline(cin, nama);

                bool ditemukan = false;
                int i = 0;
                while ((i < jumlahProduk) && (ditemukan == false))
                {
                    if (jangki[i].getNamaProduk() == nama) 
                    {
                        // Geser semua elemen setelah produk yang ditemukan
                        for (int j = i; j < jumlahProduk - 1; j++) 
                        {
                            jangki[j] = jangki[j + 1];
                        }
                        jumlahProduk--; // Kurangi jumlah produk
                        cout << "Produk berhasil dihapus.\n";
                        ditemukan = true;
                    }
                    i++;
                }

                if (!ditemukan) 
                {
                    cout << "Produk dengan nama tersebut tidak ditemukan.\n";
                }
                break;
            }
            case 5: 
            {
                // Mencari produk
                string nama;
                cout << "Masukkan nama produk yang ingin dicari: ";
                cin.ignore();
                getline(cin, nama);

                bool ditemukan = false;
                int i = 0;
                while ((i < jumlahProduk) && (ditemukan == false))
                {
                    if (jangki[i].getNamaProduk() == nama) 
                    {
                        cout << "Produk ditemukan:\n";
                        cout << "ID: " << jangki[i].getId() << "\n";
                        cout << "Kategori: " << jangki[i].getKategoriProduk() << "\n";
                        cout << "Nama: " << jangki[i].getNamaProduk() << "\n";
                        cout << "Harga: " << jangki[i].getHargaProduk() << "\n";
                        ditemukan = true;
                    }
                    i++;
                }

                if (!ditemukan) 
                {
                    cout << "Produk tidak ditemukan.\n";
                }
                break;
            }
            case 6:
                // Selesai
                cout << "Terima kasih telah menggunakan program ini!\n";
                break;
            default:
                cout << "Pilihan tidak valid. Silakan coba lagi.\n";
        }
    } while (menu != 6);

    return 0;
}
