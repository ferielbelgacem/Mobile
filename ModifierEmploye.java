/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.ImageViewer;
import static com.codename1.io.Log.p;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
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
import com.mycompany.myapp.entities.Employe;
import com.mycompany.myapp.services.ServiceEmploye;

/**
 *
 * @author ferie
 */
public class ModifierEmploye extends Form {
    private  Resources theme;
    public ModifierEmploye(){
    setTitle("Modifier ma candidature");
        setLayout(BoxLayout.y());
        theme = UIManager.initFirstTheme("/theme");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
            Image im2 = theme.getImage("employe.png");
            ImageViewer img2 = new ImageViewer(im2);
        Button btnValider = new Button("S'inscrire");
      
          TextField tfid= new TextField("","id");
        tfid.getAllStyles().setBgColor(ColorUtil.CYAN);
       TextField tfnom= new TextField("","nom");
        tfnom.getAllStyles().setBgColor(ColorUtil.CYAN);

       TextField tfprenom= new TextField("","prenom");
    ComboBox<String> rolef = new ComboBox();
        rolef.addItem("Responsable RH");
        
                rolef.addItem("Enseignant");

        
      TextField tfrole= new TextField("","role");                      

      TextField tfage= new TextField("","age");
  
                 rolef.getAllStyles().setBgColor(ColorUtil.CYAN);
           
      TextField nbrConge= new TextField("","nbrConge");
    nbrConge.getAllStyles().setBgColor(ColorUtil.CYAN);
      TextField tfNbr_heure= new TextField("","nbrHeure");
        TextField tfsalaire= new TextField("","salaire");
    TextField tfprime= new TextField("","prime");
    tfprime.getAllStyles().setBgColor(ColorUtil.CYAN);
        
        
        Button btnModif = new Button("Modifier");
        
        btnModif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfnom.getText().length()==0)||(tfprenom.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                                                Employe t = new Employe(Integer.parseInt(tfid.getText()),tfprenom.getText(), tfnom.getText(),Integer.parseInt(tfage.getText()),rolef.getSelectedItem(),Integer.parseInt(tfNbr_heure.getText()),Integer.parseInt(nbrConge.getText()),Integer.parseInt(tfsalaire.getText()),Integer.parseInt(tfprime.getText()));

                        if( ServiceEmploye.getInstance().ModifierTask(t))
                            Dialog.show("Succès","Votre Employé a été modifiée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
                
    }
        
    
    
    
    
}
