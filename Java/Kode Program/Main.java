import java.util.Scanner;

class Main{
    
    public static void main(String args[]) 
    {
        int n = 0;
        int jumlahProduk = 0;
        int menu = 0;
        int i = 0;
        int j = 0;

        System.out.println("Masukkan jumlah maksimal produk: ");
        Scanner sc = new Scanner(System.in);
        try 
        {
            n = sc.nextInt();
        } 
        catch (Exception e) 
        {
            System.out.println("Input tidak valid. Program dihentikan.");
            return;
        }

        // Membuat array of object petshop
        PetShop[] jangki = new PetShop[n];

        // Menginisialisasi setiap elemen array dengan objek PetShop
        for (i = 0; i < n; i++) 
        {
            jangki[i] = new PetShop();
        }

        do {
            System.out.println("+-----------------------------+");
            System.out.println("| Menu:                       |");
            System.out.println("+-----------------------------+");
            System.out.println("| 1. Menampilkan semua produk |");
            System.out.println("| 2. Menambahkan produk       |");
            System.out.println("| 3. Mengubah produk          |");
            System.out.println("| 4. Menghapus produk         |");
            System.out.println("| 5. Mencari produk           |");
            System.out.println("| 6. Selesai                  |");
            System.out.println("+-----------------------------+");
            System.out.println("Masukkan pilihan Anda: ");
            menu = sc.nextInt();
            
            switch (menu) 
            {
                case 1: 
                {
                    // Menampilkan semua produk
                    if (jumlahProduk == 0) 
                    {
                        System.out.println("Belum ada produk yang terdaftar.");
                    } 
                    else 
                    {
                        System.out.println("Daftar Produk:");
                        i = 0;
                        while (i < jumlahProduk) 
                        {
                            System.out.println("ID: " + jangki[i].getId() + ", " +
                                               "Kategori: " + jangki[i].getKategoriProduk() + ", " +
                                               "Nama: " + jangki[i].getNamaProduk() + ", " +
                                               "Harga: Rp" + jangki[i].getHargaProduk());
                            i++;
                        }
                    }
                    break;
                }
                case 2: 
                {
                    // Menambahkan produk
                    if (jumlahProduk >= n) 
                    {
                        System.out.println("Array penuh. Tidak dapat menambahkan produk baru.");
                    } 
                    else 
                    {
                        Scanner input = new Scanner(System.in);

                        System.out.print("Masukkan ID produk: ");
                        String id = input.nextLine();

                        System.out.print("Masukkan kategori produk: ");
                        String kategori = input.nextLine();

                        System.out.print("Masukkan nama produk: ");
                        String nama = input.nextLine();

                        System.out.print("Masukkan harga produk: ");
                        int harga = input.nextInt();
            
                        // Cek apakah ID produk sudah ada
                        boolean idAda = false;
                        i = 0;
                        while (i < jumlahProduk && !idAda) 
                        {
                            if (jangki[i].getId().equals(id)) 
                            {
                                idAda = true;
                            }
                            i++;
                        }
            
                        if (idAda) 
                        {
                            System.out.println("Produk dengan ID tersebut sudah ada. Tambah produk ditolak.");
                        } 
                        else 
                        {
                            // Menggunakan setter untuk mengisi data
                            jangki[jumlahProduk].setId(id);
                            jangki[jumlahProduk].setKategoriProduk(kategori);
                            jangki[jumlahProduk].setNamaProduk(nama);
                            jangki[jumlahProduk].setHargaProduk(harga);
                            jumlahProduk++;
                            System.out.println("Produk berhasil ditambahkan.");
                        }
                    }
                    break;
                }
                case 3: 
                {
                    // Mengubah produk
                    Scanner input = new Scanner(System.in);
                    System.out.print("Masukkan nama produk yang ingin diubah: ");
                    String nama = input.nextLine();
            
                    boolean ditemukan = false;
                    i = 0;
                    while (i < jumlahProduk && !ditemukan) 
                    {
                        if (jangki[i].getNamaProduk().equals(nama)) 
                        {
                            ditemukan = true;
                            System.out.println("Atribut apa yang ingin Anda ubah? (No. Menu)");
                            System.out.println("1. ID\n2. Kategori\n3. Nama\n4. Harga");
                            System.out.print("Masukkan pilihan: ");
                            int pilihan = input.nextInt();
                            input.nextLine(); // Konsumsi newline
            
                            switch (pilihan) 
                            {
                                case 1: 
                                {
                                    System.out.print("Masukkan ID baru: ");
                                    String newId = input.nextLine();
                                    jangki[i].setId(newId);
                                    System.out.println("ID berhasil diubah.");
                                    break;
                                }
                                case 2: 
                                {
                                    System.out.print("Masukkan kategori baru: ");
                                    String newKategori = input.nextLine();
                                    jangki[i].setKategoriProduk(newKategori);
                                    System.out.println("Kategori berhasil diubah.");
                                    break;
                                }
                                case 3: 
                                {
                                    System.out.print("Masukkan nama baru: ");
                                    String newNama = input.nextLine();
                                    jangki[i].setNamaProduk(newNama);
                                    System.out.println("Nama berhasil diubah.");
                                    break;
                                }
                                case 4: 
                                {
                                    System.out.print("Masukkan harga baru: ");
                                    int newHarga = input.nextInt();
                                    jangki[i].setHargaProduk(newHarga);
                                    System.out.println("Harga berhasil diubah.");
                                    break;
                                }
                                default:
                                    System.out.println("Pilihan tidak valid.");
                            }
                        }
                        i++;
                    }
            
                    if (!ditemukan) 
                    {
                        System.out.println("Produk dengan nama tersebut tidak ditemukan.");
                    }
                    break;
                }
                case 4: 
                {
                    // Menghapus produk
                    Scanner input = new Scanner(System.in);
                    System.out.print("Masukkan nama produk yang ingin dihapus: ");
                    String nama = input.nextLine();
            
                    boolean ditemukan = false;
                    i = 0;
                    while (i < jumlahProduk && !ditemukan) 
                    {
                        if (jangki[i].getNamaProduk().equals(nama)) 
                        {
                            // Geser semua elemen setelah produk yang ditemukan
                            j = i;
                            while (j < jumlahProduk - 1) 
                            {
                                jangki[j] = jangki[j + 1];
                                j++;
                            }
                            jumlahProduk--; // Kurangi jumlah produk
                            System.out.println("Produk berhasil dihapus.");
                            ditemukan = true;
                        }
                        i++;
                    }
            
                    if (!ditemukan) 
                    {
                        System.out.println("Produk dengan nama tersebut tidak ditemukan.");
                    }
                    break;
                }
                case 5: 
                {
                    // Mencari produk
                    Scanner input = new Scanner(System.in);
                    System.out.print("Masukkan nama produk yang ingin dicari: ");
                    String nama = input.nextLine();
            
                    boolean ditemukan = false;
                    i = 0;
                    while (i < jumlahProduk && !ditemukan) {

                        if (jangki[i].getNamaProduk().equals(nama)) 
                        {
                            System.out.println("Produk ditemukan:");
                            System.out.println("ID: " + jangki[i].getId());
                            System.out.println("Kategori: " + jangki[i].getKategoriProduk());
                            System.out.println("Nama: " + jangki[i].getNamaProduk());
                            System.out.println("Harga: Rp" + jangki[i].getHargaProduk());
                            ditemukan = true;
                        }
                        i++;
                    }
            
                    if (!ditemukan) 
                    {
                        System.out.println("Produk tidak ditemukan.");
                    }
                    break;
                }
                case 6:
                    // Selesai
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
            
        } while (menu != 6);
    }
}
