package ObjectSync;

import org.junit.Test;

/**
 * Created by sachin on 3/6/18.
 */
public class main {

    //sub object syncronizations

    public static void main(String[] args) {

        Cinema cinema=new Cinema();
        TickectOfc2 ofc2 = new TickectOfc2(cinema);
        TickerOFc ofc = new TickerOFc(cinema);
        new Thread(ofc).start();
        new Thread(ofc2).start();

/*
        System.out.printf("Room 1 Vacancies: %d\n",cinema.
                getVacanciesCinema1());
        System.out.printf("Room 2 Vacancies: %d\n",cinema.
                getVacanciesCinema2());
*/
    }

}
