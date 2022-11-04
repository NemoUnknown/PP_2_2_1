package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car toyota = new Car("Toyota", "LC200");
        Car ford = new Car("Ford", "GT500");
        Car mazda = new Car("Mazda", "RX5");
        Car mercedes = new Car("Mercedes", "GL400");

        User ivanov = new User("Иван", "Иванов", "ivanoff@mail.ru");
        User petrov = new User("Петр", "Петров", "petr94@ya.ru");
        User sidorov = new User("Александр", "Сидоров", "SidAlex@mail.ru");
        User semenov = new User("Семен", "Семенов", "semsem99@ya.ru");

        ivanov.setCar(mazda);
        petrov.setCar(ford);
        sidorov.setCar(toyota);
        semenov.setCar(mercedes);

        userService.add(ivanov);
        userService.add(petrov);
        userService.add(sidorov);
        userService.add(semenov);

//        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        List<User> usersWithToyota = userService.getUserWhoCarAccordingModelAndSeries("Mercedes", "GL400");
        for (User user : usersWithToyota) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        context.close();
    }
}
