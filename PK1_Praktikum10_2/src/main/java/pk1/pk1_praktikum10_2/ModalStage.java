package pk1.pk1_praktikum10_2;

import javafx.stage.Modality;
import javafx.stage.Stage;


public abstract class ModalStage extends Stage{
   public ModalStage(Stage primaryStage){
       super();
       this.initOwner(primaryStage);
       this.initModality(Modality.WINDOW_MODAL);
   }
   
   
}
