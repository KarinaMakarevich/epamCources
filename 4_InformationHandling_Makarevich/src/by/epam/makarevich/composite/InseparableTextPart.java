package by.epam.makarevich.composite;

import by.epam.makarevich.type.ComponentType;

import java.util.ArrayList;

public class InseparableTextPart implements TextPart {
    private String value;
    private ComponentType typeOfComponent;

    public InseparableTextPart(String value, ComponentType typeOfComponent) {
        this.value = value;
        this.typeOfComponent = typeOfComponent;
    }

    @Override
    public void add(TextPart textPart) {
        throw new UnsupportedOperationException(this.getClass().toString());
    }

    @Override
    public String getTextPart() {
        return getValue();
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void remove(TextPart textPart) {
        throw new UnsupportedOperationException(this.getClass().toString());
    }

    @Override
    public ComponentType getTypeOfComponent() {
        return this.typeOfComponent;
    }

    @Override
    public ArrayList<TextPart> getComponentArray() {
        throw new UnsupportedOperationException(this.getClass().toString());
    }
}
