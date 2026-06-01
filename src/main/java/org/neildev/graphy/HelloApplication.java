package org.neildev.graphy;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// It is from a tutorial I was watching

public class HelloApplication extends Application {

    public static final String message = "Hello World ;)";

    private int[][] collisionMap = new int[1280][720];

    private static final int NUM_PARTICLE = 10000;
    private static final Random random = new Random();
    private List<SnowParticle> particles;

    private Canvas canvas;
    private GraphicsContext g;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    private Parent createContent(){
        particles = new ArrayList<>();

        for (int i = 0; i < NUM_PARTICLE; i++) {
        particles.add(new SnowParticle(random.nextInt(1280),0,Duration.millis(i*10)));
        }

        textToPixels();

        var root = new Pane();
        root.setPrefSize(1280,720);

        canvas = new Canvas(1280,720);
        g = canvas.getGraphicsContext2D();
        g.setFill(Color.WHITE);

        root.getChildren().add(canvas);

        var timer = new AnimationTimer(){
            @Override
            public void handle(long now){
                onUpdate();
            }
        };

        timer.start();
        return root;
    }

    private void textToPixels() {
        var params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);

        var text = new Text(message);
        text.setFont(Font.font("JetBrains Mono",100));
        var image=text.snapshot(params ,null);


        for (int y = 0; y < (int) image.getHeight(); y++) {
            for (int x = 0; x < (int) image.getWidth(); x++) {
                var color = image.getPixelReader().getColor(x,y);

                if(!color.equals(Color.TRANSPARENT)) {
                    collisionMap[x + 200][y + 280] = 1;
                }
            }
        }
    }

    private static class SnowParticle{
        int x;
        int y;

        Duration delay;
        double t = 0.0;
        boolean isMoving = true;

        SnowParticle(int x, int y, Duration delay){
            this.x = x;
            this.y = y;
            this.delay = delay;

        }

        void onUpdate(){
            if(!isMoving){
                return;
            }
            t+= 0.016;

            if(t < delay.toSeconds()){
                return;
            }

            x+=random.nextInt(0,4);
            y+=random.nextInt(1,6);

            if(y>= 720){
                x= random.nextInt(1280);
                y=0;
            }
            if(x>=1280){
                x=0;
            }
        }
    }

    private void onUpdate(){
        g.setFill(Color.BLACK);
        g.fillRect(0,0,1280,720);
        g.setFill(Color.WHITE);

//        for (int y = 0; y < 720; y++) {
//            for (int x = 0; x < 1280; x++) {
//                if(collisionMap[x][y] == 1){
//                    g.setFill(Color.BLUE);
//                    g.fillRect(x,y,1,1);
//                }
//            }
//        }

        particles.forEach(p ->{
            if(collisionMap[p.x][p.y] == 1 && random.nextInt(10) == 9 ){
                p.isMoving=false;
            }

            g.setFill(Color.WHITE);
            p.onUpdate();

            g.fillRect(p.x, p.y,1,1);
        });
    }
}
