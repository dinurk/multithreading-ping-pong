package pingpong;

public class Output {

    private static OutputMode currentOutputMode;

    public Output() {
        currentOutputMode = OutputMode.PING;
    }

    synchronized void print(OutputMode threadOutputMode) {

        while(currentOutputMode != threadOutputMode) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println(currentOutputMode.toString());

        if(threadOutputMode == OutputMode.PING) {
            currentOutputMode = OutputMode.PONG;
        }
        else {
            currentOutputMode = OutputMode.PING;
        }

        notify();
    }

    synchronized void wakeUpThreads() {
        notifyAll();
    }
}
