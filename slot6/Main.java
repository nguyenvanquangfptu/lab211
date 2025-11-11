package com.mycompany.lab211.slot6;

import com.mycompany.lab211.Menu;
import com.mycompany.lab211.Utils;
import java.util.*;

public class Main extends Menu {

    private FruitShop fruitShop = new FruitShop();

    private static final String TITLE = "\n ======= Fruit Shop System ============";
    private static final String[] ITEMS = {"Create Fruit", "View Fruits", "View Orders", "Shopping (for buyers)", "Exit"};

    public Main(String title, String[] mc) {
        super(title, mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> {
                while (true) {
                    Fruit newFruit = createFruit(); // Thay đổi để thêm từng quả một

                    if (newFruit != null) {
                        fruitShop.addListFruits(Arrays.asList(newFruit)); // Thêm vào FruitShop
                        System.out.println("Fruit added successfully!");
                    }

                    if (!Utils.readYesNo("Do you want to continue adding fruit?")) {
                        break;
                    }
                }
            }
            case 2 -> {
                displayFruits(fruitShop.getFruitList()); // Lấy danh sách từ FruitShop để hiển thị
            }
            case 3 -> {
                displayOrders(fruitShop.getOrderList()); // Lấy danh sách Order từ FruitShop để hiển thị
            }
            case 4 -> {
                performShopping(); // Thực hiện chức năng mua hàng
            }
            default -> {
                System.out.println("Exitting..");
            }
        }
    }

    // HÀM I/O: Tạo Fruit
    public Fruit createFruit() {
        String id;
        while (true) {
            id = Utils.readString("Enter ID fruit: ");
            if (!fruitShop.isDuplicatedID(id)) { // Kiểm tra trùng lặp qua FruitShop
                break;
            }
            System.out.println("ID is duplicated. Please enter a different ID.");
        }
        String name = Utils.readString("Enter fruit's name: ");
        double price = Utils.readDouble("Enter price: ");
        int stockQuantity = Utils.readInt("Enter stock quantity: ");
        String origin = Utils.readString("Enter fruit's origin: ");

        return new Fruit(id, name, price, stockQuantity, origin);
    }

    // HÀM I/O: Hiển thị danh sách Fruit
    public void displayFruits(List<Fruit> fruitlist) {
        if (fruitlist.isEmpty()) {
            System.out.println("List fruits are empty");
        } else {
            System.out.println(" ++ Item ++ | ++ Fruit name ++ | ++ Origin ++ | ++ Price ++ | ++ Stock ++");
            int i = 1;
            for (Fruit fruit : fruitlist) {
                // Giả định Fruit.toString() trả về chuỗi định dạng
                System.out.println(i++ + fruit.toString());
            }
        }
    }

    // HÀM I/O & LOGIC: Thực hiện mua sắm
    public void performShopping() {
        List<Fruit> availableFruits = fruitShop.getFruitList();
        if (availableFruits.isEmpty()) {
            System.out.println("No fruits available in the shop.");
            return;
        }

        displayFruits(availableFruits); // Hiển thị danh sách quả

        HashMap<Fruit, Integer> mapOrderDetail = new HashMap<>();

        while (true) {
            // Đọc lựa chọn item
            int choice = Utils.readIntInRange("Choose item:", 1, availableFruits.size()) - 1;
            Fruit targetFruit = availableFruits.get(choice);
            System.out.println("You selected: " + targetFruit.getName() + " (Remaining stock: " + targetFruit.getStockQuantity() + ")");

            // Kiểm tra stock trước khi mua
            if (targetFruit.getStockQuantity() <= 0) {
                System.out.println("This fruit is out of stock. Please choose another one.");
                continue;
            }

            // Đọc số lượng muốn mua
            int quantityToBuy = Utils.readIntInRange("Please enter quantity: ", 1, targetFruit.getStockQuantity());

            // Cập nhật tồn kho (Logic nghiệp vụ qua FruitShop)
            fruitShop.updateStock(targetFruit, quantityToBuy);

            // Cập nhật chi tiết đơn hàng tạm thời
            mapOrderDetail.put(targetFruit, mapOrderDetail.getOrDefault(targetFruit, 0) + quantityToBuy);

            // Hỏi xem có muốn đặt hàng ngay không
            if (Utils.readYesNo("Do you want to order now? ")) {
                if (mapOrderDetail.isEmpty()) {
                    System.out.println("No items added to the cart. Shopping cancelled.");
                    break;
                }

                String customerName = Utils.readName("Enter full name: ");

                // Tạo và lưu Order (Logic nghiệp vụ qua FruitShop)
                Order newOrder = fruitShop.createAndSaveOrder(customerName, mapOrderDetail);

                // Hiển thị thông tin Order (I/O)
                System.out.println("\nOrder Placed Successfully!");
                System.out.println(newOrder.toString());
                break;
            }

            // Hỏi xem có muốn tiếp tục mua không
            if (!Utils.readYesNo("Do you want to continue shopping? (Y/N): ")) {
                // Hoàn trả lại số lượng đã chọn nếu người dùng hủy
                System.out.println("Shopping cancelled. Restoring stock...");
                for (Map.Entry<Fruit, Integer> entry : mapOrderDetail.entrySet()) {
                    Fruit fruit = entry.getKey();
                    int quantity = entry.getValue();
                    fruit.setStockQuantity(fruit.getStockQuantity() + quantity);
                }
                break;
            }
            displayFruits(availableFruits); // Hiển thị lại danh sách sau khi mua
        }
    }

    // HÀM I/O: Hiển thị Orders
    public void displayOrders(List<Order> orderlist) {
        if (orderlist.isEmpty()) {
            System.out.println("List orders are empty");
        } else {
            System.out.println("\n--- All Orders ---");
            int i = 0;
            for (Order order : orderlist) {
                // Giả định Order.toString() trả về chuỗi định dạng
                System.out.println(++i + order.toString());
            }
        }
    }

    public static void main(String[] args) {
        Main test = new Main(TITLE, ITEMS);
        // Khởi tạo dữ liệu mẫu nếu cần
        test.fruitShop.addListFruits(Arrays.asList(
                new Fruit("F01", "Coconut", 2.0, 10, "Viet Nam"),
                new Fruit("F02", "Orange", 1.5, 20, "USA"),
                new Fruit("F03", "Apple", 2.5, 15, "France")
        ));
        test.run(); // Chạy menu
    }
}
