package constant;

public enum CategoryCards {
    ELEMENTS ("Elements"),
    FORMS ("Forms"),
    ALERTS_FRAME_AND_WINDOWS ("Alerts, Frame & Windows"),
    WIDGETS ("Widgets"),

    INTERACTIONS ("Interactions"),
    BOOK_STORE_APPLICATION("Book Store Application");

    private CategoryCards(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    private String name;





}
