package org.example.views.imp;
import org.example.data.entities.User;
import org.example.data.enums.RoleEnum;
import org.example.views.View;

public class UserView extends ViewImp<User> implements View<User>{
    @Override
    public User saisi() {
        User user = new User();
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
        return user;
    }
}
