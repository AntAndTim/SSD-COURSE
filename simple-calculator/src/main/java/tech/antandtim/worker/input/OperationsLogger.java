package tech.antandtim.worker.input;

import java.util.ArrayList;
import java.util.List;
import tech.antandtim.logger.Logger;

public class OperationsLogger implements Logger {

    private final List<String> messages = new ArrayList<>();

    @Override
    public void log(String message) {
        if (messages.size() >= 5) {
            messages.remove(0);
        }
        messages.add(message);
    }

    @Override
    public List<String> getMessages() {
        return messages;
    }
}
