package bll;

import dao.FileWriter;
import dao.Serializator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toMap;

/**
 * @invariant wellFormed()
 */

public class DeliveryService extends Observable implements IDeliveryServiceProcessing {

    private final DeliveryService deliveryService = this;

    private Set<MenuItem> menuItems;
    private Map<Order, Collection<MenuItem>> placedOrders;
    private Set<User> users;

    public DeliveryService() {
        try {

            deserializeAll();

        } catch (ClassNotFoundException | IOException e) {
            menuItems = new HashSet<>();
            placedOrders = new HashMap<>();
            users = new HashSet<>();
            importProductsFromCSV("products.csv");
            System.out.println("Imported products");

            User administrator1 = new User(deliveryService, "Administrator1", "admin1", "admin1", UserType.ADMINISTRATOR);
            signUpClient(administrator1);
            User administrator2 = new User(deliveryService, "Administrator2", "admin2", "admin2", UserType.ADMINISTRATOR);
            signUpClient(administrator2);
            User employee1 = new User(deliveryService, "Employee1", "employee1", "employee1", UserType.EMPLOYEE);
            signUpClient(employee1);
            User employee2 = new User(deliveryService, "Employee2", "employee2", "employee2", UserType.EMPLOYEE);
            signUpClient(employee2);

            serializeAll();
        }

    }


