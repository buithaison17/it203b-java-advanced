package gioi2;

public interface Subject {
    public void attach(Observer o);

    public void detack(Observer o);

    public void notifyObservers();
}
