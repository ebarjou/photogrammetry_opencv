package main.ui;

import lang.Text;
import main.ui.calibration.CalibrationPanel;
import main.ui.result.ResultPanel;
import main.ui.selectImages.SelectImagesPanel;
import uiElements.TabbedPane;

public class MainTabbedPane extends TabbedPane{
	/*
	 * Creer un panneau d'onglet avec un loadImagePanel en 1, une CalibrationPanel en 2 et un resultPanel en 3
	 */
	public MainTabbedPane(SelectImagesPanel loadImagePanel, CalibrationPanel calibrationPanel, ResultPanel resultPanel){
		super(new String[]{""+Text.BT_SWITCH_1,""+Text.BT_SWITCH_2,""+Text.BT_SWITCH_3 }, 
				loadImagePanel, calibrationPanel, resultPanel);
	}
	
}
