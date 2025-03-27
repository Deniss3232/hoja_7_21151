import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductBST productTree = new ProductBST();
        Scanner scanner = new Scanner(System.in);

        //  Cambia esta línea si el archivo CSV tiene otro nombre o está en otra carpeta
        String csvPath = "appliances.csv";  // asegúrate de colocar este archivo en la misma carpeta que tu código

        CSVReader.loadFromCSV(csvPath, productTree);

        boolean running = true;
        while (running) {
            System.out.println("\n=== Menú ===");
            System.out.println("1. Buscar producto por SKU");
            System.out.println("2. Listar productos (SKU Ascendente)");
            System.out.println("3. Listar productos (SKU Descendente)");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            String input = scanner.nextLine();
            int option;

            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(" Entrada inválida. Debes ingresar un número (1-4).");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Ingrese SKU: ");
                    String sku = scanner.nextLine().trim();
                    Product found = productTree.searchBySku(sku);
                    if (found != null) {
                        System.out.println("\n Producto encontrado:");
                        System.out.println(found);
                    } else {
                        System.out.println(" Producto no encontrado.");
                    }
                    break;
                case 2:
                    System.out.println("\n Listando productos ordenados (ascendente por SKU):");
                    productTree.printAscending();
                    break;
                case 3:
                    System.out.println("\n Listando productos ordenados (descendente por SKU):");
                    productTree.printDescending();
                    break;
                case 4:
                    System.out.println(" Saliendo del programa.");
                    running = false;
                    break;
                default:
                    System.out.println(" Opción inválida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}
