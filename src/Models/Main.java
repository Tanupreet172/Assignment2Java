package Models;

import com.google.gson.annotations.SerializedName;

public class Main {
    private double temp;
    @SerializedName("feelslike")
    private double feelsLike;
    @SerializedName("tempmin")
    private double tempMin;
    @SerializedName("temp_max")
    private double tempMax;
    private double pressure;
    private double humidity;

    public Main(double temp, double feelsLike, double tempMin, double tempMax, double pressure, double humidity) {
        setTemp(temp);
        setFeelsLike(feelsLike);
        setTempMin(tempMin);
        setTempMax(tempMax);
        setPressure(pressure);
        setHumidity(humidity);
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                ", feelsLike=" + feelsLike +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }
}
