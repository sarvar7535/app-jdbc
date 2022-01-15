import entity.Response;
import repository.CategoryRepository;
import repository.CurrencyRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
//        System.out.println(CategoryRepository.addCategory());
//       System.out.println(CategoryRepository.getCategories());

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Id ni kiriting: ");
//        int id = scanner.nextInt();
//        scanner = new Scanner(System.in);
//        System.out.print("Nomini kirit: ");
//        String name = scanner.nextLine();
//        System.out.print("Yengi nomini kirit: ");
//        String n_name = scanner.nextLine();
//        System.out.print("typini kirit: ");
//        String type = scanner.nextLine();
//        CategoryRepository.addCategory(id,name);
//        Response response = CategoryRepository.callFunc(name, type, n_name);
//        System.out.println(response);
//        System.out.println("Xammasi yaxshi bo'ladi");
//
//        System.out.println(CategoryRepository.getCategories());

        System.out.println(CurrencyRepository.getCurrency());

        Scanner scanner = new Scanner(System.in);
//        System.out.print("Id ni kiriting: ");
//        int id = scanner.nextInt();
        scanner = new Scanner(System.in);
        System.out.print("Nomini kirit: ");
        String name = scanner.nextLine();
        System.out.print("Yengi nomini kirit: ");
        String n_name = scanner.nextLine();
        System.out.print("typini kirit: ");
        String type = scanner.nextLine();
//        CurrencyRepository.addCurrency(id,name);
        CurrencyRepository.callFunc(name,type,n_name);


    }
}
