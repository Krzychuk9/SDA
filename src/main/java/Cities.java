import java.util.*;

public class Cities {
    private Set<City> cities = new HashSet<>();
    private Scanner sc = new Scanner(System.in);

    /**
     * Take input from console and add new city to collection
     */
    public void addCity() {
        String cityName = getData();
        City city = new City(cityName);
        cities.add(city);
        System.out.println("Miasto " + cityName + " dodano do bazy");
    }

    /**
     * Take input from console
     *
     * @return string inputed by user
     */
    private String getData() {
        System.out.println("Podaj nazwę miasta");
        String data = sc.nextLine();
        return data;
    }

    /**
     * Creat names of cities list
     *
     * @return list of strings
     */
    public List<String> getCitiesNames() {
        List<String> citiesNames = new ArrayList<>();
        for (City city : cities) {
            citiesNames.add(city.getName());
        }
        return citiesNames;
    }
}
