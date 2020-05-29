import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ArrayList<Process> processes = new ArrayList<>();
        Random randomNumber = new Random();

        for (int i = 0; i < randomNumber.nextInt(3) + 1; i++) {
            int prioritet = randomNumber.nextInt(5) + 1;
            processes.add(new Process("процесс № " + (i + 1), prioritet));
        }
        Plan c = new Plan(processes);
        c.print();
        System.out.println();
        System.out.println("Result");
        c.startP(Plan.QUANT);
    }
}
