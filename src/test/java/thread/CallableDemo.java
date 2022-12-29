package thread;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        return "successful";
    }
}
