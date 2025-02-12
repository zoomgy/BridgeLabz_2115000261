class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head;

    void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position == 1) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        for (int i = 1; temp.next != head && i < position - 1; i++) {
            temp = temp.next;
        }
        newTask.next = temp.next;
        temp.next = newTask;
    }

    void removeTask(int taskId) {
        if (head == null) return;
        if (head.taskId == taskId && head.next == head) {
            head = null;
            return;
        }
        Task temp = head, prev = null;
        while (temp.taskId != taskId) {
            prev = temp;
            temp = temp.next;
            if (temp == head) return;
        }
        if (temp == head) {
            prev = head;
            while (prev.next != head) {
                prev = prev.next;
            }
            head = head.next;
            prev.next = head;
        } else {
            prev.next = temp.next;
        }
    }

    void viewCurrentTask() {
        if (head != null) {
            System.out.println("Task ID: " + head.taskId + ", Name: " + head.taskName + ", Priority: " + head.priority + ", Due Date: " + head.dueDate);
            head = head.next;
        }
    }

    void displayTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    Task searchTaskByPriority(int priority) {
        if (head == null) return null;
        Task temp = head;
        do {
            if (temp.priority == priority) return temp;
            temp = temp.next;
        } while (temp != head);
        return null;
    }
}

public class TaskManagement {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTaskAtEnd(1, "Task A", 2, "2025-01-01");
        scheduler.addTaskAtEnd(2, "Task B", 1, "2025-01-02");
        scheduler.addTaskAtBeginning(3, "Task C", 3, "2025-01-03");
        scheduler.addTaskAtPosition(4, "Task D", 2, "2025-01-04", 2);
        scheduler.displayTasks();
        scheduler.viewCurrentTask();
        scheduler.removeTask(3);
        scheduler.displayTasks();
    }
}

