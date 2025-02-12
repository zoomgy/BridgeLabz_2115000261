class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head;
    private Process tail;
    private int timeQuantum;

    RoundRobinScheduler(int timeQuantum) {
        this.head = null;
        this.tail = null;
        this.timeQuantum = timeQuantum;
    }

    void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    void removeProcess(int processId) {
        if (head == null) return;
        Process temp = head, prev = null;
        do {
            if (temp.processId == processId) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else {
                    if (temp == head) {
                        head = head.next;
                        tail.next = head;
                    } else if (temp == tail) {
                        prev.next = head;
                        tail = prev;
                    } else {
                        prev.next = temp.next;
                    }
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void executeProcesses() {
        if (head == null) return;
        Process temp = head;
        int totalTime = 0, waitingTime = 0, turnaroundTime = 0, processCount = 0;
        do {
            int executionTime = Math.min(temp.burstTime, timeQuantum);
            System.out.println("Executing Process ID: " + temp.processId + " for " + executionTime + " units");
            temp.burstTime -= executionTime;
            totalTime += executionTime;
            if (temp.burstTime == 0) {
                turnaroundTime += totalTime;
                removeProcess(temp.processId);
            } else {
                temp = temp.next;
            }
            processCount++;
        } while (head != null && temp != head);
        
        System.out.println("Average Waiting Time: " + (waitingTime / (double)processCount));
        System.out.println("Average Turnaround Time: " + (turnaroundTime /(double)processCount));
    }

    void displayProcesses() {
        if (head == null) return;
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class CPUScheduler {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(3);
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        
        System.out.println("Initial Process Queue:");
        scheduler.displayProcesses();
        scheduler.executeProcesses();
    }
}
