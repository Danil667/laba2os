public class Thread {
    private String id;
    private int operatingTime;
    private int priorPr;
    private String pid;
    public Thread(String id, int operatingTime, int priorPr, String p) {
        this.id = id;
        this.pid = p;
        this.operatingTime = operatingTime;
        this.priorPr=priorPr;
    }
    public int getOperatingTime() {
        return operatingTime;
    }
    public int getprioritet() {
        return priorPr;
    }
    public String getId() {
        return id;
    }
    public String getpid() {
        return pid;
    }
    public boolean isTime() {
        if (operatingTime <= 0) {
            return false;
        }
        return true;
    }
    public void minusTime(){
        operatingTime--;
    }
}