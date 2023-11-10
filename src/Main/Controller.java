package Main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//import javax.imageio.ImageIO;

public class Controller {
    private List<Car> cars = new ArrayList<>();
    private Game game;
    private int carCount = 3; 

    public Controller(Game game) {
        this.game = game;
        createRandomCars(100, 170, 110, 5);
        createRandomCars(600, 530, 30, -5);
        createRandomCars(100, 435, 110, 3);
        createRandomCars(600, 260, 30, -3);
    }

    private void createRandomCars(int x, int y, int carSpacing, int speed) {
        String[] carImageOptionsRight = {"c1", "c3"};
        String[] carImageOptionsLeft = {"c2", "c4"};
        Random rand = new Random();
    	for (int i = 0; i < carCount; i++) {
            String[] carImageOptions = speed > 0 ? carImageOptionsRight : carImageOptionsLeft;
            String randomCarImage = carImageOptions[rand.nextInt(carImageOptions.length)];
            Car car = new Car(x, y, game, randomCarImage, speed);
            cars.add(car);
            x += 167 + carSpacing;
        }
    }

    public void tick() {
        for (Car car : cars) {
            car.tick();
        }
    }

    public void render(Graphics g) {
        for (Car car : cars) {
            car.render(g);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
    
    public void stopCars() {
        for (Car car : cars) {
            car.setSpeed(0);
        }
    }
    
    

}
