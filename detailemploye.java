/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Employe;
import com.mycompany.myapp.services.ServiceEmploye;

/**
 *
 * @author ferie
 */
public class detailemploye  extends Form {
                                    private Form current;
    private  Resources theme;
  public detailemploye(Employe  e) {
        theme = UIManager.initFirstTheme("/theme");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
            Image im2 = theme.getImage("employe.png");
            ImageViewer img2 = new ImageViewer(im2);
                                       Label id = new Label();

                           Label prenom = new Label();
                         Label nom = new Label();
                         Label role = new Label();
                         Label salaire = new Label();
                         Label prime = new Label();
                         Label nbrConge = new Label();
                         Label nbrHeure = new Label();
                         Label age = new Label();
                         TextField tfid= new TextField("","id");
        tfid.getAllStyles().setBgColor(ColorUtil.CYAN);
         TextField tfnom= new TextField("","nom");
        tfnom.getAllStyles().setBgColor(ColorUtil.CYAN);

      TextField tfprenom= new TextField("","prenom");
          tfprenom.getAllStyles().setBgColor(ColorUtil.CYAN);

    ComboBox<String> rolef = new ComboBox();
        rolef.addItem("Responsable RH");
        
                rolef.addItem("Enseignant");                     

     TextField tfage= new TextField("","age");
     TextField tfrole= new TextField("","role");

                            tfrole.getAllStyles().setBgColor(ColorUtil.CYAN);

               tfage.getAllStyles().setBgColor(ColorUtil.CYAN);

    TextField nbrCongee= new TextField("","nbrConge");
    nbrConge.getAllStyles().setBgColor(ColorUtil.CYAN);
   TextField tfNbr_heure= new TextField("","nbrHeure");
   TextField tfsalaire= new TextField("","salaire");
   TextField tfprime= new TextField("","prime");
    tfprime.getAllStyles().setBgColor(ColorUtil.CYAN);
        tfsalaire.getAllStyles().setBgColor(ColorUtil.CYAN);
            tfNbr_heure.getAllStyles().setBgColor(ColorUtil.CYAN);
    nbrCongee.getAllStyles().setBgColor(ColorUtil.CYAN);
   

    id.setText(e.getPrenom_condidat());
                         prenom.setText(e.getPrenom_condidat());
                         nom.setText(e.getNom_condidat());
                         age.setText(String.valueOf(e.getAge()));
                         role.setText(e.getRole());
                         salaire.setText(String.valueOf(e.getSalaire()));
                         prime.setText(String.valueOf(e.getPrime()));
                         nbrConge.setText(String.valueOf(e.getNbr_conge()));
                         nbrHeure.setText(String.valueOf(e.getNbr_heure()));
                           Button btsup = new Button("supprimer");
                                 Button btmod = new Button("modifier");

                           btsup.addActionListener((evt) -> {
                                try {
                             if( ServiceEmploye.getInstance().supprimerTask(e.getId()))
                            Dialog.show("Succès","L'employé a été supprimé",new Command("OK"));
                            else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                             } catch (NumberFormatException ex) {
                                 Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                            }
                                                               new ListEmploye(current).show();

                           });
                                                    Button btnValider = new Button("valider");

                            btmod.addActionListener((evt) -> {
tfprenom.setText(e.getPrenom_condidat());
                         tfnom.setText(e.getNom_condidat());
                         tfage.setText(String.valueOf(e.getAge()));
                         tfrole.setText(e.getRole());
                    
                         tfsalaire.setText(String.valueOf(e.getSalaire()));
                         tfprime.setText(String.valueOf(e.getPrime()));
                         nbrCongee.setText(String.valueOf(e.getNbr_conge()));
                         tfNbr_heure.setText(String.valueOf(e.getNbr_heure()));
                                 addAll(tfprenom,tfnom,tfage,tfrole,tfNbr_heure,nbrCongee,tfsalaire,tfprime,btnValider);
                                refreshTheme();
                            });
                            
                           btnValider.addActionListener(new ActionListener() {
                                @Override
                                 public void actionPerformed(ActionEvent evt) {
                if ((tfnom.getText().length()==0)||(tfprenom.getText().length()==0 ))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                      try {
                                                  Employe t = new Employe(e.getId(),tfprenom.getText(), tfnom.getText(),Integer.parseInt(tfage.getText()),rolef.getSelectedItem(),Integer.parseInt(tfNbr_heure.getText()),Integer.parseInt(nbrConge.getText()),Integer.parseInt(tfsalaire.getText()),Integer.parseInt(tfprime.getText()));

                        if( ServiceEmploye.getInstance().ModifierTask(t))
                            Dialog.show("Succès","L'employé a été modifié",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                    
                }
                
                 new ListEmploye(current).show();
            }
                   
                           });
                           this.add(im2);
                         this.addAll(nom,prenom,age,role,salaire,prime,nbrConge,nbrHeure,btsup,btmod);


  }
}
