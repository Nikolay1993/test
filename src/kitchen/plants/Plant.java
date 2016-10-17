package kitchen.plants;

/**
 * Created by Николай on 09.10.2016.
 *
 *  Класс, описывающий абстрактное растение.
 *
 *  @see kitchen.plants.fruits.Fruit
 *  @see kitchen.plants.vegetables.Vegetable
 */
    public abstract class Plant implements Peellable  {
        protected String color;
        protected double weight;
        protected int ripeness;     //зрелость
        protected boolean isPeeled; //флаг очищенности

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getRipeness() {
            return ripeness;
        }

        public void setRipeness(int ripeness) {
            this.ripeness = ripeness;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public boolean isPeeled() {
            return isPeeled;
        }

        public void setPeeled(boolean peeled) {
            isPeeled = peeled;
        }

        @Override
        public String toString() {
            return String.format("%1$s: цвет - %2$s, вес - %3$.2f, свежесть - %4$d, %5$s",
                    this.getClass().getSimpleName(), color, weight, ripeness,
                    (isPeeled() ? "очищен" : "не очищен"));
        }
    }

