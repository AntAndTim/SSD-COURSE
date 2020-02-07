package tech.antandtim.handler;

public interface Handler<COMMAND_TYPE> {

    void handle(COMMAND_TYPE command);
}
