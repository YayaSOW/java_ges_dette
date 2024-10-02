package org.example.views.imp;

import java.util.List;
import java.util.Scanner;

import org.example.views.View;

public abstract class ViewImp<T> implements View<T> {
    protected Scanner scanner ;

    @Override
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void afficher(List<T> data){
        data.forEach(System.out::println);
    }

}
