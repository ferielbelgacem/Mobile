/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Candidat;
import com.mycompany.myapp.services.ServiceCandidat;

/**
 *
 * @author ferie
 */
public class ModifierForm extends Form {
               private Resources theme;

    public ModifierForm(Form p) {
         setTitle("Modifier ma candidature");
        setLayout(BoxLayout.y());
        theme = UIManager.initFirstTheme("/theme");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
            Image im2 = theme.getImage("unnamed.png");
            ImageViewer img2 = new ImageViewer(im2);
        Button btnValider = new Button("S'inscrire");
        TextField tfCin = new TextField("","cin_Candidat");
                        tfCin.getAllStyles().setBgColor(ColorUtil.CYAN);

       TextField tfAge= new TextField("","age_Candidat");
                               tfAge.getAllStyles().setBgColor(ColorUtil.CYAN);

       TextField tfName= new TextField("","nom_Candidat");
      TextField tfprenom= new TextField("","prenom_Candidat");
      TextField tfExp= new TextField("","experience_Candidat");
                        tfExp.getAllStyles().setBgColor(ColorUtil.CYAN);

        Button btnModif = new Button("Modifier");
        
        btnModif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfName.getText().length()==0)||(tfName.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Candidat t = new Candidat(Integer.parseInt(tfCin.getText()), tfprenom.getText(),tfName.getText(),Integer.parseInt(tfAge.getText()),tfExp.getText());
                        if( ServiceCandidat.getInstance().ModifierTask(t))
                            Dialog.show("Succès","Votre candidature a été modifiée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(img2,tfCin,tfName,tfAge,tfprenom,tfExp,btnModif);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> p.showBack());
                
    }
        
        
}
