public class SynchronizerStart {
    private static int CARS_COUNT = MainClass.CARS_COUNT;
    private static int readyCounter = 0;
    public synchronized void ready(){
        try {
            readyCounter++;
            if (readyCounter == CARS_COUNT){
                notifyAll();
                System.out.println("Гонка началась!");
            }
            else {
                wait();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
