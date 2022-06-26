public class Car implements Runnable{
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;

    @Override
    public void run() {
        try{
            System.out.println(this.name + " готовится к заезду");
            Thread.sleep(500 + (int)(Math.random()* 800));
            System.out.println(this.name + " на старте");
        } catch (Exception e) {
            e.getStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

    }


    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
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
