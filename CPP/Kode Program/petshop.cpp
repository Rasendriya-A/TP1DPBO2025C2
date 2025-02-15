#include <iostream>
#include <string>

using namespace std;

class petshop
{
    private:
       string Id;
       string NamaProduk;
       string KategoriProduk;
       int HargaProduk; 

    public:
        petshop()
        {

        }

        //Setter dan Getter ID
        void setId(string id1)
        {
            Id = id1;
        }

        string getId()
        {
            return Id;
        }

        //Setter dan Getter Nama Produk
        void setNamaProduk(string nama1)
        {
            NamaProduk = nama1;
        }

        string getNamaProduk()
        {
            return NamaProduk;
        }

        //Setter dan Getter Kategori Produk
        void setKategoriProduk(string kategori1)
        {
            KategoriProduk = kategori1;
        }

        string getKategoriProduk()
        {
            return KategoriProduk;
        }

        //Setter dan Getter Harga Produk
        void setHargaProduk(int harga1)
        {
            HargaProduk = harga1;
        }

        int getHargaProduk()
        {
            return HargaProduk;
        }

        ~petshop()
        {
            
        }
};
