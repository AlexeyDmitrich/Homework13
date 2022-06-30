public class SynchronizedFinish {
    private static int CARS_COUNT = MainClass.CARS_COUNT;
    private static int finishCounter = 0;
    public static synchronized void finish(String name){

        if (finishCounter++ == 0){
            System.out.println("Победил " + name);
//            finishCounter ++ ;
        }
/*        do{
        finishCounter ++ ;
            System.out.println(((int)finishCounter +1) + " место занял " + name);
        } while (finishCounter != CARS_COUNT);
*/        if (finishCounter == CARS_COUNT){
            System.out.println(">>> >>> Гонка кончилась <<< <<<");
        }
    }
}
