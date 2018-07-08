package ObjectSync;

/**
 * Created by sachin on 3/6/18.
 */
public class Cinema {

    private long vacancyCinema1;
    private long vacancyCinema2;

    private final Object c1Controller,c2Controller;

    Cinema(){
        c1Controller= new Object();
        c2Controller = new Object();
        vacancyCinema1=20;
        vacancyCinema2=20;
    }



    public boolean sellTickets1 (int number) {
        System.out.println(Thread.currentThread().getName()+" trying to sell "+number);
        synchronized (c1Controller) {
            System.out.println(Thread.currentThread().getName()+" selling now "+number);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (number<vacancyCinema1) {
                vacancyCinema1-=number;
                System.out.println(Thread.currentThread().getName()+" sold "+number);
                return true;
            } else {
                return false;
            }

        }
    }

    public boolean sellTickets2 (int number) {
        synchronized (c2Controller) {
            if (number<vacancyCinema2) {
                vacancyCinema2-=number;
                return true;
            } else {
                return false;
            }
        }
    }


    public boolean returnTickets1 (int number) {
        synchronized (c1Controller) {
            vacancyCinema1+=number;
            return true;
        }
    }

    public boolean returnTickets2 (int number) {
        synchronized (c2Controller) {
            vacancyCinema2+=number;
            return true;
        }
    }


    public long getVacanciesCinema1() {
        return vacancyCinema1;
    }
    public long getVacanciesCinema2() {
        return vacancyCinema2;
    }



}
