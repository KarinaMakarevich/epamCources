package by.epam.makarevich.base;

import by.epam.makarevich.entity.Terminal;
import by.epam.makarevich.exception.TerminalException;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Base {
    private static final Logger LOG = Logger.getLogger(Base.class);
    private static Base instance;
    private static ReentrantLock lock = new ReentrantLock();
    private static AtomicBoolean instanceReceived = new AtomicBoolean();
    private final int COUNT_OF_TERMINALS = 4;
    private final Semaphore semaphore = new Semaphore(COUNT_OF_TERMINALS, true);
    private final Queue<Terminal> terminals = new LinkedList<>();

    private Base() {
        for (int i = 0; i < COUNT_OF_TERMINALS; i++) {
            terminals.add(new Terminal(i + 1));
        }
    }

    public static Base getInstance() {
        if (!instanceReceived.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new Base();
                    instanceReceived = new AtomicBoolean(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public Terminal captureTerminal() throws TerminalException {
        Terminal terminal;
        try {
            lock.lock();
            semaphore.acquire();
            terminal = terminals.poll();
        } catch (InterruptedException e) {
            throw new TerminalException();
        } finally {
            lock.unlock();
        }
        return terminal;
    }

    public void leaveTerminal(Terminal terminal) {
        terminals.add(terminal);
        semaphore.release();
        LOG.info("Terminal number " + terminal.getId() + " is empty now");
    }
}
