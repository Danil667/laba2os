import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Main {
    private static ArrayList<Process> processes = new ArrayList<Process>();
    private static Random rnd = new Random();
    private static int quant = 10;

    public static void main(String[] args) {
        createProcess();
        processInfo();
        startProcess();
    }

    private static void startProcess() {
        boolean flag = processes.isEmpty();
        Collections.sort(processes);
        while (!flag) {
            int sizeProcesses = processes.size();
            for (int i = 0; i < sizeProcesses; i++) {
                if (processes.get(i).isHaveTime()) {
                    if (!processes.get(i).isEmpty()) {
                        processes.get(i).makeProcess(quant);
                    } else {
                        System.out.println("Все потоки "
                                + processes.get(i).getDescription()
                                + "  выполнены");
                        processes.remove(i);
                        sizeProcesses = processes.size();
                        i--;
                    }
                } else {
                    processes.remove(i);
                    sizeProcesses = processes.size();
                    i--;
                }
            }
            if (processes.isEmpty())
                break;
        }
        System.out.println("Все процессы выполнены");
    }

    private static void processInfo() {
        for (int i = 0; i < processes.size(); i++) {
            System.out.println(processes.get(i).getDescription()+ " Приор   "+ processes.get(i).getPrior()
                    + " Потоков: " + processes.get(i).getCountOfThreads());
        }
        System.out.println();
    }

    private static void createProcess() {
        for (int i = 0; i < rnd.nextInt(5) + 1; i++) {
            processes.add(new Process("" + i, rnd.nextInt(50) + 1, rnd.nextInt(50)));
        }
    }
}
