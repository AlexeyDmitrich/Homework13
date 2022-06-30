public class MainClass {
    public static final int CARS_COUNT = 4;
    static boolean lowStart;
    int index;

    public static synchronized void main(String[] args) throws InterruptedException {
        SynchronizerStart  start = new SynchronizerStart();
        SynchronizedFinish finish = new SynchronizedFinish();
        System.out.println(">>> подготовка <<<");
        Race race = new Race( new Road(60), new Tunnel (), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(start, finish, race, 20 + (int) (Math.random()*10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

 /*           for (Car car:cars) {
                do {
                }while (!Car.isReady);
                lowStart = true;
                car.notifyAll();
            }



        System.out.println("<<< Гонка началась >>>");
        finish (cars);
        System.out.println(">>> >>> Гонка кончилась <<< <<<");
*/    }

/*    public static void finish(Car[] cars){
        int finishСounter = 0;
        synchronized (Car.class){
            for (Car car:cars) {
                finishСounter ++;
                System.out.println(car.getName() + " финишировал " + finishСounter + "-м!");
            }
        }
    }    */
}


