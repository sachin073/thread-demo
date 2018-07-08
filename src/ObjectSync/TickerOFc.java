package ObjectSync;

/**
 * Created by sachin on 3/6/18.
 */
public class TickerOFc implements Runnable {

    Cinema cinema;
    TickerOFc(Cinema cinema){
        this.cinema=cinema;
    }


    @Override
    public void run() {

        cinema.sellTickets1(3);
        cinema.sellTickets1(2);
        cinema.sellTickets2(2);
        cinema.returnTickets1(3);
        cinema.sellTickets1(5);
        cinema.sellTickets2(2);
        cinema.sellTickets2(2);
        cinema.sellTickets2(2);
    }

}
