package by.epam.javawebtraining.maksimkosmachev.task04.model.entity;

public class Code implements IUnit {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Code(String code) {
        this.code = code;
    }

    public Code() {

    }

    @Override
    public String getString() {
        return code;
    }
}
