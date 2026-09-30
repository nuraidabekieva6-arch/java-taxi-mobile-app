import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Модель заказа такси
class Order {
    private String id;
    private String pickupLocation;
    private String destination;
    private double price;
    private String status;

    public Order(String id, String pickupLocation, String destination, double price) {
        this.id = id;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.price = price;
        this.status = "Поиск водителя";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void printDetails() {
        System.out.println("-----------------------------------");
        System.out.println("Заказ #" + id);
        System.out.println("Откуда: " + pickupLocation);
        System.out.println("Куда: " + destination);
        System.out.println("Стоимость: " + price + " KGS");
        System.out.println("Статус: " + status);
        System.out.println("-----------------------------------");
    }
}

// Главный класс мобильного приложения
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Order> activeOrders = new ArrayList<>();

        System.out.println("===================================");
        System.out.println(" 🚗 TAXI SERVICE MOBILE APP (JAVA)");
        System.out.println("===================================");

        boolean running = true;
        int orderCounter = 1;

        while (running) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Заказать такси");
            System.out.println("2. Посмотреть активные заказы");
            System.out.println("3. Выйти из приложения");
            System.out.print("> ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите точку отправления: ");
                    String pickup = scanner.nextLine();

                    System.out.print("Введите точку назначения: ");
                    String destination = scanner.nextLine();

                    double estimatedPrice = 150 + (Math.random() * 200);
                    Order newOrder = new Order("ORD-00" + orderCounter++, pickup, destination, Math.round(estimatedPrice));
                    
                    activeOrders.add(newOrder);
                    System.out.println("\n✅ Заказ успешно создан!");
                    newOrder.printDetails();
                    break;

                case 2:
                    if (activeOrders.isEmpty()) {
                        System.out.println("\nУ вас нет активных заказов.");
                    } else {
                        System.out.println("\n--- Список заказов ---");
                        for (Order order : activeOrders) {
                            order.printDetails();
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nСпасибо за использование нашего сервиса!");
                    running = false;
                    break;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
        scanner.close();
    }
}
