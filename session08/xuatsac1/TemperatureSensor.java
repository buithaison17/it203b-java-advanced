package xuatsac1;

import java.util.ArrayList;
import java.util.List;

import gioi2.Observer;
import gioi2.Subject;

public class TemperatureSensor implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int temperature = 25;

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detack(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}
