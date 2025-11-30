class ParkingTree {
    ParkingNode root;

    public ParkingTree() {
        root = null;
    }

    // Tambah node baru
    ParkingNode insert(ParkingNode node, String name) {
        if (node == null) {
            return new ParkingNode(name);
        }
        if (name.compareTo(node.name) < 0)
            node.left = insert(node.left, name);
        else if (name.compareTo(node.name) > 0)
            node.right = insert(node.right, name);
        return node;
    }

    // Cari slot kosong
    ParkingNode findEmptySlot(ParkingNode node) {
        if (node == null) return null;
        if (!node.occupied) return node;
        ParkingNode left = findEmptySlot(node.left);
        if (left != null) return left;
        return findEmptySlot(node.right);
    }

    // Tandai slot terisi
    void occupySlot(ParkingNode node) {
        if (node != null) node.occupied = true;
    }

    // Tampilkan status parkir (inorder traversal)
    void displayStatus(ParkingNode node) {
        if (node != null) {
            displayStatus(node.left);
            System.out.println(node.name + " -> " + (node.occupied ? "Terisi" : "Kosong"));
            displayStatus(node.right);
        }
    }

    public static void main(String[] args) {
        ParkingTree parkir = new ParkingTree();

        // Membuat struktur pohon parkir
        String[] slots = {"L1-A1", "L1-A2", "L1-B1", "L1-B2", "L2-A1", "L2-A2"};
        for (String slot : slots) {
            parkir.root = parkir.insert(parkir.root, slot);
        }

        System.out.println("=== Status Awal Parkir ===");
        parkir.displayStatus(parkir.root);

        // Kendaraan masuk
        ParkingNode kosong = parkir.findEmptySlot(parkir.root);
        if (kosong != null) {
            parkir.occupySlot(kosong);
            System.out.println("\nKendaraan masuk ke slot: " + kosong.name);
        }

        System.out.println("\n=== Status Setelah Kendaraan Masuk ===");
        parkir.displayStatus(parkir.root);
    }
}