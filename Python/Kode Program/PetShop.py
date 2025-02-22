class PetShop:
    def __init__(self, id=None, nama_produk=None, kategori_produk=None, harga_produk=None):
        self.id = id
        self.nama_produk = nama_produk
        self.kategori_produk = kategori_produk
        self.harga_produk = harga_produk

    # Getter dan Setter ID
    def set_id(self, id):
        self.id = id

    def get_id(self):
        return self.id

    # Getter dan Setter Nama Produk
    def set_nama_produk(self, nama):
        self.nama_produk = nama

    def get_nama_produk(self):
        return self.nama_produk

    # Getter dan Setter Kategori Produk
    def set_kategori_produk(self, kategori):
        self.kategori_produk = kategori

    def get_kategori_produk(self):
        return self.kategori_produk

    # Getter dan Setter Harga Produk
    def set_harga_produk(self, harga):
        self.harga_produk = harga

    def get_harga_produk(self):
        return self.harga_produk