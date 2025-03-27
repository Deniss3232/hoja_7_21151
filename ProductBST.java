public class ProductBST {
    private BinarySearchTree<Product> bst = new BinarySearchTree<>();

    public void loadProduct(Product product) {
        bst.insert(product);
    }

    public Product searchBySku(String sku) {
        return bst.search(new Product(sku, 0, 0, "", ""));
    }

    public void printAscending() {
        System.out.println("=== Productos Ascendente (por SKU) ===");
        bst.inOrderAsc();
    }

    public void printDescending() {
        System.out.println("=== Productos Descendente (por SKU) ===");
        bst.inOrderDesc();
    }
}
