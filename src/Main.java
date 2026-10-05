import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isContinue = true;
        while (isContinue) {
            showMenu();
            String option = sc.nextLine();
            switch (option) {
                case "0":
                    isContinue = false;
                    break;
                case "1":
                    addTask();
                    break;
                case "2":
                    break;
                case "3":
                    removeTaskByNumber();
                    break;
                case "4":
                    removeTaskByName();
                    break;
                case "5":
                    removeTaskByKeyWord();
                    break;
                default:
                    System.out.println("Такой команды нет");
            }
            showTask();
        }
    }

    private static void removeTaskByKeyWord() {
        System.out.print("Введите ключевое слово для удаления:");
        String keyword = sc.nextLine();

        Iterator<String> iter = ToDoList.tasks.iterator();
        while (iter.hasNext()) {
            String task = iter.next();
            if (task.contains(keyword)) {
                iter.remove();
            }
        }
    }

    private static void removeTaskByName() {
        System.out.print("Введите задачу для удаления:");
        String task = sc.nextLine();
        if (ToDoList.tasks.contains(task)) {
            ToDoList.tasks.remove(task);
            System.out.println("Удалено!");
        } else {
            System.out.println("Такой задачи нет!");
        }
    }

    private static void removeTaskByNumber() {
        System.out.print("Введите номер для удаления:");
        int number = Integer.parseInt(sc.nextLine()) - 1;
        if (number >= 0 && number < ToDoList.tasks.size()) {
            ToDoList.tasks.remove(number);
            System.out.println("Удалено!");
        } else {
            System.out.println("Такой задачи нет!");
        }
    }

    private static void addTask() {
        System.out.print("Введите название задачи:");
        String task = sc.nextLine();
        ToDoList.tasks.add(task);
        System.out.println("Добавлено!");
    }

    private static void showTask() {
        System.out.println("Ваш список дел:");
        for (int i = 0; i < ToDoList.tasks.size(); i++) {
            System.out.printf("%d.%s\n", i + 1, ToDoList.tasks.get(i));

        }
        System.out.println();
    }


    private static void showMenu() {
        System.out.print("Выберите операцию:\n" +
                "\n" +
                "0. Выход из программы\n" +
                "1. Добавить дело\n" +
                "2. Показать дела\n" +
                "3. Удалить дело по номеру\n" +
                "4. Удалить дело по названию\n" +
                "5. Удалить дело по ключу\n");
    }
}
