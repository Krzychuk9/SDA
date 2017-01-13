import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Weather {
    private List<CityWeather> cityWeathers = new ArrayList<>();
    /*
    apiKey - unique key from openweathermap.org
     */
    private OpenWeatherMap openWeatherMap = new OpenWeatherMap(OpenWeatherMap.Units.METRIC, "6a266eb610b14027977a995a15e7a205");

    /**
     * Download data from openweathermap.org and display in console
     * @param citiesNames list of string
     */
    public void checkWeather(List<String> citiesNames) {
        if (citiesNames.isEmpty()) {
            System.out.println("City not found");
            return;
        }
        for (int i = 0; i < citiesNames.size(); i++) {
            try {
                CurrentWeather cw = openWeatherMap.currentWeatherByCityName(citiesNames.get(i));
                if (cw.isValid()) {
                    CityWeather cityWeather = new CityWeather();
                    if (cw.hasCityName()) {
                        cityWeather.setName(cw.getCityName());
                    }
                    if (cw.hasMainInstance()) {
                        cityWeather.setTemperature(cw.getMainInstance().getTemperature());
                        cityWeather.setHumadity(cw.getMainInstance().getHumidity());
                        cityWeather.setGradLevel(cw.getMainInstance().getPressure());
                    }
                    if (cw.hasWindInstance()) {
                        cityWeather.setWindSpeed(cw.getWindInstance().getWindSpeed());
                    }
                    cityWeathers.add(cityWeather);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        showWeather();
    }

    /**
     * print current weather data in console
     */
    private void showWeather() {
        System.out.println("Current weather in your cities: ");
        for (int i = 0; i < cityWeathers.size(); i++) {
            System.out.println("City: " + cityWeathers.get(i).getName());
            System.out.println("Temperature: " + cityWeathers.get(i).getTemperature() + " Celsius");
            System.out.println("Humidity: " + cityWeathers.get(i).getHumadity() + "%");
            System.out.println("Pressure: " + cityWeathers.get(i).getGradLevel() + " hPa");
            System.out.println("Wind speed: " + cityWeathers.get(i).getWindSpeed() + " m/s");
            System.out.println("");
        }
    }
}
