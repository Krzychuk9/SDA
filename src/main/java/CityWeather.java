
public class CityWeather {
    private String name;
    private float temperature;
    private float humadity;
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

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setHumadity(float humadity) {
        this.humadity = humadity;
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

    public float getTemperature() {
        return temperature;
    }

    public float getHumadity() {
        return humadity;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public float getGradLevel() {
        return gradLevel;
    }
}
