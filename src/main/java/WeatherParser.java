import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherParser {

    /**
     * Parses String with weather data and return CityWeather object, if param doesn't contain correct data it will be set to 9999
     *
     * @param json string weather data
     * @return CityWeather object
     */
    public CityWeather getCityWeather(String json) {
        JsonElement tree = new JsonParser().parse(json);
        JsonObject treeObj = tree.getAsJsonObject();
        JsonObject mainObj = treeObj.getAsJsonObject("main");
        JsonObject windObj = treeObj.getAsJsonObject("wind");

        String name = treeObj.get("name").getAsString();
        Float temp = mainObj.get("temp").getAsFloat();
        Float humidity = mainObj.get("humidity").getAsFloat();
        Float windSpeed = windObj.get("speed").getAsFloat();
        Float gradLevel = mainObj.get("pressure").getAsFloat();

        CityWeather cityWeather = new CityWeather();
        if (name != null) {
            cityWeather.setName(name);
        }
        if (temp != null) {
            cityWeather.setTemp(temp);
        } else {
            cityWeather.setTemp(9999);
        }
        if (humidity != null) {
            cityWeather.setHumidity(humidity);
        } else {
            cityWeather.setHumidity(9999);
        }
        if (windSpeed != null) {
            cityWeather.setWindSpeed(windSpeed);
        } else {
            cityWeather.setWindSpeed(9999);
        }
        if (gradLevel != null) {
            cityWeather.setGradLevel(gradLevel);
        } else {
            cityWeather.setGradLevel(9999);
        }

        return cityWeather;
    }

}