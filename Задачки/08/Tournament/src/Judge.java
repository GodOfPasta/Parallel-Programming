import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
public class Judge extends Thread{
    private ArrayList<Participant> list;    // Список Участников
    CountDownLatch commonBarrier;           // Счётчик Судьи, который отсчитывает число загадавших число
    int tournamentSize;                     // Количество Участников
    int[] Results;                          // Загаданные числа
    Participant temp;                       // Временная переменная для перебора Участников
    Judge(int party){
        this.tournamentSize = party;
        list = new ArrayList<>();
        Results = new int[party + 1];
        commonBarrier = new CountDownLatch(party);
        System.out.println("Начинаем турнир из " + party + " участников");
        for(int i = 0; i < party; i++){                                     //
            Participant newPlayer = new Participant(i, commonBarrier);      //
            list.add(newPlayer);                                            // Создаем о запускаем столько участников,
            newPlayer.start();                                              // сколько было задано при объявлении Судьи
        }                                                                   //
    }

    public void run() {
        try{
            while(true) {
                commonBarrier.await();                                                      // Судья ждет, пока каждый Участник загадает число

                for (Participant player : list) {                                           //
                    Results[player.getMyFavoriteNumber()]++;                                // Судья узнает ответы от каждого Участника и записывает их в таблицу
                }                                                                           //

                Iterator<Participant> it = list.iterator();                                 // - Итератор для прохождения динамически изменяемого списка
                while (it.hasNext()) {                                                      // - Пока есть следующий элемент
                    temp = it.next();                                                       //   - Запоминаем текущего игрока
                    if(Results[temp.getMyFavoriteNumber()] > 1){                            //   - Если загаданное им число встречается >1 раза
                        System.out.println("Участник " + temp.index + " выбывает");         //     - Этот Участник выбывает
                        temp.newRound(null);                                         //     - Отправляем ему нулевой барьер
                        it.remove();                                                        //     - Убираем его из участников
                    }                                                                       //
                }                                                                           //

                tournamentSize = list.size();                                               // - Обновляем количество участников
                System.out.println("Осталось участников " + tournamentSize);                //
                Results = new int[11];                                                      // - Очищаем загаданные числа
                commonBarrier = new CountDownLatch(tournamentSize);                         // - Обновляем количество участников для барьера

                if(tournamentSize < 3){                                                     // - Если участников осталось <3
                    System.out.println("Турнир завершается");                               //
                    for(Participant player : list){                                         //
                        player.win();                                                       //   - Все оставшиеся объявляются победителями
                    }                                                                       //
                    break;                                                                  //
                }                                                                           //

                System.out.println("Начинаем новый тур");                                   //
                for(Participant player : list){                                             // - Каждому оставшемуся участнику
                    player.newRound(commonBarrier);                                         //   - Передается барьер, что начинает новый раунд
                }                                                                           //
            }
        }catch (InterruptedException e){
            System.out.println("InterruptedException");
            e.printStackTrace();
        }
    }
}
