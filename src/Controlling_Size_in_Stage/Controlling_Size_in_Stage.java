package Controlling_Size_in_Stage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Controlling_Size_in_Stage extends Application {

    private RadioButton rdoSmall, rdoMedium, rdoLarge;
    private ToggleGroup tgl;
    private TextField txtTest;
    private Label lblMain, lblFont, lblGroup, lblTest;
    private Button btnClose;
    private GridPane root;
    private VBox v1, v2;
    private EventHandler<ActionEvent> OnFontSizeChanged;
    private EventHandler<ActionEvent> OnCloseStage;
    private EventHandler<ActionEvent> filter;

    @Override
    public void init() {
        OnFontSizeChanged = e -> OnFontSizeChanged(e);
        OnCloseStage = e -> OnCloseStage(e);
        filter = e -> OnCloseStage(e);
        lblMain = new Label("<<:GUI Settings:>>");
        lblMain.setFont(new Font(15));
        lblFont = new Label("Set Font Size");
        lblFont.setFont(new Font(15));
        lblGroup = new Label("Group pf Controls");
        lblGroup.setFont(new Font(15));
        lblTest = new Label("Test font size");
        lblTest.setFont(new Font(15));
        lblTest.setTextFill(Color.DARKCYAN);

        tgl = new ToggleGroup();

        rdoSmall = new RadioButton("10");
        rdoSmall.setFont(new Font(15));
        rdoSmall.setToggleGroup(tgl);
        rdoSmall.addEventHandler(ActionEvent.ACTION, OnFontSizeChanged);

        rdoMedium = new RadioButton("15");
        rdoMedium.setFont(new Font(15));
        rdoMedium.setToggleGroup(tgl);
        rdoMedium.setSelected(true);
        rdoMedium.addEventHandler(ActionEvent.ACTION, OnFontSizeChanged);

        rdoLarge = new RadioButton("20");
        rdoLarge.setFont(new Font(15));
        rdoLarge.setToggleGroup(tgl);
        rdoLarge.addEventHandler(ActionEvent.ACTION, OnFontSizeChanged);

        btnClose = new Button("Close Stage");
        btnClose.setFont(new Font(15));
        btnClose.addEventHandler(ActionEvent.ACTION, OnCloseStage);

        txtTest = new TextField("Test font size");
        txtTest.setFont(new Font(15));

//        v1 = new VBox(lblFont, rdoSmall, rdoMedium, rdoLarge);
//        v1.setSpacing(20);
//        v1.setAlignment(Pos.CENTER);
//        v2 = new VBox(lblGroup, txtTest, lblTest, btnClose);
//        v2.setSpacing(15);
//        v2.setAlignment(Pos.CENTER);
        root = new GridPane();
        root.setHgap(35);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        root.add(lblMain, 1, 0);
        root.add(lblFont, 0, 1);
        root.add(rdoSmall, 0, 2);
        root.add(rdoMedium, 0, 3);
        root.add(rdoLarge, 0, 4);
        root.add(lblGroup, 1, 1);
        root.add(txtTest, 1, 2);
        root.add(lblTest, 1, 3);
        root.add(btnClose, 1, 4);
//        root.add(v2, 1, 1);

    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root);

        primaryStage.setTitle("Question 1");
        primaryStage.addEventFilter(ActionEvent.ACTION, filter);
        primaryStage.setWidth(500);
        primaryStage.setHeight(400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void OnFontSizeChanged(ActionEvent e) {
        RadioButton rad = (RadioButton) e.getSource();
        int size = Integer.parseInt(rad.getText());

        for (Node node : root.getChildren()) {
            if (node instanceof Label) {
                Label lbl = (Label) node;
                lbl.setFont(new Font(size));
            } else if (node instanceof TextField) {
                TextField txt = (TextField) node;
                txt.setFont(new Font(size));
            } else if (node instanceof Button) {
                Button btn = (Button) node;
                btn.setFont(new Font(size));
            }
        }
    }

    private void OnCloseStage(ActionEvent e) {

        if (e.getSource() instanceof Stage) {
            Stage stage = (Stage) e.getSource();

            if (e.getTarget() instanceof Button) {
                stage.close();
            }
        }
    }

}
