class ParkingNode {
    String name;
    boolean occupied;
    ParkingNode left, right;

    public ParkingNode(String name) {
        this.name = name;
        this.occupied = false;
        this.left = this.right = null;
    }
}