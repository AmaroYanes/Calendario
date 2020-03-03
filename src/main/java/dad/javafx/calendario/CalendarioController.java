package dad.javafx.calendario;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;

public class CalendarioController implements Initializable {

	
	//vista
	
	@FXML
    private BorderPane root;

    @FXML
    private GridPane gridpane;

    @FXML
    private Button anteriorButton;

    @FXML
    private Button siguienteButton;

    @FXML
    private Label anyoLabel;
    
	private MonthComponent enero,febrero,marzo,abril,mayo,junio,julio,agosto,septiembre,octubre,noviembre,diciembre;




	
	
	//modelo
	
	IntegerProperty year = new SimpleIntegerProperty();


	public CalendarioController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CalendarioView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	public BorderPane getView(){
		return root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		year.set(Calendar.getInstance().get(Calendar.YEAR));
		
		enero = new MonthComponent(1);
		febrero = new MonthComponent(2);
		marzo = new MonthComponent(3);
		abril = new MonthComponent(4);
		mayo = new MonthComponent(5);
		junio = new MonthComponent(6);
		julio = new MonthComponent(7);
		agosto = new MonthComponent(8);
		septiembre = new MonthComponent(9);
		octubre = new MonthComponent(10);
		noviembre = new MonthComponent(11);
		diciembre = new MonthComponent(12);
		
		
		gridpane.add(enero, 0, 0);
		gridpane.add(febrero, 1, 0);
		gridpane.add(marzo, 2, 0);
		gridpane.add(abril, 3, 0);
		gridpane.add(mayo, 0, 1);
		gridpane.add(junio, 1, 1);
		gridpane.add(julio, 2, 1);
		gridpane.add(agosto, 3, 1);
		gridpane.add(septiembre, 0, 2);
		gridpane.add(octubre, 1, 2);
		gridpane.add(noviembre, 2, 2);
		gridpane.add(diciembre, 3, 2);
		
		
		enero.yearPropertyProperty().bind(year);
		febrero.yearPropertyProperty().bind(year);
		marzo.yearPropertyProperty().bind(year);
		abril.yearPropertyProperty().bind(year);
		mayo.yearPropertyProperty().bind(year);
		junio.yearPropertyProperty().bind(year);
		julio.yearPropertyProperty().bind(year);
		agosto.yearPropertyProperty().bind(year);
		septiembre.yearPropertyProperty().bind(year);
		octubre.yearPropertyProperty().bind(year);
		noviembre.yearPropertyProperty().bind(year);
		diciembre.yearPropertyProperty().bind(year);
		
		Bindings.bindBidirectional(anyoLabel.textProperty(), year, new NumberStringConverter("####"));
	}
	
    @FXML
    void OnSiguienteButton(ActionEvent event) {
    	year.set(year.get()+1);
    }

    @FXML
    void onAnteriorButton(ActionEvent event) {
    	year.set(year.get()-1);
    }

}
