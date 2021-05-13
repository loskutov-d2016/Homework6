package Homework7;
import Homework7.enums.Functionality;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static Homework7.enums.Periods.FIVE_DAYS;
import static Homework7.enums.Periods.NOW;

public class Controller {
    WeatherProvider weatherProvider = new AccuWeatherProvider();
    Map<Integer, Functionality> variantResult = new HashMap();

    public Controller() {
        variantResult.put(1, Functionality.GET_CURRENT_WEATHER);
        variantResult.put(2, Functionality.GET_WEATHER_IN_NEXT_5_DAYS);
    }

    public void onUserInput(String input) throws IOException {
        int command = Integer.parseInt(input);
        if (!variantResult.containsKey(command)) {
            throw new IOException("There is no command for command-key " + command);
        }

        switch (variantResult.get(command)) {
            case GET_CURRENT_WEATHER:
                getCurrentWeather();
                break;
            case GET_WEATHER_IN_NEXT_5_DAYS:
                getWeatherIn5Days();
                break;
        }
    }

    public void getCurrentWeather() throws IOException {
        weatherProvider.getWeather(NOW);
    }

    public void getWeatherIn5Days() throws IOException {
        weatherProvider.getWeather(FIVE_DAYS);
    }
}

