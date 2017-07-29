package by.epam.makarevich.entity;

import by.epam.makarevich.base.Base;
import by.epam.makarevich.exception.TerminalException;
import by.epam.makarevich.state.VanState;
import org.apache.log4j.Logger;

public class Van extends Thread {
    private static final Logger LOG = Logger.getLogger(Van.class);
    private int number;
    private VanState state;

    public Van(int number, VanState state) {
        this.number = number;
        this.state = state;
    }

    public int getStateUrgent() {
        return this.state.getUrgent();
    }


    @Override
    public void run() {
        Terminal terminal = null;
        try {
            terminal = Base.getInstance().captureTerminal();
            state.vanState(this);
            LOG.info(this.toString() + "arrived at terminal " + terminal.getId());
        } catch (TerminalException e) {
            LOG.warn(this.toString() + " can't get a terminal");
        } finally {
            if (terminal != null) {
                LOG.info(this.toString() + " left terminal " + terminal.getId());
                Base.getInstance().leaveTerminal(terminal);
            }
        }
    }

    @Override
    public String toString() {
        return "Van{" +
                "number=" + number +
                ", state=" + state +
                '}';
    }
}
