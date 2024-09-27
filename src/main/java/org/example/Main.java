package org.example;

import org.example.core.factory.impl.ServiceFactoryImpl;
import org.example.data.entities.Client;
import org.example.data.entities.User;
import org.example.data.enums.RoleEnum;
import org.example.services.ClientService;
import org.example.services.UserService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ServiceFactoryImpl serviceFactoryImpl = new ServiceFactoryImpl();
        ClientService clientServiceImp = serviceFactoryImpl.getInstanceClientService();
        UserService userServiceImp = serviceFactoryImpl.getInstanceUserService();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1- Create client");
            System.out.println("2- List client");
            System.out.println("3- Find client by phone");
            System.out.println("4- Create user");
            System.out.println("5- List user");
            System.out.println("6- Quitter");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    Client cl = new Client();
                    User user = null;
                    System.out.println("Entrer le surnom:");
                    cl.setSurname(scanner.nextLine());
                    System.out.println("Entrer le Telephone: ");
                    cl.setTelephone(scanner.nextLine());
                    System.out.println("Entrer l'address: ");
                    cl.setAddress(scanner.nextLine());
                    System.out.println("Voulez vous voulez vous creer un user O/N ?");
                    String rep = String.valueOf(scanner.next().charAt(0));
                    if (rep.compareToIgnoreCase("o") == 0) {
                        user = new User();
                        scanner.nextLine();
                        System.out.println("Enter the user's name: ");
                        user.setNom(scanner.nextLine());
                        System.out.println("Enter the user's firstname: ");
                        user.setPrenom(scanner.nextLine());
                        System.out.println("Enter the user's login: ");
                        user.setLogin(scanner.nextLine());
                        System.out.println("Enter the user's password: ");
                        user.setRole(RoleEnum.Admin);
                        user.setPassword(scanner.nextLine());
                        user.setEtat(true);
                        userServiceImp.create(user);
                    }
                    cl.setUser(user);
                    clientServiceImp.create(cl);
                }
                case 2 -> {
                    List<Client> clients = clientServiceImp.findAll();
                    clients.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.println("Entrer le telephone:");
                    String telephone = scanner.nextLine();
                    Client cli = clientServiceImp.search(telephone);
                    if (cli == null) {
                        System.out.println("Le client n'existe pas");
                    } else {
                        System.out.println(cli);
                    }
                }
                case 4 -> {
                    User user = new User();
                    System.out.println("Enter the user's name: ");
                    user.setNom(scanner.nextLine());
                    System.out.println("Enter the user's firstname: ");
                    user.setPrenom(scanner.nextLine());
                    System.out.println("Enter the user's login: ");
                    user.setLogin(scanner.nextLine());
                    System.out.println("Enter the user's password: ");
                    user.setPassword(scanner.nextLine());
                    user.setRole(RoleEnum.Admin);
                    user.setEtat(true);
                    userServiceImp.create(user);
                }
                case 5 -> {
                    userServiceImp.findAll().forEach(System.out::println);
                }
            }
        } while (choice != 6);
        scanner.close();
    }
}