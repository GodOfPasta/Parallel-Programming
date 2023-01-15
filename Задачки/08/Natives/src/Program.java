
public class Program {
    public static void main(String[] args) {
        int potCapacity = 50;                       // Максимальное количество еды в Котле
        int nativeNum = 20;                         // Количество Туземцев
        Pot jamesCook = new Pot(potCapacity);

        for (int i = 0; i < nativeNum; i++){        //
            Native papuas = new Native(jamesCook);  // Создаем и запускаем Туземцев
            papuas.start();                         //
        }                                           //

        MainGuy chief = new MainGuy(jamesCook);     // Создаем и запускаем Шефа
        chief.start();                              //
    }

    // Смысл программы:
    // - Есть племя из N туземцев.
    // - Есть котел, который содержит M порций еды.
    // - Туземцы одновременно и самостоятельно едят из котла.
    // - Если туземец заглядывает в котел и там нет еды, он будит единственного повара и ждет, пока котел не наполнится.
    // - Повар заглядывает в котел и целиком наполняет его, после чего опять ложится спать.
}
