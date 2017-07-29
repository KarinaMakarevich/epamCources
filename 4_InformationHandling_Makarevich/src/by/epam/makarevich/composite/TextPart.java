package by.epam.makarevich.composite;

import by.epam.makarevich.type.ComponentType;

import java.util.ArrayList;

public interface TextPart {
    void add(TextPart textPart);

    String getTextPart();

    String getValue();

    void setValue(String value);

    void remove(TextPart textPart);

    ComponentType getTypeOfComponent();

    ArrayList<TextPart> getComponentArray();
}
