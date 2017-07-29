package by.epam.makarevich.composite;

import by.epam.makarevich.type.ComponentType;

import java.util.ArrayList;

public class SeparableTextPart implements TextPart {
    private ArrayList<TextPart> compositeList;
    private ComponentType typeOfComponent;
    private String value;

    public SeparableTextPart() {
        compositeList = new ArrayList<>();
    }

    public SeparableTextPart(String value, ComponentType typeOfComponent) {
        this.value = value;
        this.typeOfComponent = typeOfComponent;
    }

    @Override
    public void add(TextPart textPart) {
        compositeList.add(textPart);
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public ComponentType getTypeOfComponent() {
        return this.typeOfComponent;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void remove(TextPart textPart) {
        this.compositeList.remove(textPart);
    }

    @Override
    public ArrayList<TextPart> getComponentArray() {
        return this.compositeList;
    }


    @Override
    public String getTextPart() {
        StringBuilder result = new StringBuilder();
        for (TextPart textPart : compositeList) {
            result.append(textPart.getValue());
        }
        return result.toString();
    }
}
