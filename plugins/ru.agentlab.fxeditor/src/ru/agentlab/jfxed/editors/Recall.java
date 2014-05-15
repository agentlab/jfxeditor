package ru.agentlab.jfxed.editors;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class Recall implements Callback<CellDataFeatures<String, String>, ObservableValue<String>> {

	public Recall(){
		System.out.println("RECALL");
	}
	
	SimpleStringProperty p = new SimpleStringProperty("asdafsdf");

	@Override
	public ObservableValue<String> call(CellDataFeatures<String, String> param) {
		// TODO Auto-generated method stub
		return p;
	}

}
