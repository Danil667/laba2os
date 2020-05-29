import java.util.ArrayList;
import java.util.Random;

public class Process {
    private String id;
    private int prioritet;
    private int operatingTime;
    private ArrayList<Thread> thread;
    public Process(String id, int prioritet) {
        this.id = id;
        this.prioritet = prioritet;
        Random randomNumber = new Random();
        thread = new ArrayList<>();
        for (int i = 0; i < randomNumber.nextInt(5) + 1; i++) {
            thread.add(new Thread("поток " + (i + 1), 8 * i + 1, prioritet, id));
            this.operatingTime += thread.get(i).getOperatingTime();
        }
    }
    public int getOperatingTime() {
        return operatingTime;
    }
    public void setOperatingTime(int operatingTime) {
        this.operatingTime = operatingTime;
    }

    public int getprioritet() {
        return prioritet;
    }
    public ArrayList<Thread> getlist() {
        return thread;
    }
    public String getid() {
        return id;
    }
}