    public void serializeAll() {
        Serializator<Set<MenuItem>> menuItemsSerializator = new Serializator<>();
        Serializator<Map<Order, Collection<MenuItem>>> placeOrdersSerializator = new Serializator<>();
        Serializator<Set<User>> usersSerializator = new Serializator<>();
        try {
            menuItemsSerializator.serializeObject("menu.txt", menuItems);
            placeOrdersSerializator.serializeObject("orders.txt", placedOrders);
            usersSerializator.serializeObject("users.txt", users);
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deserializeAll() throws ClassNotFoundException, IOException {
        Serializator<Set<MenuItem>> menuItemSerializator = new Serializator<>();
        Serializator<Map<Order, Collection<MenuItem>>> orderSerializator = new Serializator<>();
        Serializator<Set<User>> userSerializator = new Serializator<>();
        menuItems = menuItemSerializator.deserializeObject("menu.txt");
        placedOrders = orderSerializator.deserializeObject("orders.txt");
        users = userSerializator.deserializeObject("users.txt");
    }

    public boolean wellFormed() {
        int size = 0;
        for (MenuItem item : menuItems) {
            size++;
            if (Objects.equals(item.getTitle(), ""))
                return false;
            if (item.getRating() < 0)
                return false;
            if (item.getCalories() < 0)
                return false;
            if (item.getProtein() < 0)
                return false;
            if (item.getFat() < 0)
                return false;
            if (item.getSodium() < 0)
                return false;
            if (item.getPrice() < 0)
                return false;
        }

        return menuItems.size() > 0 && users.size() >= 4 && size == menuItems.size();

    }


    @Override
    public void importProductsFromCSV(String name) {
        try {
            menuItems = Files.lines(Paths.get(name))
                    .skip(1)
                    .map(x -> x.split(","))
                    .map(x -> new BaseProduct(x[0], Float.parseFloat(x[1]), Integer.parseInt(x[2]), Integer.parseInt(x[3]), Integer.parseInt(x[4]), Integer.parseInt(x[5]), Float.parseFloat(x[6])))
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert menuItems.size() > 0;
        assert wellFormed();
    }

    @Override
    public void addProduct(MenuItem item) {
        assert !Objects.equals(item.getTitle(), "") && item.getRating() >= 0 && item.getCalories() >= 0 && item.getProtein() >= 0 && item.getFat() >= 0 && item.getSodium() >= 0 && item.getPrice() >= 0;
        int sizePre = menuItems.size();
        menuItems.add(item);
        int sizePost = menuItems.size();
        assert sizePost == sizePre + 1;
        assert wellFormed();
    }

    @Override
    public void deleteProduct(MenuItem item) {
        assert item != null && menuItems != null;
        int sizePre = menuItems.size();
        menuItems.remove(item);
        int sizePost = menuItems.size();
        assert sizePost == sizePre - 1;
        assert wellFormed();

    }

    @Override
    public void updateProduct(MenuItem oldItem, MenuItem newItem) {
        assert oldItem != null && newItem != null;
        assert !Objects.equals(newItem.getTitle(), "") && newItem.getRating() >= 0 && newItem.getCalories() >= 0 && newItem.getProtein() >= 0 && newItem.getFat() >= 0 && newItem.getSodium() >= 0 && newItem.getPrice() >= 0;
        menuItems.remove(oldItem);
        menuItems.add(newItem);
        assert menuItems.contains(newItem);
        assert wellFormed();
    }

    @Override
    public Set<MenuItem> filterProducts(String keyword, float rating, int calories, int protein, int fat, int sodium, float price) {

        Set<MenuItem> items = new HashSet<>(menuItems);
        if (!Objects.equals(keyword, ""))
            items = items.stream().filter(p -> p.getTitle().toLowerCase().contains(keyword.toLowerCase())).collect(Collectors.toSet());
        if (rating != -1)
            items = items.stream().filter(p -> p.getRating() == rating).collect(Collectors.toSet());
        if (calories != -1)
            items = items.stream().filter(p -> p.getCalories() == calories).collect(Collectors.toSet());
        if (protein != -1)
            items = items.stream().filter(p -> p.getProtein() == protein).collect(Collectors.toSet());
        if (fat != -1)
            items = items.stream().filter(p -> p.getFat() == fat).collect(Collectors.toSet());
        if (sodium != -1)
            items = items.stream().filter(p -> p.getSodium() == sodium).collect(Collectors.toSet());
        if (price != -1)
            items = items.stream().filter(p -> p.getPrice() == price).collect(Collectors.toSet());

        assert wellFormed();

        return items;
    }


    public User logInUser(String username, String password) {
        User user = users.stream()
                .filter(usr -> usr.getUsername().equals(username) && usr.getPassword().equals(password))
                .findFirst()
                .orElse(null);
        return user;
    }

    public User findUsername(String username) {
        User user = (User) users.stream()
                .filter(usr -> usr.getUsername().equals(username))
                .findAny()
                .orElse(null);
        return user;
    }

    public void signUpClient(User user) {
        users.add(user);
    }

    @Override
    public Order newOrder(User user, List<MenuItem> products) {
        assert user != null && products.size() > 0;
        int sizePre = menuItems.size();
        float totalPrice = 0;
        for (MenuItem menuItem : products)
            totalPrice += menuItem.getPrice();
        Order order = new Order(user.getId(), totalPrice);
        placedOrders.put(order, products);

        setChanged();
        notifyObservers(placedOrders);

        FileWriter.createBill(this, order);

        int sizePost = placedOrders.size();
        assert sizePost == sizePre + 1;
        assert wellFormed();
        return order;
    }

    public MenuItem findProductByName(String name) {
        MenuItem item = menuItems.stream()
                .filter(menuItem -> menuItem.getTitle().equals(name))
                .findAny()
                .orElse(null);
        return item;
    }

    public User findUserById(int id, Collection<User> users) {
        User user = users.stream()
                .filter(usr -> usr.getId() == id)
                .findAny()
                .orElse(null);
        return user;
    }


    public void generateRaport1(int startHour, int endHour) {
        List<Order> items = placedOrders.keySet().stream()
                .filter(order -> order.getOrderDate().getHours() >= startHour)
                .filter(order -> order.getOrderDate().getHours() < endHour)
                .collect(Collectors.toList());

        FileWriter.generateReport1(startHour, endHour, items);
    }

    public void generateRaport2(int times) {
        List<MenuItem> generated = menuItems.stream()
                .filter(x -> placedOrders.values().stream()
                        .flatMapToLong(list -> LongStream.of(list.stream()
                                .filter(item -> x.getTitle().equals(item.getTitle()))
                                .count()))
                        .sum() >= times)
                .collect(Collectors.toList());


        FileWriter.generateReport2(times, generated);


    }


    public void generateRaport3(int times, float amount) {
        List<User> generated = users.stream()
                .filter(user -> placedOrders.keySet().stream()
                        .filter(order -> order.getIdClient() == user.getId())
                        .filter(order -> placedOrders.get(order).stream()
                                .flatMapToDouble(menuItem -> DoubleStream.of(menuItem.getPrice()))
                                .sum() >= amount)
                        .count() >= times)
                .collect(Collectors.toList());


        FileWriter.generateReport3(times, amount, generated);
    }

    public void generateRaport4(int day, int month, int year) {
        List<MenuItem> products = new ArrayList<>();

        List<Order> orders = placedOrders.keySet().stream()
                .filter(order -> order.getDay() == day)
                .filter(order -> order.getMonth() == month)
                .filter(order -> order.getYear() == year)
                .toList();

        orders.forEach((order) -> {
            products.addAll(placedOrders.get(order).stream().toList());
        });


        Map<MenuItem, Long> frequencyMap = products.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        FileWriter.generateReport4(day, month, year, frequencyMap);

    }


    public Map<Order, Collection<MenuItem>> sortOrders() {
        Map<Order, Collection<MenuItem>> sorted = deliveryService.getPlacedOrders().entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        return sorted;

    }

    public Set<MenuItem> getMenuItems() {
        return menuItems;
    }

    public Map<Order, Collection<MenuItem>> getPlacedOrders() {
        return placedOrders;

    }

    public Set<User> getUsers() {
        return users;
    }

}
