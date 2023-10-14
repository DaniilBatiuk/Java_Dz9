package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static boolean isPalindromic(int number) {
        String numStr = String.valueOf(number);
        return numStr.equals(new StringBuilder(numStr).reverse().toString());
    }

    public static void main(String[] args) {

        //Task1
        System.out.println("\nTask1");

        Random random = new Random();
        List<Integer> numbers = random.ints(100, -100, 100)
                .boxed()
                .collect(Collectors.toList());

        long positiveCount = numbers.stream()
                .filter(num -> num > 0)
                .count();

        long negativeCount = numbers.stream()
                .filter(num -> num < 0)
                .count();

        long twoDigitCount = numbers.stream()
                .filter(num -> num >= 10 && num <= 99)
                .count();

        long palindromicCount = numbers.stream()
                .filter(Main::isPalindromic)
                .count();

        System.out.println("Кількість додатних чисел: " + positiveCount);
        System.out.println("Кількість від'ємних чисел: " + negativeCount);
        System.out.println("Кількість двозначних чисел: " + twoDigitCount);
        System.out.println("Кількість дзеркальних чисел: " + palindromicCount);


        //Task2
        System.out.println("\nTask2");

        List<String> products = Arrays.asList("Apple", "Banana", "Milk", "Cheese", "Bread", "Butter", "Yogurt", "Milk");

        List<String> allProducts = products.stream().distinct().collect(Collectors.toList());
        System.out.println("Всі продукти: " + allProducts);

        List<String> shortNamedProducts = products.stream()
                .filter(product -> product.length() < 5)
                .collect(Collectors.toList());
        System.out.println("Продукти з назвою менше п'яти символів: " + shortNamedProducts);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть назву продукту для підрахунку: ");
        String userProduct = scanner.nextLine();
        long productCount = products.stream()
                .filter(product -> product.equalsIgnoreCase(userProduct))
                .count();
        System.out.println("Продукт '" + userProduct + "' зустрічається " + productCount + " разів.");

        System.out.print("Введіть букву для пошуку продуктів: ");
        String userLetter = scanner.nextLine();
        List<String> productsStartingWithLetter = products.stream()
                .filter(product -> product.toLowerCase().startsWith(userLetter.toLowerCase()))
                .collect(Collectors.toList());
        System.out.println("Продукти, що починаються на букву '" + userLetter + "': " + productsStartingWithLetter);

        List<String> milkProducts = products.stream()
                .filter(product -> product.equalsIgnoreCase("Milk"))
                .collect(Collectors.toList());
        System.out.println("Продукти з категорії 'Молоко': " + milkProducts);


        //Task3
        System.out.println("\nTask3");


        List<Device> devices = Arrays.asList(
                new Device("Phone", 2021, 1000, "Black", "Smartphone"),
                new Device("Laptop", 2022, 1500, "Gray", "Laptop"),
                new Device("TV", 2020, 800, "Black", "Television"),
                new Device("Tablet", 2023, 700, "White", "Smartphone"),
                new Device("Camera", 2019, 1200, "Black", "Photography")
        );

        devices.forEach(System.out::println);

        String targetColor = "Black";
        List<Device> devicesWithColor = devices.stream()
                .filter(device -> device.getColor().equalsIgnoreCase(targetColor))
                .collect(Collectors.toList());
        System.out.println("\nПристрій з кольором " + targetColor + ":");
        devicesWithColor.forEach(System.out::println);

        int targetYear = 2020;
        List<Device> devicesWithYear = devices.stream()
                .filter(device -> device.getReleaseYear() == targetYear)
                .collect(Collectors.toList());
        System.out.println("\nПристрої з роком випуску " + targetYear + ":");
        devicesWithYear.forEach(System.out::println);

        double minPrice = 1000;
        List<Device> expensiveDevices = devices.stream()
                .filter(device -> device.getPrice() > minPrice)
                .collect(Collectors.toList());
        System.out.println("\nПристрої дорожче ніж " + minPrice + ":");
        expensiveDevices.forEach(System.out::println);


        //Task4
        System.out.println("\nTask4");

        List<Projector> projectors = Arrays.asList(
                new Projector("Epson 123", 2021, 1000, "Epson"),
                new Projector("Sony XYZ", 2020, 1500, "Sony"),
                new Projector("LG 456", 2021, 1200, "LG"),
                new Projector("BenQ ABC", 2019, 800, "BenQ"),
                new Projector("Epson 789", 2023, 1300, "Epson")
        );

        projectors.forEach(System.out::println);

        String targetManufacturer = "Epson";
        List<Projector> epsonProjectors = projectors.stream()
                .filter(projector -> projector.getManufacturer().equals(targetManufacturer))
                .collect(Collectors.toList());
        System.out.println("\nПроектори виробника" + targetManufacturer + ":");
        epsonProjectors.forEach(System.out::println);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Projector> currentYearProjectors = projectors.stream()
                .filter(projector -> projector.getReleaseYear() == currentYear)
                .collect(Collectors.toList());
        System.out.println("\nПроектори року " + currentYear + ":");
        currentYearProjectors.forEach(System.out::println);

        double minPrice2 = 1000;
        List<Projector> expensiveProjectors = projectors.stream()
                .filter(projector -> projector.getPrice() > minPrice2)
                .collect(Collectors.toList());
        System.out.println("\nПроектори вище " + minPrice2 + ":");
        expensiveProjectors.forEach(System.out::println);

        List<Projector> sortedByPriceAsc = projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::getPrice))
                .collect(Collectors.toList());
        System.out.println("\nПроектори, відсортувати по ціна зростання:");
        sortedByPriceAsc.forEach(System.out::println);

        List<Projector> sortedByPriceDesc = projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::getPrice).reversed())
                .collect(Collectors.toList());
        System.out.println("\nПроектори, відсортувати по ціні спадання:");
        sortedByPriceDesc.forEach(System.out::println);

        List<Projector> sortedByYearAsc = projectors.stream()
                .sorted(Comparator.comparingInt(Projector::getReleaseYear))
                .collect(Collectors.toList());
        System.out.println("\nПроектори, відсортувати по року випуску по зростанню:");
        sortedByYearAsc.forEach(System.out::println);

        List<Projector> sortedByYearDesc = projectors.stream()
                .sorted(Comparator.comparingInt(Projector::getReleaseYear).reversed())
                .collect(Collectors.toList());
        System.out.println("\nПроектори, відсортувати по року випуску по спаданню:");
        sortedByYearDesc.forEach(System.out::println);
    }
}