import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> products = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Добавить.\n2. Показать.\n3. Удалить.\n4. Поиск покупок.");
            System.out.print("\nВыберите операцию : ");

            String input = scanner.nextLine();
            if (input.equals("1")) {
                addProduct(scanner, products);
            }
            if (input.equals("2")) {
                listProduct(products);
            }
            if (input.equals("3")) {
                removeProducts(scanner, products);
            }
            if (input.equals("4")) {
                searchProduct(scanner, products);
            }
        }
    }

    private static void removeProducts(Scanner scanner, ArrayList<String> products) {
        System.out.println("Список покупок: \n");
        for (int i = 0; i < products.size(); i++) {
            String product = products.get(i);
            System.out.println((i + 1) + ". " + product);
        }
        System.out.print("Какую хотите удалить? Введите номер или название: ");
        String deleteProduct = scanner.nextLine();
        try {
            int productNumber = Integer.parseInt(deleteProduct);
            products.remove(productNumber - 1);
        } catch (NumberFormatException exceptiont) {
            products.remove(deleteProduct);
        }
        System.out.println("Список покупок:\n");
        for (int i = 0; i < products.size(); i++) {
            String product = products.get(i);
            System.out.println((i + 1) + ". " + product);
        }
    }

    private static void searchProduct (Scanner scanner, ArrayList<String> products) {
        System.out.print("\nВведите текст для поиска:");
        String search = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            String product = products.get(i);
            String queryLower = search.toLowerCase();
            String itemLower = product.toLowerCase();
            if (itemLower.contains(queryLower)) {
                System.out.println((products.indexOf(product) + 1) + ". " + product);
            }
        }
    }

    private static void listProduct(ArrayList<String> products) {
        System.out.println("Список покупок: \n");
        for (int i = 0; i < products.size(); i++) {
            String product = products.get(i);
            System.out.println((i + 1) + ". " + product);
        }
    }

    private static void addProduct(Scanner scanner, ArrayList<String> products) {
        System.out.println("\nКакую покупку хотите добавить?");
        products.add(scanner.nextLine());
        System.out.println("Итого в списке покупок: " + products.size());
    }
}