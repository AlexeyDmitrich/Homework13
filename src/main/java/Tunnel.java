import java.util.concurrent.Semaphore;

public class Tunnel extends Stage{
    Semaphore open = new Semaphore(MainClass.CARS_COUNT / 2);
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
try {
    try{
        System.out.println(c.getName() + " готовится к этапу " + description);
        open.acquire();
        System.out.println(c.getName() + " начал этап " + description);
        Thread.sleep(length / c.getSpeed() * 1000L);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    finally {
        System.out.println(c.getName() + " закончил этап " + description);
        open.release();
    }
} catch (Exception e) {
    e.printStackTrace();
}
    }
}
