public class Car implements Runnable{
    public static boolean isReady;
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private SynchronizerStart start;
    private SynchronizedFinish finish;

    @Override
    public void run() {
        try{
            System.out.println(this.name + " готовится к заезду");
            Thread.sleep(500 + (int)(Math.random()* 800));
            System.out.println(this.name + " на старте");
            start.ready();
        } catch (Exception e) {
            e.getStackTrace();
        }
    /*    isReady = true;

        do {
        } while (!MainClass.lowStart);
*/
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        finish.finish(name);

    }


    public Car(SynchronizerStart start, SynchronizedFinish finish, Race race, int speed) {
        this.race = race;
        this.speed = speed;
        this.start = start;
        this.finish = finish;
        CARS_COUNT ++ ;
        this.name = "Участник №" + CARS_COUNT;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

}
