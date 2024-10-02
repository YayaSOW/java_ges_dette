package org.example.views.imp;
import org.example.data.entities.Client;
import org.example.views.View;

public class ClientView extends ViewImp<Client> implements View<Client> {
    @Override
    public Client saisi() {
        Client cl = new Client();
        System.out.println("Entrer le surnom:");
        cl.setSurname(scanner.nextLine());
        System.out.println("Entrer le Telephone: ");
        cl.setTelephone(scanner.nextLine());
        System.out.println("Entrer l'address: ");
        cl.setAddress(scanner.nextLine());
        return cl;
    }
}
