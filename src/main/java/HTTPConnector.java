import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPConnector {
    private URL url;
    private BufferedReader br;
    private HttpURLConnection connection;
    private StringBuffer sb;
    private String appid;

    /**
     * Constructor
     *
     * @param appid unique key from openweathermap.org
     */
    public HTTPConnector(String appid) {
        this.appid = appid;
    }

    /**
     * Sends GET request to server openweathermap.org
     *
     * @param cityName String name of city
     * @return String, json type
     * @throws IOException
     */
    public String sendRequest(String cityName) {
        try {
            url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&APPID=" + this.appid + "&units=metric");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                sb = new StringBuffer();
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                return sb.toString();
            } else {
                throw new RuntimeException("Server error, code: " + responseCode);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }
}