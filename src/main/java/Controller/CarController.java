package Controller;


import View.InputView;
import View.OutputView;
import domain.Car;
import domain.CarList;
import domain.Play;

import java.util.List;

public class CarController {


    static String inputOfCarNames;
    static String inputOfRound;

    public static void start() {
        inputOfCarNames= InputView.receivecarnames();
        List<String> names = Car.nameSplit(inputOfCarNames);
        inputOfRound = InputView.receiveround();
        CarList carList = CarList.form(names);
        int i=0;
        Play play = new Play(carList,Integer.parseInt(inputOfRound));
        while(!play.isGameOver()) {
            OutputView.printcars(play.playOneRound());
        }
        List<String> list = play.getResult();
        OutputView.printwinner(list);
    }
}
