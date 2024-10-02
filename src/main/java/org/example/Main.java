package org.example;

import org.example.core.factory.ServiceFactory;
import org.example.core.factory.ViewFactory;
import org.example.core.factory.impl.ServiceFactoryImpl;
import org.example.core.factory.impl.ViewFactoryImpl;
import org.example.data.entities.Client;
import org.example.data.entities.User;
import org.example.services.ClientService;
import org.example.services.UserService;
import org.example.views.View;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ServiceFactory serviceFactoryImpl = new ServiceFactoryImpl();
        ViewFactory viewFactoryImpl = new ViewFactoryImpl();
        ClientService clientServiceImp = serviceFactoryImpl.getInstanceClientService();
        UserService userServiceImp = serviceFactoryImpl.getInstanceUserService();
        View<Client> clientView = viewFactoryImpl.getInstanceClientView();
        View<User> userView = viewFactoryImpl.getInstanceUserView();
        clientView.setScanner(scanner);
        userView.setScanner(scanner);
        int choice;
        do {
            choice = menu();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    Client cl = clientView.saisi();
                    User user = null;
                    System.out.println("Voulez vous voulez vous creer un user O/N ?");
                    String rep = String.valueOf(scanner.next().charAt(0));
                    if (rep.compareToIgnoreCase("o") == 0) {
                        scanner.nextLine();
                        user = userView.saisi();
                        userServiceImp.create(user);
                        cl.setUser(user);
                    }
                    clientServiceImp.create(cl);
                }
                case 2 -> {
                    clientView.afficher(clientServiceImp.findAll());
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
                    User user = userView.saisi();
                    userServiceImp.create(user);
                }
                case 5 -> {
                    userView.afficher(userServiceImp.findAll());
                }
            }
        } while (choice != 6);
        scanner.close();
    }

    public static int menu() {
        System.out.println("1- Create client");
        System.out.println("2- List client");
        System.out.println("3- Find client by phone");
        System.out.println("4- Create user");
        System.out.println("5- List user");
        System.out.println("6- Quitter");
        return scanner.nextInt();
    }
}