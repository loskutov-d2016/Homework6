package Homework8;

import Homework7.enums.Periods;
import Homework8.entity.WeatherData;

import java.io.IOException;

public interface WeatherProvider {

    WeatherData getWeather(Periods periods) throws IOException;

    WeatherData getAllFromDb() throws IOException;
}
