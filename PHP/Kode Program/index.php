<?php
require_once 'PetShop.php';

session_start();
$page = isset($_GET['page']) ? $_GET['page'] : 'list';

// Inisialisasi daftar produk jika belum ada dalam sesi
if (!isset($_SESSION['produk_list'])) {
    $_SESSION['produk_list'] = [
        new PetShop(1, "Makanan Kucing", "Makanan", 50000, "Photo/makanan_kucing.jpg"),
        new PetShop(2, "Shampoo Anjing", "Perawatan", 75000, "Photo/shampoo_anjing.jpg"),
        new PetShop(3, "Mainan Kucing", "Mainan", 30000, "Photo/mainan_kucing.jpg"),
        new PetShop(4, "Vitamin Burung", "Vitamin", 45000, "Photo/vitamin_burung.jpg")
    ];
}

// Handle penambahan produk
if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['id'])) {
    $id = $_POST['id'];
    $nama_produk = $_POST['nama_produk'];
    $kategori_produk = $_POST['kategori_produk'];
    $harga_produk = $_POST['harga_produk'];
    
    // Cek apakah ID sudah ada
    foreach ($_SESSION['produk_list'] as $produk) {
        if ($produk->getId() == $id) {
            $error_message = "ID produk sudah ada! Gunakan ID yang berbeda.";
            break;
        }
    }

    if (empty($error_message)) {
        // Menyimpan gambar yang diupload
        $target_dir = "Photo/";
        $target_file = $target_dir . basename($_FILES["gambar_produk"]["name"]);
        move_uploaded_file($_FILES["gambar_produk"]["tmp_name"], $target_file);
        
        $_SESSION['produk_list'][] = new PetShop($id, $nama_produk, $kategori_produk, $harga_produk, $target_file);
        header("Location: index.php?page=list");
        exit();
    }
}

// Handle penghapusan produk
if (isset($_GET['delete'])) {
    foreach ($_SESSION['produk_list'] as $key => $produk) {
        if ($produk->getId() == $_GET['delete']) {
            unset($_SESSION['produk_list'][$key]);
            $_SESSION['produk_list'] = array_values($_SESSION['produk_list']);
            break;
        }
    }
    header("Location: index.php?page=list");
    exit();
}

// Handle pengeditan produk
$edit_item = null;
if ($page == 'edit' && isset($_GET['id'])) {
    foreach ($_SESSION['produk_list'] as $produk) {
        if ($produk->getId() == $_GET['id']) {
            $edit_item = $produk;
            break;
        }
    }
}

if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['edit_id'])) {
    foreach ($_SESSION['produk_list'] as &$produk) { // Gunakan referensi &
        if ($produk->getId() == $_POST['edit_id']) {
            $produk->setNamaProduk($_POST['nama_produk']);
            $produk->setKategoriProduk($_POST['kategori_produk']);
            $produk->setHargaProduk($_POST['harga_produk']);

            // Jika ada file gambar yang diupload
            if (!empty($_FILES['gambar_produk']['name'])) {
                $target_file = "Photo/" . basename($_FILES["gambar_produk"]["name"]);
                if (move_uploaded_file($_FILES["gambar_produk"]["tmp_name"], $target_file)) {
                    $produk->setGambarProduk($target_file);
                }
            }
            break;
        }
    }
    unset($produk); // Hapus referensi setelah penggunaan

    header("Location: index.php?page=list");
    exit();
}

// Menentukan tampilan berdasarkan parameter 'page'
$page = isset($_GET['page']) ? $_GET['page'] : 'list';
?>

