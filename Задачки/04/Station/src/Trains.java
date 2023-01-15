public class Trains {

    public static void main(String[] args) {
        InputRoad Road = new InputRoad();       // Создаем и запускаем Генератор поездов
        Road.start();                           //

        Sorting Sort = new Sorting(Road,5);// Создаем и запускаем Сортировщик поездов
        Sort.start();                           //

        for (int i = 1; i <= 3; i++){           // Создаем и запускаем три Станции поездов
            new Uploader(i, i, Sort).start();   // (по одной на каждый тип поезда)
        }                                       //
    }
    // Смысл программы:
    // - Есть поезд - у него есть тип груза (от 1 до 3), длина (от 3 до 8) и имя (зависит от кол-ва поездов)
    // - Есть пять потоков - Генератор, Сортировщик и три Станции поездов
    //   - Генератор построен по типу очереди (FIFO)
    //     В нем может быть от 0 до 10 поездов
    //     При запуске он набирает кол-во поездов до 10, после этого они отправляются в Сортировщик
    //   - Сортировщик вызывает поезда из генератора (по сути просто буфер)
    //   - Станции забирают поезда из Сортировщика, если поезда нужного типа нет, то Станция ждет
    //     пока он там появится
    //     На станции поезд стоит время, зависящее от длины поезда
    // Условий завершения нет
}
