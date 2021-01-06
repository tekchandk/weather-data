package models;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class WeatherData {
    private int day;
    private String maxTemp;
    private String minTemp;
    private int avgTemp;
    public WeatherData(int day, String maxTemp, String minTemp, int avgTemp) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.avgTemp = avgTemp;
    }

    public int getDay() {
        return day;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public int getAvgTemp() {
        return avgTemp;
    }

}
