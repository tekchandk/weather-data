import models.WeatherData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class WeatherMain {

    private static List<WeatherData> changeTextDataToListData() throws Exception {
        List<WeatherData> data = new ArrayList<>();

        File file = new File("src/assets/weather.dat");
        BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine();
        br.readLine();
        String rowData;
        while ((rowData = br.readLine()) != null) {
            int day = Integer.parseInt(rowData.split("  ")[1].trim());
            String maxTemp = rowData.split("    ")[0].split("  ")[2];
            String minTemp = rowData.split("    ")[1];
            int avgTemp = Integer.parseInt(rowData.split("    ")[2]);
            data.add(new WeatherData(day, maxTemp, minTemp, avgTemp ));
            if(day == 30)
                break;
        }
        return data;
    }


    private static void printDayWithSmallestTemp() throws Exception{
        System.out.println("Day  " + "MaxT  " + "MinT");
        System.out.println(" " + getWeatherDataWithSmallestTemp().getDay() + "  "
                + getWeatherDataWithSmallestTemp().getMaxTemp() + "  "
                + getWeatherDataWithSmallestTemp().getMinTemp());
    }

    private static WeatherData getWeatherDataWithSmallestTemp() throws Exception {
        int smallestTemp = 150;
        WeatherData minWeatherData = new WeatherData(1, "80", "40", 60);
        for(WeatherData weatherData : changeTextDataToListData()) {
            if(weatherData.getAvgTemp() <= smallestTemp) {
                smallestTemp = weatherData.getAvgTemp();
                minWeatherData = weatherData;
            }
        }
        return minWeatherData;
    }


    public static void main(String[] args) throws Exception {
        printDayWithSmallestTemp();
    }
}
