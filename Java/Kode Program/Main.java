import java.util.Scanner;

class Main{
    
    public static void main(String args[]) 
    {
        int n = 0; // Menyimpan jumlah maksimal produk
        int jumlahProduk = 0; // Menyimpan jumlah produk yang telah ditambahkan
        int menu = 0; // Variabel untuk menyimpan pilihan menu dari pengguna
        int i = 0;
        int j = 0;

        System.out.println("Masukkan jumlah maksimal produk: ");
        Scanner sc = new Scanner(System.in);
        try 
        {
            n = sc.nextInt(); // Membaca jumlah maksimal produk dari pengguna
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
            // Menampilkan menu utama
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
            menu = sc.nextInt(); // Membaca pilihan pengguna
            
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
                            // Menampilkan informasi setiap produk
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
                    // Menambahkan produk baru
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
                            // Menambahkan produk ke dalam array
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
                    // Mengubah informasi produk
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
                                    System.out.print("Masukkan ID baru: ");
                                    jangki[i].setId(input.nextLine());
                                    System.out.println("ID berhasil diubah.");
                                    break;
                                case 2: 
                                    System.out.print("Masukkan kategori baru: ");
                                    jangki[i].setKategoriProduk(input.nextLine());
                                    System.out.println("Kategori berhasil diubah.");
                                    break;
                                case 3: 
                                    System.out.print("Masukkan nama baru: ");
                                    jangki[i].setNamaProduk(input.nextLine());
                                    System.out.println("Nama berhasil diubah.");
                                    break;
                                case 4: 
                                    System.out.print("Masukkan harga baru: ");
                                    jangki[i].setHargaProduk(input.nextInt());
                                    System.out.println("Harga berhasil diubah.");
                                    break;
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
                case 6:
                    // Mengakhiri program
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
            
        } while (menu != 6);
    }
}
