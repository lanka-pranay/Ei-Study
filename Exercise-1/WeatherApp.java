//behavioural design pattern
//Example 2

//Use Case: A weather station that notifies multiple display devices (like a mobile app and a web dashboard) whenever there's a change in weather data.
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float temperature, float humidity);
}

class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setWeatherData(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity);
        }
    }
}

class MobileDisplay implements Observer {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Mobile Display - Temperature: " + temperature + "°C, Humidity: " + humidity + "%");
    }
}

class WebDashboard implements Observer {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Web Dashboard - Temperature: " + temperature + "°C, Humidity: " + humidity + "%");
    }
}

// Example usage
public class WeatherApp {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        MobileDisplay mobileDisplay = new MobileDisplay();
        WebDashboard webDashboard = new WebDashboard();

        station.addObserver(mobileDisplay);
        station.addObserver(webDashboard);

        station.setWeatherData(25.0f, 60.0f);
        station.setWeatherData(30.0f, 55.0f);
    }
}