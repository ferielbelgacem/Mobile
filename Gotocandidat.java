/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.myapp.gui;

import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Util;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Session;
import com.mycompany.myapp.entities.user;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author ferie
 */
public class Gotocandidat extends Form{
        private Form current;
           private Resources theme;
               user User=Session.getCurrentSession();


    public Gotocandidat(Form previous){
        
   { 
            current = this; //Récupération de l'interface(Form) en cours
        setTitle("Candidature");
        setLayout(BoxLayout.y());

 theme = UIManager.initFirstTheme("/theme");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
            Image im2 = theme.getImage("logo.png");
            ImageViewer img2 = new ImageViewer(im2);
        add(new Label("Veuillez choisir une option"));
      final  Button btnAddTask = new Button("Ajouter une candidature");
        final Button btnsup = new Button("Supprimer ma candidature");
       final Button btnmod=new Button("modifier");
         Button btr=new Button("Vos questions et Vos remarques");

btr.getAllStyles().setBorder(Border.createEmpty());
btr.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);
btnsup.getAllStyles().setBorder(Border.createEmpty());
btnsup.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);
btnmod.getAllStyles().setBorder(Border.createEmpty());
btnmod.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);
btnAddTask.getAllStyles().setBorder(Border.createEmpty());
btnAddTask.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);
        btnAddTask.addActionListener(e -> new AddCandidatForm(current).show());
     
                btnsup.addActionListener(e -> new SupprimerCandidat(current).show());
  btr.addActionListener(ek -> {
       Form hi = new Form("Capture", BoxLayout.y());
hi.setToolbar(new Toolbar());
Style s = UIManager.getInstance().getComponentStyle("Title");
FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_MIC, s);

FileSystemStorage fs = FileSystemStorage.getInstance();
String recordingsDir = fs.getAppHomePath() + "recordings/";
fs.mkdir(recordingsDir);
try {
    for(String file : fs.listFiles(recordingsDir)) {
        MultiButton mb = new MultiButton(file.substring(file.lastIndexOf("/") + 1));
        mb.addActionListener((e) -> {
            try {
                Media m = MediaManager.createMedia(recordingsDir + file, false);
                m.play();
            } catch(IOException err) {
                Log.e(err);
            }
        });
        hi.add(mb);
    }

    hi.getToolbar().addCommandToRightBar("", icon, (ev) -> {
        try {
            String file = Capture.captureAudio();
            if(file != null) {
                SimpleDateFormat sd = new SimpleDateFormat("yyyy-MMM-dd-kk-mm");
                String fileName =sd.format(new Date());
                String filePath = recordingsDir + fileName;
                Util.copy(fs.openInputStream(file), fs.openOutputStream(filePath));
                MultiButton mb = new MultiButton(fileName);
                mb.addActionListener((e) -> {
                    try {
                        Media m = MediaManager.createMedia(filePath, false);
                        m.play();
                    } catch(IOException err) {
                        Log.e(err);
                    }
                });
                hi.add(mb);
                hi.revalidate();
                
            }
        } catch(IOException err) {
            Log.e(err);
        }
    });
} catch(IOException err) {
    Log.e(err);
}
        hi.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

hi.show();

          });

        
        addAll(img2,btnAddTask,btnsup,btr);
  try {
                Session.close();
            } catch (Exception ex) {
                ex.getMessage();
            }
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    
}}
        
}

