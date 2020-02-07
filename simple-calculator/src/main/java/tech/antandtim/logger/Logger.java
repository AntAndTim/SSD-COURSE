package tech.antandtim.logger;

import java.util.List;

public interface Logger {

    void log(String message);

    List<String> getMessages();
}
