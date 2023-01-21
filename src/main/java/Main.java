import pingpong.Output;
import pingpong.PingPongThread;
import pingpong.OutputMode;

public class Main {
    public static void main(String[] args) {

        Output output = new Output();
        PingPongThread[] pingPongThreads = new PingPongThread[] {
                new PingPongThread(OutputMode.PING, output),
                new PingPongThread(OutputMode.PONG, output)
        };

        for(PingPongThread thread : pingPongThreads) {
            thread.start();
        }

        try {
            for (PingPongThread thread : pingPongThreads) {
                thread.join();
            }
        }
        catch(InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("---------------------------------------------------------");
        System.out.println("\nprogram completed");
    }
}