<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Daftar Produk PetShop</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        img {
            width: 100px;
            height: auto;
        }
        .menu {
            margin-bottom: 20px;
        }
        .menu a {
            margin-right: 10px;
            text-decoration: none;
            padding: 5px 10px;
            background-color: #007BFF;
            color: white;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <h2>Daftar Produk PetShop</h2>
    <div class="menu">
        <a href="index.php?page=list">Tampilkan Seluruh Item</a>
        <a href="index.php?page=add">Tambah Data</a>
    </div>

    <?php if ($page == 'list') : ?>
        <!-- Form Pencarian hanya muncul di halaman list -->
        <form method="GET" class="search-bar">
            <input type="hidden" name="page" value="list">
            <input type="text" name="search" placeholder="Cari nama produk..." 
                value="<?php echo isset($_GET['search']) ? $_GET['search'] : ''; ?>">
            <button type="submit">Cari</button>
        </form>

        <table>
            <tr>
                <th>ID</th>
                <th>Nama Produk</th>
                <th>Kategori</th>
                <th>Harga</th>
                <th>Gambar</th>
                <th>Aksi</th>
            </tr>
            <?php 
            $search_query = isset($_GET['search']) ? strtolower(trim($_GET['search'])) : '';
            $filtered_products = [];

            // Filter produk berdasarkan pencarian
            foreach ($_SESSION['produk_list'] as $item) {
                if ($search_query === '' || strpos(strtolower($item->getNamaProduk()), $search_query) !== false) {
                    $filtered_products[] = $item;
                }
            }

            if (count($filtered_products) > 0) :
                foreach ($filtered_products as $item) : ?>
                    <tr>
                        <td><?php echo $item->getId(); ?></td>
                        <td><?php echo $item->getNamaProduk(); ?></td>
                        <td><?php echo $item->getKategoriProduk(); ?></td>
                        <td><?php echo "Rp " . number_format($item->getHargaProduk(), 0, ',', '.'); ?></td>
                        <td><img src="<?php echo $item->getGambarProduk(); ?>" alt="<?php echo $item->getNamaProduk(); ?>"></td>
                        <td>
                            <a href="index.php?page=edit&id=<?php echo $item->getId(); ?>">Edit</a>
                            <a href="index.php?delete=<?php echo $item->getId(); ?>">Hapus</a>
                        </td>
                    </tr>
                <?php endforeach;
            else : ?>
                <tr>
                    <td colspan="6">Tidak ada produk yang cocok dengan pencarian.</td>
                </tr>
            <?php endif; ?>
        </table>

    <?php elseif ($page == 'add') : ?>
        <h3>Tambah Produk</h3>
        <?php if (!empty($error_message)): ?>
            <p style="color: red;"> <?php echo $error_message; ?> </p>
        <?php endif; ?>
        <form action="index.php?page=add" method="post" enctype="multipart/form-data">
            <label for="id">ID Produk:</label><br>
            <input type="text" id="id" name="id" required><br><br>
            
            <label for="nama_produk">Nama Produk:</label><br>
            <input type="text" id="nama_produk" name="nama_produk" required><br><br>
            
            <label for="kategori_produk">Kategori:</label><br>
            <input type="text" id="kategori_produk" name="kategori_produk" required><br><br>
            
            <label for="harga_produk">Harga:</label><br>
            <input type="number" id="harga_produk" name="harga_produk" required><br><br>
            
            <label for="gambar_produk">Upload Gambar:</label><br>
            <input type="file" id="gambar_produk" name="gambar_produk" required><br><br>
            
            <button type="submit">Tambah Produk</button>
        </form>

    <?php elseif ($page == 'edit' && $edit_item) : ?>
        <h3>Edit Produk</h3>
        <form action="index.php?page=list" method="post" enctype="multipart/form-data">
            <input type="hidden" name="edit_id" value="<?php echo $edit_item->getId(); ?>">
            <label for="nama_produk">Nama Produk:</label><br>
            <input type="text" id="nama_produk" name="nama_produk" value="<?php echo $edit_item->getNamaProduk(); ?>" required><br><br>
            <label for="kategori_produk">Kategori:</label><br>
            <input type="text" id="kategori_produk" name="kategori_produk" value="<?php echo $edit_item->getKategoriProduk(); ?>" required><br><br>
            <label for="harga_produk">Harga:</label><br>
            <input type="number" id="harga_produk" name="harga_produk" value="<?php echo $edit_item->getHargaProduk(); ?>" required><br><br>
            <label for="gambar_produk">Upload Gambar (Kosongkan jika tidak ingin mengubah):</label><br>
            <input type="file" id="gambar_produk" name="gambar_produk"><br><br>
            <button type="submit">Simpan Perubahan</button>
        </form>
    <?php endif; ?>
</body>

</html>
