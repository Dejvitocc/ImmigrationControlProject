package View;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import Controller.GuiController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;						//personWithoutValidVisa, studyPlans
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {
	
	private Label label=new Label("Come to the window!");
	private Button callVisitor=new Button("Call visitor");
	private Button pass=new Button("Let pass");
	private Button arrest=new Button("Arrest");
	private TextArea textArea = new TextArea();
	private Label questions=new Label("Questions:");
	private Button endDay=new Button("End the day");
	private Button clear=new Button("Clear text area");
	private Button newDay=new Button("Start new Day");
	
	private Button PersonWithAccomodation =new Button("Do you have booked accomodation?");
	private Button PersonWithDeclaredItems=new Button("Do you have any declared items?");
	private Button PersonWithHealthProblems=new Button("Do you have any health problems?");
	private Button PersonWithStudyPlans=new Button("Did you come here to study?");
	private Button VisaPerson=new Button("Do you have valid visa?");
	private Label timeLabel = new Label();

    private LocalTime baseTime = LocalTime.now(); 
    private int timeIncrement = 0; 
    private boolean first5Seconds=true;


	

    @Override
    public void start(Stage primaryStage) {

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
         
        gridPane.add(label, 1, 0);
        gridPane.add(callVisitor, 0, 0);
        
        GridPane.setConstraints(textArea, 0, 1, 3, 3);
        gridPane.getChildren().add(textArea);
        
        gridPane.add(pass,1,5);
        gridPane.add(arrest,2,5);
        
        gridPane.add(questions, 1, 7);
         
        gridPane.add(PersonWithAccomodation,1,9); 
        gridPane.add(PersonWithDeclaredItems,1,10);
        gridPane.add(PersonWithHealthProblems,1,11);
        gridPane.add(PersonWithStudyPlans,1,12);  
        gridPane.add(VisaPerson,1,13);
         
        gridPane.add(endDay, 0, 14);
        gridPane.add(newDay, 0, 15);
        gridPane.add(clear, 2, 15);
        gridPane.add(timeLabel, 2, 0);

        
        
        callVisitor.setOnAction(e -> { 
        	textArea.appendText(GuiController.callVisitorMethod());
        });
        
        clear.setOnAction(e -> textArea.clear());
        PersonWithHealthProblems.setOnAction(e-> GuiController.displayPersonWithHealthProblems(textArea));
        PersonWithAccomodation.setOnAction(e-> GuiController.displayPersonWithAccomodation(textArea));
        PersonWithDeclaredItems.setOnAction(e-> GuiController.displayPersonWithDeclaredItems(textArea));
        PersonWithStudyPlans.setOnAction(e-> GuiController.displayPersonWithStudyPlans(textArea));
        VisaPerson.setOnAction(e-> GuiController.visaPersonMethod(textArea));
        pass.setOnAction(e-> GuiController.letVisitorPass(textArea));
        arrest.setOnAction(e-> GuiController.letVisitorArrest(textArea));
        endDay.setOnAction(e-> GuiController.displayStatistics(textArea));
        newDay.setOnAction(e-> {
        	textArea.clear(); 
        	GuiController.startNewDay(textArea);
        });

        
        textArea.setPrefRowCount(textArea.getPrefRowCount() * 2);
        Scene scene = new Scene(gridPane, 500, 750);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Immigration Control - One Question Decision");
        primaryStage.show();
        
        Thread timeThread = new Thread(() -> {
            while (true) {
                try {
                	if (first5Seconds) {
                		Thread.sleep(0); 
                		first5Seconds=false;
                	}else Thread.sleep(5000);
                } 
                catch (InterruptedException ex) { 
                	return;
                }
 
                Platform.runLater(() -> {
                    LocalTime newTime = baseTime.plusMinutes(5 * timeIncrement);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                    String formattedTime = newTime.format(formatter);
                    timeLabel.setText("Current time: " + formattedTime);
                    timeIncrement++; 
                });
            }
        }); 

        timeThread.setDaemon(true); //deamon turn off thread when we close app
        timeThread.start();
    }
        
    

    
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
}