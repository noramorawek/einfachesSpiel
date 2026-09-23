import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController {

    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;
    }
}