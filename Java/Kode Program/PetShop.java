class PetShop 
{
    private String Id;
    private String NamaProduk;
    private String KategoriProduk;
    private int HargaProduk;

    // Constructor
    public PetShop(String id, String namaProduk, String kategoriProduk, int hargaProduk) 
    {
        this.Id = id;
        this.NamaProduk = namaProduk;
        this.KategoriProduk = kategoriProduk;
        this.HargaProduk = hargaProduk;
    }

    public PetShop(){

    }

    //Setter dan Getter ID
    void setId(String id)
    {
        this.Id = id;
    }

    String getId()
    {
        return Id;
    }

    //Setter dan Getter Nama Produk
    void setNamaProduk(String nama)
    {
        this.NamaProduk = nama;
    }

    String getNamaProduk()
    {
        return NamaProduk;
    }

    //Setter dan Getter Kategori Produk
    void setKategoriProduk(String kategori)
    {
        this.KategoriProduk = kategori;
    }

    String getKategoriProduk()
    {
        return KategoriProduk;
    }

    //Setter dan Getter Harga Produk
    void setHargaProduk(int harga1)
    {
        this.HargaProduk = harga1;
    }

    int getHargaProduk()
    {
        return HargaProduk;
    }

}