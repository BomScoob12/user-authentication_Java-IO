import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option = 0;
        Scanner scan = new Scanner(System.in);
        UserManager manager = new UserManager();

        while (option != 5){
            System.out.println("Select Menu.");
            System.out.println("1. Register new User");
            System.out.println("2. Login user account");
            System.out.println("3. Delete user account by ID");
            System.out.println("4. List all users");
            System.out.println("5. Exit");
            System.out.print("Enter menu option : ");
            option = scan.nextInt();
            scan.nextLine();

            switch (option){
                case 1 -> {
                    System.out.print("Enter your username : ");
                    String username = scan.nextLine();
                    System.out.print("Enter your password : ");
                    String pass = scan.nextLine();
                    User user = new User(username,pass);
                    manager.registerUser(user);
                }
                case 2 -> {
                    System.out.println("Login user account");
                    System.out.print("Enter your username : ");
                    String username = scan.nextLine();
                    System.out.print("Enter your password : ");
                    String pass = scan.nextLine();
                    User user = new User(username,pass);
                    System.out.println(manager.loginUser(user));

                }
                case 3 -> {
                    System.out.println("Delete User account");
                    System.out.println("Enter user ID : ");
                    String id = scan.nextLine();
                    manager.deleteUserByID(id);
                    System.out.println("Delete complete.");
                }
                case 4 -> {
                    for (String result : manager.listAllUser()){
                        System.out.println(result);
                    }
                }
                case 5 ->{
                    System.out.println("Exit...");
                }
            }
            System.out.println();
        }
    }
}