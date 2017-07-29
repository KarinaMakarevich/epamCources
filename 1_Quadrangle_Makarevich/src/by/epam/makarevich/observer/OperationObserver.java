package by.epam.makarevich.observer;

import by.epam.makarevich.entity.Quadrilateral;

public abstract class OperationObserver {
    public abstract void valueChanged(Quadrilateral observed);
}