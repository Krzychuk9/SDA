
public class CityWeather {
    private String name;
    private float temp;
    private float humidity;
    private float windSpeed;
    private float gradLevel;

    /**
     * Constructor
     */
    public CityWeather() {
    }

    /*
    Setters
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setGradLevel(float gradLevel) {
        this.gradLevel = gradLevel;
    }

    /*
    Getters
     */
    public String getName() {
        return name;
    }

    public float getTemp() {
        return temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public float getGradLevel() {
        return gradLevel;
    }
}
