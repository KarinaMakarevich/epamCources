package by.epam.makarevich.action;

import by.epam.makarevich.creator.VanQueueCreator;

public class Launcher {
    public static void main(String[] args) {
        VanQueueCreator vanQueueCreator = new VanQueueCreator();
        vanQueueCreator.addVans(23);
    }
}
