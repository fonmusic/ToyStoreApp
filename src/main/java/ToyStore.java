import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, описывающий игрушечный магазин
 */
public class ToyStore {
    private List<Toy> toys = new ArrayList<>();

    /**
     * Добавляет игрушку в магазин
     *
     * @param toy Игрушка
     */
    public void addToy(Toy toy) {
        toys.add(toy);
    }

    /**
     * Изменяет вес игрушки
     *
     * @param toyId    ID игрушки
     * @param newWeight Новый вес игрушки
     */
    public void changeWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    /**
     * Выбирает игрушку для розыгрыша
     *
     * @return Игрушка
     */
    public Toy drawToy() {
        double random = Math.random() * 100;
        double cumulativeWeight = 0;

        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeight();
            if (random <= cumulativeWeight) {
                Toy selectedToy = new Toy(toy.getId(), toy.getName(), 1, toy.getWeight());
                toy.reduceQuantity();
                return selectedToy;
            }
        }

        return null; // Если не удалось выбрать игрушку
    }

    /**
     * Сохраняет выигранную игрушку в файл
     *
     * @param toy Игрушка
     */
    public void saveWonToyToFile(Toy toy) {
        try {
            FileWriter fileWriter = new FileWriter("won_toys.txt", true); // Открываем файл для добавления (true)
            String data = "ID: " + toy.getId() + ", Название: " + toy.getName() + "\n";
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        Toy toy1 = new Toy(1, "Кукла", 10, 20);
        Toy toy2 = new Toy(2, "Машинка", 5, 30);
        Toy toy3 = new Toy(3, "Мяч", 8, 50);

        toyStore.addToy(toy1);
        toyStore.addToy(toy2);
        toyStore.addToy(toy3);

        toyStore.changeWeight(1, 10); // Изменяем вес первой игрушки
        Toy prizeToy = toyStore.drawToy(); // Розыгрыш
        if (prizeToy != null) {
            System.out.println("Поздравляем! Вы выиграли: " + prizeToy.getName());
            toyStore.saveWonToyToFile(prizeToy);
        }
    }
}
