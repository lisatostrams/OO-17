package mandelfx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import mandelmodel.AreaFiller;

/**
 *
 * @author Sjaak Smetsers
 */
public class MandelFX extends Application {

    public static final int GRID_WIDTH = 800, GRID_HEIGHT = 800;    
    private Canvas canvas;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Mandelbrot");
        primaryStage.setScene( makeScene() );
        primaryStage.show();
    }

    private Scene makeScene() {
        canvas = new Canvas(GRID_WIDTH, GRID_HEIGHT);
        AreaFiller areaFiller = new AreaFiller(  );

        areaFiller.fill( canvas );

        Group root = new Group( canvas );
        Scene scene = new Scene(root);
        return scene;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
