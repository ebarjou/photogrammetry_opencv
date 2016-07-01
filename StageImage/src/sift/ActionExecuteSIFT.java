package sift;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import images.exception.ImageException;
import main.ui.selectImages.SelectImagesPanel;
import sift.data.MatchList;
import uiElements.exception.UIException;

public class ActionExecuteSIFT implements ActionListener {
	SelectImagesPanel selectImagesPanel;
	MatchList matchList;
	
	public ActionExecuteSIFT(SelectImagesPanel selectImagesPanel, MatchList matchList) {
		this.selectImagesPanel = selectImagesPanel;
		this.matchList = matchList;
	}

	public void actionPerformed(ActionEvent event) {
		List<String> files = selectImagesPanel.getFiles();
		MatchList.clear();
		if (files.size() < 2)
			throw new UIException("Not enough files loaded", null);
		for(int i = 1; i < files.size(); ++i){
			try {
				popup.setStep("Executing SIFT "+i+"/"+(files.size()-1));
				pointList.add(SIFTDetector.sift(new ImageRGB(files.get(i-1).toString()), new ImageRGB(files.get(i).toString())));//, "D:\\Images\\match_"+i+".png", popup
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		try {
			label_Preview.setAxe(new ImageRGB(files.get(0).toString()).getWidth()/2, new ImageRGB(files.get(0).toString()).getHeight()/2);
		} catch (ImageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		label_Preview.setList(pointList);
		
		popup.close();
	}

}