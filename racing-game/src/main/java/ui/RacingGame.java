package ui;

import domain.CarFactory;
import domain.RacingCars;
import domain.Round;
import util.StringUtils;

import java.util.List;

public class RacingGame {

    private RacingCars racingCars;
    private Round round;

    public void run() {
        initializeRace();
        playGame();
    }

    void initializeRace() {
        try {
            List<String> carNames = StringUtils.parseByComma(InputView.getInput());
            racingCars = CarFactory.create(carNames);
            round = new Round(InputView.getTimes());
        } catch (Exception e){
            System.out.println(e.getMessage());
            initializeRace();
        }
    }

    void playGame(){
        while (!round.isEnd()){
            racingCars.move();
            OutputView.printRoundResult(racingCars.getCars());
            round.reduce();
        }
        OutputView.printWinner(racingCars.getWinner());
    }

}
