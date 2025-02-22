from PetShop import PetShop

def main():
    jumlah_produk = 0  # Variabel untuk melacak jumlah produk yang telah ditambahkan

    try:
        n = int(input("Masukkan jumlah maksimal produk: "))  # Input jumlah maksimal produk yang dapat ditampung dalam array
    except ValueError:
        print("Input tidak valid. Program dihentikan.")
        return  # Jika input bukan angka, program dihentikan

    # Membuat array of object PetShop sebanyak n
    jangki = [PetShop() for _ in range(n)]

    while True:
        # Menampilkan menu utama
        print("+-----------------------------+")
        print("| Menu:                       |")
        print("+-----------------------------+")
        print("| 1. Menampilkan semua produk |")
        print("| 2. Menambahkan produk       |")
        print("| 3. Mengubah produk          |")
        print("| 4. Menghapus produk         |")
        print("| 5. Mencari produk           |")
        print("| 6. Selesai                  |")
        print("+-----------------------------+")

        try:
            menu = int(input("Masukkan pilihan Anda: "))  # Meminta input pilihan menu
        except ValueError:
            print("Pilihan tidak valid.")
            continue  # Jika input bukan angka, kembali ke awal loop

        if menu == 1:
            # Menampilkan semua produk
            if jumlah_produk == 0:
                print("Belum ada produk yang terdaftar.")
            else:
                print("Daftar Produk:")
                i = 0
                while i < jumlah_produk:
                    print(f"ID: {jangki[i].get_id()}, Kategori: {jangki[i].get_kategori_produk()}, Nama: {jangki[i].get_nama_produk()}, Harga: Rp{jangki[i].get_harga_produk()}.")
                    i += 1

        elif menu == 2:
            # Menambahkan produk baru jika belum mencapai batas maksimal
            if jumlah_produk >= n:
                print("Array penuh. Tidak dapat menambahkan produk baru.")
            else:
                id_produk = input("Masukkan ID produk: ")
                kategori = input("Masukkan kategori produk: ")
                nama = input("Masukkan nama produk: ")

                try:
                    harga = int(input("Masukkan harga produk: "))  # Pastikan harga berupa angka
                except ValueError:
                    print("Harga harus berupa angka.")
                    continue

                # Cek apakah ID produk sudah ada
                id_ada = False
                i = 0
                while i < jumlah_produk:
                    if jangki[i].get_id() == id_produk:
                        id_ada = True
                        break
                    i += 1

                if id_ada:
                    print("Produk dengan ID tersebut sudah ada. Tambah produk ditolak.")
                else:
                    # Menambahkan produk baru ke array
                    jangki[jumlah_produk].set_id(id_produk)
                    jangki[jumlah_produk].set_kategori_produk(kategori)
                    jangki[jumlah_produk].set_nama_produk(nama)
                    jangki[jumlah_produk].set_harga_produk(harga)
                    jumlah_produk += 1
                    print("Produk berhasil ditambahkan.")

        elif menu == 3:
            # Mengubah data produk berdasarkan nama
            nama = input("Masukkan nama produk yang ingin diubah: ")
            ditemukan = False
            i = 0
            while i < jumlah_produk:
                if jangki[i].get_nama_produk() == nama:
                    ditemukan = True
                    print("Atribut apa yang ingin Anda ubah?")
                    print("1. ID")
                    print("2. Kategori")
                    print("3. Nama")
                    print("4. Harga")

                    try:
                        pilihan = int(input("Masukkan pilihan: "))
                    except ValueError:
                        print("Pilihan tidak valid.")
                        break

                    if pilihan == 1:
                        new_id = input("Masukkan ID baru: ")
                        jangki[i].set_id(new_id)
                        print("ID berhasil diubah.")
                    elif pilihan == 2:
                        new_kategori = input("Masukkan kategori baru: ")
                        jangki[i].set_kategori_produk(new_kategori)
                        print("Kategori berhasil diubah.")
                    elif pilihan == 3:
                        new_nama = input("Masukkan nama baru: ")
                        jangki[i].set_nama_produk(new_nama)
                        print("Nama berhasil diubah.")
                    elif pilihan == 4:
                        try:
                            new_harga = int(input("Masukkan harga baru: "))
                        except ValueError:
                            print("Harga harus berupa angka.")
                            break
                        jangki[i].set_harga_produk(new_harga)
                        print("Harga berhasil diubah.")
                    else:
                        print("Pilihan tidak valid.")
                    break
                i += 1

            if not ditemukan:
                print("Produk dengan nama tersebut tidak ditemukan.")

        elif menu == 4:
            # Menghapus produk berdasarkan nama
            nama = input("Masukkan nama produk yang ingin dihapus: ")
            ditemukan = False
            i = 0
            while i < jumlah_produk:
                if jangki[i].get_nama_produk() == nama:
                    # Menggeser elemen setelah produk yang dihapus
                    j = i
                    while j < jumlah_produk - 1:
                        jangki[j] = jangki[j + 1]
                        j += 1
                    jumlah_produk -= 1
                    print("Produk berhasil dihapus.")
                    ditemukan = True
                    break
                i += 1
            if not ditemukan:
                print("Produk dengan nama tersebut tidak ditemukan.")

        elif menu == 5:
            # Mencari produk berdasarkan nama
            nama = input("Masukkan nama produk yang ingin dicari: ")
            ditemukan = False
            i = 0
            while i < jumlah_produk:
                if jangki[i].get_nama_produk() == nama:
                    print("Produk ditemukan:")
                    print(f"ID: {jangki[i].get_id()}")
                    print(f"Kategori: {jangki[i].get_kategori_produk()}")
                    print(f"Nama: {jangki[i].get_nama_produk()}")
                    print(f"Harga: Rp{jangki[i].get_harga_produk()}")
                    ditemukan = True
                    break
                i += 1
            if not ditemukan:
                print("Produk tidak ditemukan.")

        elif menu == 6:
            # Mengakhiri program
            print("Terima kasih telah menggunakan program ini!")
            break
        else:
            print("Pilihan tidak valid. Silakan coba lagi.")

if __name__ == "__main__":
    main()
