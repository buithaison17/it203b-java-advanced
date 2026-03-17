package gioi2;

import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int temperature = 20;

    @Override
    public void attach(Observer o) {
        observers.add(o);
        System.out.println("Dang ky thiet bi");
    }

    @Override
    public void detack(Observer o) {
        observers.remove(o);
        System.out.println("Xoa dang ky thiet bi");
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

}
