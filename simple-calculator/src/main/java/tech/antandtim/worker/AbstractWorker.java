package tech.antandtim.worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public abstract class AbstractWorker implements Worker {

    protected ExecutorService executorService = Executors.newSingleThreadExecutor();

    protected ReentrantLock lock = new ReentrantLock();

    protected boolean hasToStop = false;

    protected boolean isPaused = false;

    private boolean hasToStop() {
        return hasToStop;
    }

    @Override
    public boolean pause() {
        if (isPaused) {
            return false;
        } else {
            isPaused = true;
            lock.lock();
            return true;
        }
    }

    @Override
    public boolean unpause() {
        if (!isPaused) {
            return false;
        } else {
            isPaused = false;
            lock.unlock();
            return true;
        }
    }

    @Override
    public void stop() {
        hasToStop = true;
        System.out.println("Stopping " + this.getClass().getSimpleName());
    }

    @Override
    public void doWork() {
        executorService.execute(() -> {
            while (!hasToStop()) {
                try {
                    lock.lock();
                    doActions();
                    lock.unlock();
                } catch (Exception ignore) {

                }
            }
        });
    }

    @Override
    public boolean isPaused() {
        return isPaused;
    }
}
