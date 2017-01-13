import java.util.Scanner;

public class Menu {
    private String data;
    private Scanner sc = new Scanner(System.in);
    private Cities cities = new Cities();
    private Weather weather = new Weather();

    /**
     * Start app, take input from user, add cities and download date from server
     */
    public void start() {
        do {
            this.showMenu();
            data = this.getData();
            switch (data) {
                case "1":
                    cities.addCity();
                    break;
                case "2":
                    weather.checkWeather(cities.getCitiesNames());
                    break;
                case "3":
                    System.out.println("See you later!");
                    break;
                default:
                    System.out.println("Wrong option!");
            }
        } while (!data.equals("3"));
    }

    /**
     * Print menu in console
     */
    public void showMenu() {
        System.out.println("Menu: ");
        System.out.println("1. Add city");
        System.out.println("2. Check weather in your cities");
        System.out.println("3. Exit");
    }

    /**
     * Take input from console
     * @return string inputed by user
     */
    public String getData() {
        String data = sc.nextLine();
        return data;
    }

}
