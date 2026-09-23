package gestionproductos;

public class Main {

    public static void main(String[] args) {

        // Crear lista de productos
        List<Producto> inventario = new List<>();

        // Agregar productos
        inventario.append(
                new Producto("Tomate", "Verduras", "kg", 5)
        );

        inventario.append(
                new Producto("Leche", "Lacteos", "L", 10)
        );

        inventario.append(
                new Producto("Atún", "Enlatados", "latas", 8)
        );

        inventario.append(
                new Producto("Pan", "Procesados", "unidades", 12)
        );

        inventario.append(
                new Producto("Pollo", "Congelados", "kg", 6)
        );

        inventario.append(
                new Producto("Arroz", "Granos", "kg", 20)
        );

        inventario.append(
                new Producto("Cebolla", "Verduras", "kg", 4)
        );

        inventario.append(
                new Producto("Queso", "Lacteos", "kg", 3)
        );

        // Mostrar inventario original
        System.out.println("===== INVENTARIO =====");
        inventario.recorrer();

        // Categorías
        String[] categorias = {
            "Verduras",
            "Lacteos",
            "Enlatados",
            "Procesados",
            "Congelados",
            "Granos"
        };

        // Agrupar productos por categoría
        System.out.println("\n===== PRODUCTOS AGRUPADOS =====");

        for (String categoria : categorias) {

            System.out.println("\nCategoría: " + categoria);

            Node<Producto> actual = inventario.head;

            boolean encontrado = false;

            while (actual != null) {

                Producto producto = actual.data;

                if (producto.getTipo().equalsIgnoreCase(categoria)) {

                    System.out.println(
                            "   - " +
                            producto.getNombre() +
                            " | " +
                            producto.getCantidad() +
                            " " +
                            producto.getUnidad()
                    );

                    encontrado = true;
                }

                actual = actual.next;
            }

            if (!encontrado) {
                System.out.println("   No hay productos.");
            }
        }
    }
}