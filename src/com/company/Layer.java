package com.company;

import com.company.controllers.control;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Layer {
    private final control controller;
    private final Scanner scanner;

    public Layer(control controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void launch() {
        while (true) {
            System.out.println();
            System.out.println("Select option:");
            System.out.println("1. Get medicine by name");
            System.out.println("2. Get medicine by id");
            System.out.println("3. Create new medicine");
            System.out.println("4. Remove medicine by id");
            System.out.println("5. Get medicines list");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter option: ");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        getMedByName();
                    case 2:
                        getMedById();
                    case 3:
                        addMed();
                    case 4:
                        removeMed();
                    case 5:
                        getMedAll();
                    default:
                        break;
                }
            } catch (InputMismatchException yes) {
                System.out.println("Input Must be 1-9");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("---------------------------------------------------------------");
        }
    }

    public void getMedAll(){
        String temp = controller.getAllMedicines();
        System.out.println(temp);
    }

    public void getMedById(){
        System.out.println("Enter medicine id");
        int id = scanner.nextInt();
        String temp = controller.getMedicineById(id);
        System.out.println(temp);
    }

    public void getMedByName(){
        System.out.println("Enter medicine name");
        String name = scanner.next();
        String temp = controller.getMedicineByName(name);
        System.out.println(temp);
    }

    public void removeMed(){
        System.out.println("Enter id");
        int id = scanner.nextInt();
        String temp = controller.deleteMedicineById(id);
        System.out.println(temp);
    }

    public void addMed(){
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter price");
        double price = scanner.nextDouble();
        System.out.println("Please enter expiration date");
        Date date = Date.valueOf(scanner.next());
        System.out.println("Please enter manufacturer");
        String manufacturer = scanner.next();
        String temp = controller.addMedicine(name, price, date, manufacturer);
        System.out.println(temp);
    }
}