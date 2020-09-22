package View;


import domain.Car;
import domain.CarList;

import java.util.List;

public class OutputView {
    static int round=1;
    public static void printwinner(List<String> cars){
        System.out.println("\nWinner is!!");
        for(int i=0;i<cars.size();i++){
            System.out.println(cars.get(i));
        }

    }
    public static void printcars(CarList cars){

        System.out.println("\n");
        System.out.println(round+"round");
        round++;
        for(Car car: cars.getCars()){
            System.out.println("Name: "+car.getName()+" Position: "+car.getPosition());
        }
    }

}
