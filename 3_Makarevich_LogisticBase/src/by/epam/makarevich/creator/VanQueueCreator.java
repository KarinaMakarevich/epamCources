package by.epam.makarevich.creator;

import by.epam.makarevich.entity.Van;
import by.epam.makarevich.entity.VanQueue;
import by.epam.makarevich.state.VanState;

import java.util.Random;

public class VanQueueCreator {
    private final int STATE_COUNT = 2;
    private VanQueue vanQueue;

    public VanQueueCreator() {
        vanQueue = new VanQueue();
    }

    public void addVans(int queueSize) {
        Random random = new Random();
        while (queueSize != 0) {
            int randomState = random.nextInt(STATE_COUNT);
            Van van = new Van(queueSize, VanState.values()[randomState]);
            van.start();
            vanQueue.addVan(van);
            queueSize--;
        }
    }
}
