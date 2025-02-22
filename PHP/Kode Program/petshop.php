<?php
class PetShop 
{
    private $id;
    private $nama_produk;
    private $kategori_produk;
    private $harga_produk;
    private $gambar_produk;

    public function __construct($id = null, $nama_produk = null, $kategori_produk = null, $harga_produk = null, $gambar_produk) 
    {
        $this->id = $id;
        $this->nama_produk = $nama_produk;
        $this->kategori_produk = $kategori_produk;
        $this->harga_produk = $harga_produk;
        $this->gambar_produk = $gambar_produk;
    }

    // Getter dan Setter ID
    public function setId($id) 
    {
        $this->id = $id;
    }
    public function getId() 
    {
        return $this->id;
    }

    // Getter dan Setter Nama Produk
    public function setNamaProduk($nama) 
    {
        $this->nama_produk = $nama;
    }
    public function getNamaProduk() 
    {
        return $this->nama_produk;
    }

    // Getter dan Setter Kategori Produk
    public function setKategoriProduk($kategori) 
    {
        $this->kategori_produk = $kategori;
    }
    public function getKategoriProduk() 
    {
        return $this->kategori_produk;
    }

    // Getter dan Setter Harga Produk
    public function setHargaProduk($harga) 
    {
        $this->harga_produk = $harga;
    }
    public function getHargaProduk() 
    {
        return $this->harga_produk;
    }

    // Getter dan Setter Gambar
    public function setGambarProduk($gambar) 
    {
        $this->gambar_produk = $gambar;
    }
    public function getGambarProduk() 
    {
        return $this->gambar_produk;
    }

    // Fungsi menambahkan produk
    public static function addProduk($id, $nama_produk, $kategori_produk, $harga_produk, $gambar_produk) 
    {
        if (isset($_SESSION['produk_list'])) {
            foreach ($_SESSION['produk_list'] as $produk) {
                if ($produk->getId() == $id) {
                    return "ID sudah ada!";
                }
            }
        }
        $_SESSION['produk_list'][] = new PetShop($id, $nama_produk, $kategori_produk, $harga_produk, $gambar_produk);
        return "Produk berhasil ditambahkan!";
    }

    // Fungsi mengedit produk berdasarkan ID
    public static function editProduk($id, $nama_produk, $kategori_produk, $harga_produk, $gambar_produk) 
    {
        foreach ($_SESSION['produk_list'] as &$produk) {
            if ($produk->getId() == $id) {
                $produk->setNamaProduk($nama_produk);
                $produk->setKategoriProduk($kategori_produk);
                $produk->setHargaProduk($harga_produk);
                if ($gambar_produk) {
                    $produk->setGambarProduk($gambar_produk);
                }
                return "Produk berhasil diperbarui!";
            }
        }
        return "Produk tidak ditemukan!";
    }

    // Fungsi menghapus produk berdasarkan ID
    public static function deleteProduk($id) 
    {
        foreach ($_SESSION['produk_list'] as $key => $produk) {
            if ($produk->getId() == $id) {
                unset($_SESSION['produk_list'][$key]);
                $_SESSION['produk_list'] = array_values($_SESSION['produk_list']);
                return "Produk berhasil dihapus!";
            }
        }
        return "Produk tidak ditemukan!";
    }
}
?>