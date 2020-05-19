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
public class SupprimerCandidat extends Form{
        Form current ;
                            private Resources theme;

     public SupprimerCandidat(Form p) {
                 setTitle("Supprimer ma candidature");

            setLayout(BoxLayout.y());
                 TextField tfCin = new TextField("Entrez votre N°:CIN","cin_Candidat");
                                 tfCin.getAllStyles().setBgColor(ColorUtil.CYAN);

theme = UIManager.initFirstTheme("/theme");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
            Image im2 = theme.getImage("unnamed.png");
            ImageViewer img2 = new ImageViewer(im2);
    Button btnsupp = new Button("Supprimer");
        btnsupp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                         if ((tfCin.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                                            Candidat t = new Candidat(Integer.parseInt(tfCin.getText()));
 if( ServiceCandidat.getInstance().supprimerTask(t.getCin_Candidat()))
                            Dialog.show("Succès","Votre inscription a été supprimée",new Command("OK"));
                      else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                    
                     

                     }});
                addAll(img2,tfCin,btnsupp);
                        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> p.showBack());

         
     }            
}
