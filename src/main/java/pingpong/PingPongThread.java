package pingpong;

public class PingPongThread extends Thread {

    private Output output;
    private OutputMode outputMode;

    public PingPongThread(OutputMode outputMode, Output output) {
        this.output = output;
        this.outputMode = outputMode;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {

            try {
                sleep(200);
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }

            output.print(outputMode);
        }

        output.wakeUpThreads();
    }
}
