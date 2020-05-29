import java.util.ArrayList;
import java.util.List;

public class Plan {
    private ArrayList<Thread> threads = new ArrayList<>();
    public static final int QUANT = 5;
    public Plan(ArrayList<Process> processes) {
        for (int i=0; i < processes.size(); i++)
        {
            List<Thread> potok= processes.get(i).getlist();
            for (var t : potok)
            {
                threads.add(t);
            }
        }

    }

    public void startP(int quant) {
        while (!threads.isEmpty()) {
            for (int i = 0; i < threads.size(); i++) {
                quant = QUANT;
                while (threads.get(i).isTime() && quant > 0) {
                    print(" в процессе",i);
                    threads.get(i).minusTime();
                    quant--;
                    if (quant == 0 && threads.get(i).getOperatingTime() != 0) {
                        print(" приостановлен",i);
                        System.out.println();
                        --i;

                        break;
                    }
                    if (threads.get(i).getOperatingTime() == 0) {
                        print(" завершен",i);
                        System.out.println();
                        threads.remove(i);
                        --i;
                        break;
                    }
                }
            }
        }
    }
    public void print() {
        for (Thread t : threads) {
            System.out.println(t.getpid() + " " + t.getId() + " Приоритет: "
                    + t.getprioritet() + " Время: " + t.getOperatingTime());
        }
    }
    public void print(String str,int i){
        System.out.println(threads.get(i).getpid() + " "
                + threads.get(i).getId() + " Приоритет: "
                + threads.get(i).getprioritet() + " Время: "
                + threads.get(i).getOperatingTime()
                + str);
    }

}
