import java.util.*;

public class Main {

    // Максимальное количество пар
    public static final int MAX_PAIRS = 16;
    // Максимальное допустимое количество голосов
    public static final int MAX_VOTES = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Переменная для хранения количества сообщений
        int n;

        // Ввод количества sms с проверкой на ограничение (не больше 100 сообщений)
        do {
            System.out.println("Введите количество пришедших sms-сообщений (не более 100):");
            n = scanner.nextInt();

            if (n > MAX_VOTES) {
                System.out.println("Ошибка: количество сообщений превышает 100. Повторите ввод.");
            }
        } while (n > MAX_VOTES);  // Повторяем, пока не введено корректное количество сообщений

        // Map для подсчета голосов за каждую пару
        Map<Integer, Integer> votes = new HashMap<>();

        // Инициализация голосов для каждой пары
        for (int i = 1; i <= MAX_PAIRS; i++) {
            votes.put(i, 0);  // Вначале за каждую пару 0 голосов
        }

        // Чтение номеров пар из sms-сообщений
        System.out.println("Введите номера пар:");
        for (int i = 0; i < n; i++) {
            int pair = scanner.nextInt();
            if (pair >= 1 && pair <= MAX_PAIRS) {
                // Увеличиваем количество голосов для выбранной пары
                votes.put(pair, votes.get(pair) + 1);
            }
        }

        // Сортируем пары по количеству голосов в порядке убывания
        List<Map.Entry<Integer, Integer>> sortedPairs = new ArrayList<>(votes.entrySet());
        sortedPairs.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Выводим результат
        System.out.println("Результаты голосования:");
        for (Map.Entry<Integer, Integer> entry : sortedPairs) {
            System.out.println("Пара " + entry.getKey() + ": " + entry.getValue() + " голосов");
        }
    }
}
