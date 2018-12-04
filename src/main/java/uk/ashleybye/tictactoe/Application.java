package uk.ashleybye.tictactoe;

import uk.ashleybye.tictactoe.console.ConsoleClient;
import uk.ashleybye.tictactoe.console.IOWrapper;
import uk.ashleybye.tictactoe.console.game.ConsoleGameConfiguration;
import uk.ashleybye.tictactoe.console.game.ConsoleMark;
import uk.ashleybye.tictactoe.console.game.ConsoleMark.ConsoleColour;
import uk.ashleybye.tictactoe.console.game.ConsolePlayerConfiguration;
import uk.ashleybye.tictactoe.console.game.ConsolePlayerFactory;
import uk.ashleybye.tictactoe.console.game.GameConsole;
import uk.ashleybye.tictactoe.console.view.ConfigurePlayerView;
import uk.ashleybye.tictactoe.console.view.MainView;
import uk.ashleybye.tictactoe.console.view.PlayGameView;

public class Application {

  public static void main(String[] args) {
    IOWrapper ioWrapper = new IOWrapper();
    GameConsole gameConsole = new GameConsole(ioWrapper);
    ConsolePlayerFactory playerFactory = new ConsolePlayerFactory(gameConsole);

    ConsolePlayerConfiguration playerOneConfiguration = new ConsolePlayerConfiguration();
    ConsolePlayerConfiguration playerTwoConfiguration = new ConsolePlayerConfiguration();

    playerOneConfiguration.setPlayerMark(new ConsoleMark("X", ConsoleColour.CYAN));
    playerOneConfiguration.setPlayerName("Player 1");
    playerOneConfiguration.setPlayerType(playerFactory.listPlayerTypes().get(0));

    playerTwoConfiguration.setPlayerMark(new ConsoleMark("O", ConsoleColour.YELLOW));
    playerTwoConfiguration.setPlayerName("Player 2");
    playerTwoConfiguration.setPlayerType(playerFactory.listPlayerTypes().get(1));

    ConsoleGameConfiguration gameConfiguration = new ConsoleGameConfiguration();
    gameConfiguration.addPlayerConfiguration(1, playerOneConfiguration);
    gameConfiguration.addPlayerConfiguration(2, playerTwoConfiguration);
    gameConfiguration.setEmptyMark(ConsoleMark.emptyMark());

    MainView mainMenu = new MainView(gameConfiguration, ioWrapper);
    ConfigurePlayerView configurePlayerOneMenuItem = new ConfigurePlayerView(
        mainMenu, gameConfiguration, 1, playerFactory, ioWrapper);
    ConfigurePlayerView configurePlayerTwoMenuItem = new ConfigurePlayerView(
        mainMenu, gameConfiguration, 2, playerFactory, ioWrapper);
    PlayGameView playGameMenuItem = new PlayGameView(
        mainMenu, gameConfiguration, playerFactory, gameConsole, ioWrapper);
    mainMenu.setConfigurePlayerOneView(configurePlayerOneMenuItem);
    mainMenu.setConfigurePlayerTwoView(configurePlayerTwoMenuItem);
    mainMenu.setPlayGameView(playGameMenuItem);

    ConsoleClient consoleClient = new ConsoleClient(mainMenu, ioWrapper);
    consoleClient.start();
  }
}
