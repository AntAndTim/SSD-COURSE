package tech.antandtim.handler.input;

import tech.antandtim.handler.Handler;
import tech.antandtim.worker.Worker;

public class ConsoleHandler implements Handler<String> {

    private final Worker worker;

    public ConsoleHandler(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void handle(String command) {
        switch (command) {
            case ":stop":
                worker.stop();
                break;
            case ":pause":
                worker.pause();
                break;
            case ":unpause":
                worker.unpause();
                break;
            case ":log":
                worker.showLog();
                break;
        }
    }
}
