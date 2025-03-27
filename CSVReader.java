import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CSVReader {

    public static void loadFromCSV(String filePath, ProductBST productTree) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Leer encabezado
            String headerLine = br.readLine();
            if (headerLine == null) {
                System.out.println("Archivo vacío.");
                return;
            }

            String[] headers = headerLine.split(",");
            HashMap<String, Integer> columnIndex = new HashMap<>();
            for (int i = 0; i < headers.length; i++) {
                columnIndex.put(headers[i].trim(), i);
            }

            // Verifica que las columnas necesarias existan
            if (!columnIndex.containsKey("SKU") || !columnIndex.containsKey("Price_Retail")
                    || !columnIndex.containsKey("Price_Current") || !columnIndex.containsKey("Product_Name")
                    || !columnIndex.containsKey("Category")) {
                System.out.println("El archivo CSV no tiene las columnas necesarias.");
                return;
            }

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // manejar comas entre comillas

                try {
                    String sku = parts[columnIndex.get("SKU")].trim();
                    double priceRetail = Double.parseDouble(parts[columnIndex.get("Price_Retail")]);
                    double priceCurrent = Double.parseDouble(parts[columnIndex.get("Price_Current")]);
                    String productName = parts[columnIndex.get("Product_Name")];
                    String category = parts[columnIndex.get("Category")];

                    Product p = new Product(sku, priceRetail, priceCurrent, productName, category);
                    productTree.loadProduct(p);
                } catch (Exception e) {
                    // Ignorar líneas inválidas
                    System.out.println("Línea inválida: " + e.getMessage());
                }
            }

            System.out.println("Datos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
