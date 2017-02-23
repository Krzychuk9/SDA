
public class City {

    private String name;

    /**
     * Constructor
     *
     * @param name city's name
     */
    public City(String name) {
        this.name = name;
    }

    /*
    Getter
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        return name != null ? name.equals(city.name) : city.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}