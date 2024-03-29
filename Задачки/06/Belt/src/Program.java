public class Program {

    public static void main (String[] args){
        Belt factory = new Belt();
        for (int i = 1; i < 3; i++){
            new InputRobot(i, factory).start();
        }
        new OutputRobot(factory).start();
    }
    // Смысл программы:
    // - Два робота-погрузчика кладут на конвейер детали
    // - Один Разгрузчик их снимает
    // - Если масса деталей > 4000 г
    //      - Конвейер очищается (Просто)
    //      - Два робота снимают две детали (самую легкую и самую тяжелую) каждый
    //        и отправляют их на переработку\в отдел качества соответственно (Сложнее)
    // - Здесь в начале методов конвейера блокируется блок кода, а в блоке finally он разблокируется
    //   Фактически - тот же synchronize, но lock() может начинаться и заканчиваться в разных методах
    // - Состояние здесь нужно только для методов await() и signalAll(), что то же самое, что wait() и notifyAll()
}

