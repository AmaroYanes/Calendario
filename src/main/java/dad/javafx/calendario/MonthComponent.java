package dad.javafx.calendario;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MonthComponent extends BorderPane implements Initializable {
	
	//model
	private ListProperty<Label> dias = new SimpleListProperty<Label>(FXCollections.observableArrayList());
	private IntegerProperty monthProperty = new SimpleIntegerProperty();
	private IntegerProperty yearProperty = new SimpleIntegerProperty();
	
	private Label today;

	//view
	
    @FXML
    private BorderPane root;

    @FXML
    private Label mesLabel;

    @FXML
    private Label Label1;

    @FXML
    private Label Label2;

    @FXML
    private Label Label3;

    @FXML
    private Label Label4;

    @FXML
    private Label Label5;

    @FXML
    private Label Label6;

    @FXML
    private Label Label7;

    @FXML
    private Label Label8;

    @FXML
    private Label Label9;

    @FXML
    private Label Label10;

    @FXML
    private Label Label11;

    @FXML
    private Label Label12;

    @FXML
    private Label Label13;

    @FXML
    private Label Label14;

    @FXML
    private Label Label15;

    @FXML
    private Label Label16;

    @FXML
    private Label Label17;

    @FXML
    private Label Label18;

    @FXML
    private Label Label19;

    @FXML
    private Label Label20;

    @FXML
    private Label Label21;

    @FXML
    private Label Label22;

    @FXML
    private Label Label23;

    @FXML
    private Label Label24;

    @FXML
    private Label Label25;

    @FXML
    private Label Label26;

    @FXML
    private Label Label27;

    @FXML
    private Label Label28;

    @FXML
    private Label Label29;

    @FXML
    private Label Label30;

    @FXML
    private Label Label31;

    @FXML
    private Label Label32;

    @FXML
    private Label Label33;

    @FXML
    private Label Label34;

    @FXML
    private Label Label35;

    @FXML
    private Label Label36;

    @FXML
    private Label Label37;

    @FXML
    private Label Label38;

    @FXML
    private Label Label39;

    @FXML
    private Label Label40;

    @FXML
    private Label Label41;

    @FXML
    private Label Label42;

	public MonthComponent(int mes) {
		super();
		setMonthProperty(mes);
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MonthComponentView.fxml"));
			loader.setController(this);
			loader.setRoot(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		dias.addAll(Label1,Label2,Label3,Label4,Label5,Label6,Label7,Label8,Label9,Label10,Label11,Label12,Label13,Label14,Label15,Label16,Label17,Label18,Label19,Label20,Label21,Label22
					,Label23,Label24,Label25,Label26,Label27,Label28,Label29,Label30,Label31,Label32,Label33,Label34,Label35,Label36,Label37,Label38,Label39,Label40,Label41,Label42);
		yearProperty.addListener((o,ov,nv)->{
			YearMonth yearMonthObject = YearMonth.of(yearProperty.getValue(), monthProperty.getValue());
			
			int aux = new GregorianCalendar(yearProperty.getValue(), monthProperty.getValue()-1, 1).get(Calendar.DAY_OF_WEEK)-2;
			if(aux==-1)aux=6;
			
			for (int i = 0; i < dias.getSize(); i++) {
				dias.get().get(i).setText("");	
				if(dias.get().get(i).equals(today)) {
					dias.get().get(i).getStyleClass().remove("today");
				}
			}
			for (int i = aux, j=1 ; j < yearMonthObject.lengthOfMonth()+1; i++,j++) {
				dias.get().get(i).setText(j+"");
				if(LocalDate.now().getYear()==yearProperty.get() && LocalDate.now().getMonthValue() == monthProperty.get() && j == LocalDate.now().getDayOfMonth()) {
					dias.get().get(i).getStyleClass().add("today");
					today=dias.get(i);
				}
			}
			
			switch (monthProperty.getValue()) {
			case 1:
				mesLabel.setText("enero");
				break;
			case 2:
				mesLabel.setText("febrero");
				break;
			case 3:
				mesLabel.setText("marzo");
				break;
			case 4:
				mesLabel.setText("abril");
				break;
			case 5:
				mesLabel.setText("mayo");
				break;
			case 6:
				mesLabel.setText("junio");
				break;
			case 7:
				mesLabel.setText("julio");
				break;
			case 8:
				mesLabel.setText("agosto");
				break;
			case 9:
				mesLabel.setText("septiembre");
				break;
			case 10:
				mesLabel.setText("octubre");
				break;
			case 11:
				mesLabel.setText("noviembre");
				break;
			case 12:
				mesLabel.setText("diciembre");
				break;
			default:
				break;
			}
			
		});
		
	}


	public final IntegerProperty monthPropertyProperty() {
		return this.monthProperty;
	}
	

	public final int getMonthProperty() {
		return this.monthPropertyProperty().get();
	}
	

	public final void setMonthProperty(final int monthProperty) {
		this.monthPropertyProperty().set(monthProperty);
	}
	

	public final IntegerProperty yearPropertyProperty() {
		return this.yearProperty;
	}
	

	public final int getYearProperty() {
		return this.yearPropertyProperty().get();
	}
	

	public final void setYearProperty(final int yearProperty) {
		this.yearPropertyProperty().set(yearProperty);
	}
	

}
