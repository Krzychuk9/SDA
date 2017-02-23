import java.util.ArrayList;
import java.util.List;

public class Weather {
    private List<CityWeather> cityWeathers = new ArrayList<>();
    private HTTPConnector client;
    private WeatherParser parser;

    /**
     * Download data from openweathermap.org and display it in console
     *
     * @param citiesNames list of string
     */
    public void checkWeather(List<String> citiesNames) {
        if (citiesNames.isEmpty()) {
            System.out.println("City not found");
            return;
        }
        client = new HTTPConnector("6a266eb610b14027977a995a15e7a205");
        parser = new WeatherParser();
        for (int i = 0; i < citiesNames.size(); i++) {
            String request = client.sendRequest(citiesNames.get(i));
            cityWeathers.add(parser.getCityWeather(request));
        }
        showWeather();
        cityWeathers.clear();
    }

    /**
     * print current weather data in console
     */
    private void showWeather() {
        System.out.println("Current weather in your cities: ");
        for (int i = 0; i < cityWeathers.size(); i++) {
            System.out.println("City: " + cityWeathers.get(i).getName());
            System.out.println("Temperature: " + cityWeathers.get(i).getTemp() + " Celsius");
            System.out.println("Humidity: " + cityWeathers.get(i).getHumidity() + "%");
            System.out.println("Pressure: " + cityWeathers.get(i).getGradLevel() + " hPa");
            System.out.println("Wind speed: " + cityWeathers.get(i).getWindSpeed() + " m/s");
            System.out.println("");
        }
    }
}
