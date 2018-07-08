package ObjectSync;

/**
 * Created by sachin on 3/6/18.
 */
public class TickectOfc2 implements Runnable {

    private Cinema cinema;
    public TickectOfc2(Cinema cinema){
        this.cinema=cinema;
    }

    @Override
    public void run() {
        cinema.sellTickets2(2);
        cinema.sellTickets2(4);
        cinema.sellTickets1(2);
        cinema.sellTickets1(1);
        cinema.returnTickets2(2);
        cinema.sellTickets1(3);
        cinema.sellTickets2(2);
        cinema.sellTickets1(2);
    }
}
