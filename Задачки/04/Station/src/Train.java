import java.util.Random;
public class Train {
    int Type;    // У поезда есть тип (Задается случайно)
    int Length;  // У поезда есть длина (Задается случайно)
    String Name; // У поезда есть имя (Передается при создании)
    Train(int Index){
        Random randFeatures = new Random();
        Type = randFeatures.nextInt(3) + 1;
        Length = randFeatures.nextInt(8) + 3;
        Name = "Train #" + Index;
        System.out.println("Поезд #" + Index + " создан: Type " + Type + "; Number " + Length); // Уведомление о созданиии поезда
    }
}
