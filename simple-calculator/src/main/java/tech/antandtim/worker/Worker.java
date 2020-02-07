package tech.antandtim.worker;

public interface Worker {

    default void start() {
        System.out.println("Starting " + this.getClass().getSimpleName());
        doWork();
    }

    /**
     * Returns true if state changed
     */
    boolean pause();

    /**
     * Returns true if state changed
     */
    boolean unpause();

    void stop();

    void doWork();

    boolean isPaused();

    void doActions();

    void showLog();
}
