/**
 * Класс игрушки
 */
public class Toy {
    private int id;
    private String name;
    private int quantity;
    private double weight; // Вес в % от 100

    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    /**
     * Изменяет вес игрушки
     *
     * @param weight Новый вес игрушки
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Уменьшает количество игрушек на 1
     */
    public void reduceQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeight() {
        return weight;
    }
}
