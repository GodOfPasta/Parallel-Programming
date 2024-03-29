import java.util.concurrent.Exchanger;

public class Program {

    public static void main(String[] args){
        Exchanger<String> ex = new Exchanger<>(); // Потоки будут обмениваться строками
        Jedi ObiWan = new Jedi(ex);
        Sith GeneralGrivus = new Sith(ex);

        ObiWan.start();         // Запускаем два потока
        GeneralGrivus.start();  //
    }
    // Смысл программы:
    // - Встречаются два персонажа - Гривус и Оби-Ван
    // - Они не могут начать говорить, пока не прибудут оба
    // - Для этого используется Exchanger:
    //   - В методе run() обоих потоков присутствует вызов метода exchange(),
    //     который ждет, пока из второго потока не вернется объект нужного класс
    // [Значение, возвращенное из другого потока можно нигде не сохранять -
    //  просто использовать как барьер]
    // [Обмен происходит Только между двумя потоками,
    //  то есть exchanger нельзя использовать для нечетного числа потоков]
    //
}