package by.epam.makarevich.state;

import by.epam.makarevich.entity.Van;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public enum VanState {
    LOADING(1, 4),
    UNLOADING_PERISHABLE(0, 2),
    UNLOADING(1, 6);
    private static final Logger LOG = Logger.getLogger(VanState.class);
    private int urgent;
    private int servicingTime;

    VanState(int urgent, int servicingTime) {
        this.urgent = urgent;
        this.servicingTime = servicingTime;
    }

    public void vanState(Van van) {
        try {
            TimeUnit.SECONDS.sleep(this.servicingTime);
            LOG.info(van.toString() + "was arrived");
        } catch (InterruptedException e) {
            LOG.error(van.toString() + " can't arrived");
        }
    }

    public int getUrgent() {
        return this.urgent;
    }
}
