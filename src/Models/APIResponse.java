package Models;

public class APIResponse {
    private Weather[] weather;
    private Main main;
    private Wind wind;
    private Coord coord;


    public APIResponse(Weather[] weather, Main main, Wind wind, Coord coord) {
        this.weather = weather;
        this.main = main;
        this.wind = wind;
        this.coord = coord;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }
}
