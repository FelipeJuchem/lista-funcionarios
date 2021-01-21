package main;

import entities.Funcionarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Funcionarios> list = new ArrayList<>();

        System.out.print("How many employees will be registered?");
        int n = sc.nextInt();

        for (int i=0; i<n; i++){
            System.out.println("Empregado #" + (i+1) + ":");
            System.out.print("Id:");
            int id = sc.nextInt();
            System.out.print("Name:");
            String name = sc.next();
            System.out.print("Salary:");
            double salary = sc.nextDouble();
            System.out.println();
            list.add(new Funcionarios(id, name, salary));
        }

        System.out.println("Enter the employee id that will have salary increase");
        int id = sc.nextInt();
        Funcionarios emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (emp == null){
            System.out.println("This id do not exist!");
        }
        else {
            System.out.println("Enter the percentage:");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }

        System.out.println();
        System.out.println("Lista de empregados");
        for (Funcionarios obj : list){
            System.out.println(obj);
        }

    }


}
