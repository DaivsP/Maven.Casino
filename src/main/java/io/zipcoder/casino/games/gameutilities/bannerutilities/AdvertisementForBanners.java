package io.zipcoder.casino.games.gameutilities.bannerutilities;

import static io.zipcoder.casino.games.gameutilities.bannerutilities.AnsiScapeCodes.*;

public class AdvertisementForBanners {


    public static final String SETDEFAULT = ANSI_RESET + "\n";
    private String setColorCasino = ANSI_GREEN;
    private String setColorBlackJack = ANSI_CYAN;
    private String setColorCraps = ANSI_BLUE;
    private String setColorGoFish = ANSI_RED;
    private String setColorHighLow = ANSI_GREEN;
    private String setColorOutOfFunds = ANSI_PURPLE;

     private String casinoStr = setColorCasino + "******************************************* WELCOME TO THE ****************************************************" + SETDEFAULT
             + ANSI_RED + " /$$$$$$$         /$$$$$$ /$$$$$$$$/$$$$$$ /$$$$$$$         /$$$$$$  /$$$$$$  /$$$$$$ /$$$$$$/$$   /$$ /$$$$$$ " + SETDEFAULT
            + ANSI_BLUE + "| $$____/        /$$__  $|__  $$__/$$__  $| $$__  $$       /$$__  $$/$$__  $$/$$__  $|_  $$_| $$$ | $$/$$__  $$" + SETDEFAULT
            + ANSI_CYAN + "| $$$$$$$       |  $$$$$$   | $$ | $$$$$$$| $$$$$$$/      | $$     | $$$$$$$|  $$$$$$  | $$ | $$ $$ $| $$  | $$" + SETDEFAULT
            + ANSI_PURPLE + "|_____  $$       \\____  $$  | $$ | $$__  $| $$__  $$      | $$     | $$__  $$\\____  $$ | $$ | $$  $$$| $$  | $$" + SETDEFAULT
            + ANSI_YELLOW + " /$$  \\ $$       /$$  \\ $$  | $$ | $$  | $| $$  \\ $$      | $$    $| $$  | $$/$$  \\ $$ | $$ | $$\\  $$| $$  | $$" + SETDEFAULT
            + ANSI_RED + "|  $$$$$$/      |  $$$$$$/  | $$ | $$  | $| $$  | $$      |  $$$$$$| $$  | $|  $$$$$$//$$$$$| $$ \\  $|  $$$$$$/" + SETDEFAULT
            + ANSI_BLUE + " \\______/        \\______/   |__/ |__/  |__|__/  |__/       \\______/|__/  |__/\\______/|______|__/  \\__/\\______/ " + SETDEFAULT
            + ANSI_GREEN + "************************************** PLEASE GAMBLE RESPONSIBLY **********************************************" + SETDEFAULT
            + ANSI_RESET + "   \n" + SETDEFAULT ;

    private String blackJackStr = setColorBlackJack + "******************************** LETS PLAY SOME **********************************" + SETDEFAULT
            + setColorBlackJack + " /$$$$$$$ /$$       /$$$$$$  /$$$$$$ /$$   /$$   /$$$$$ /$$$$$$  /$$$$$$ /$$   /$$" + SETDEFAULT
            + setColorBlackJack + "| $$__  $| $$      /$$__  $$/$$__  $| $$  /$$/  |__  $$/$$__  $$/$$__  $| $$  /$$/" + SETDEFAULT
            + setColorBlackJack + "| $$  \\ $| $$     | $$  \\ $| $$  \\__| $$ /$$/      | $| $$  \\ $| $$  \\__| $$ /$$/ " + SETDEFAULT
            + setColorBlackJack + "| $$$$$$$| $$     | $$$$$$$| $$     | $$$$$/       | $| $$$$$$$| $$     | $$$$$/  " + SETDEFAULT
            + setColorBlackJack + "| $$__  $| $$     | $$__  $| $$     | $$  $$  /$$  | $| $$__  $| $$     | $$  $$  " + SETDEFAULT
            + setColorBlackJack + "| $$  \\ $| $$     | $$  | $| $$    $| $$\\  $$| $$  | $| $$  | $| $$    $| $$\\  $$ " + SETDEFAULT
            + setColorBlackJack + "| $$$$$$$| $$$$$$$| $$  | $|  $$$$$$| $$ \\  $|  $$$$$$| $$  | $|  $$$$$$| $$ \\  $$" + SETDEFAULT
            + setColorBlackJack + "|_______/|________|__/  |__/\\______/|__/  \\__/\\______/|__/  |__/\\______/|__/  \\__/" + SETDEFAULT
            + setColorBlackJack + "************************** WHERE IS THAT DRINK WAITER??? *************************" + SETDEFAULT
            + "   \n";

    private String crapsStr = setColorCraps + "****************************************** LETS PLAY SOME ****************************************" + SETDEFAULT
            + setColorCraps + "              _______.      /$$$$$$ /$$$$$$$  /$$$$$$ /$$$$$$$  /$$$$$$               _______." + SETDEFAULT
            + setColorCraps + "   ______    | .   . |\\    /$$__  $| $$__  $$/$$__  $| $$__  $$/$$__  $$   ______    | .   . |\\" + SETDEFAULT
            + setColorCraps + "  /     /\\   |   .   |.\\  | $$  \\__| $$  \\ $| $$  \\ $| $$  \\ $| $$\\__/    /     /\\   |   .   |.\\" + SETDEFAULT
            + setColorCraps + " /  '  /  \\  | .   . |.'| | $$     | $$$$$$$| $$$$$$$| $$$$$$$|  $$$$$$  /  '  /  \\  | .   . |.'|" + SETDEFAULT
            + setColorCraps + "/_____/. . \\ |_______|.'| | $$     | $$__  $| $$__  $| $$____/ \\____  $$/_____/. . \\ |_______|.'|" + SETDEFAULT
            + setColorCraps + "\\ . . \\    /  \\ ' .   \\'| | $$    $| $$  \\ $| $$  | $| $$      /$$  \\ $$\\ . . \\    /  \\ ' .   \\'|" + SETDEFAULT
            + setColorCraps + " \\ . . \\  /    \\____'__\\| |  $$$$$$| $$  | $| $$  | $| $$     |  $$$$$$/ \\ . . \\  /    \\____'__\\|" + SETDEFAULT
            + setColorCraps + "  \\_____\\/                 \\______/|__/  |__|__/  |__|__/      \\______/   \\_____\\/" + SETDEFAULT
            + setColorCraps + "********************************** HOW THE HELL DO YOU PLAY THIS??? ******************************" + SETDEFAULT
            + " \n";

    private String goFishStr = setColorGoFish + "************************************** LETS PLAY SOME *********************************"  + SETDEFAULT
            + setColorGoFish + "                /$$$$$$  /$$$$$$        /$$$$$$$$/$$$$$$ /$$$$$$ /$$   /$$      |\\    o" + SETDEFAULT
            + setColorGoFish + "     |\\    o   /$$__  $$/$$__  $$      | $$_____|_  $$_//$$__  $| $$  | $$     |  \\    o" + SETDEFAULT
            + setColorGoFish + "    |  \\    o | $$  \\__| $$  \\ $$      | $$       | $$ | $$  \\__| $$  | $$ |\\ /    .\\ o" + SETDEFAULT
            + setColorGoFish + "|\\ /    .\\ o  | $$ /$$$| $$  | $$      | $$$$$    | $$ |  $$$$$$| $$$$$$$$ | |       (" + SETDEFAULT
            + setColorGoFish + "| |       (   | $$|_  $| $$  | $$      | $$__/    | $$  \\____  $| $$__  $$ |/ \\     /" + SETDEFAULT
            + setColorGoFish + "|/ \\     /    | $$  \\ $| $$  | $$      | $$       | $$  /$$  \\ $| $$  | $$     |  /" + SETDEFAULT
            + setColorGoFish + "    |  /      |  $$$$$$|  $$$$$$/      | $$      /$$$$$|  $$$$$$| $$  | $$      |/" + SETDEFAULT
            + setColorGoFish + "     |/        \\______/ \\______/       |__/     |______/\\______/|__/  |__/" + SETDEFAULT
            + setColorGoFish + "************************************** CHOOSE WISELY *********************************" + SETDEFAULT
            + " \n";
    private String highLowStr = setColorHighLow + "************************************* LETS PLAY SOME ***********************************" + SETDEFAULT
            + setColorHighLow + " /$$   /$$/$$$$$$ /$$$$$$ /$$   /$$             /$$       /$$       /$$$$$$ /$$      /$$" + SETDEFAULT
            + setColorHighLow + "| $$  | $|_  $$_//$$__  $| $$  | $$            /$$/      | $$      /$$__  $| $$  /$ | $$" + SETDEFAULT
            + setColorHighLow + "| $$  | $$ | $$ | $$  \\__| $$  | $$           /$$/       | $$     | $$  \\ $| $$ /$$$| $$" + SETDEFAULT
            + setColorHighLow + "| $$$$$$$$ | $$ | $$ /$$$| $$$$$$$$          /$$/        | $$     | $$  | $| $$/$$ $$ $$" + SETDEFAULT
            + setColorHighLow + "| $$__  $$ | $$ | $$|_  $| $$__  $$         /$$/         | $$     | $$  | $| $$$$_  $$$$" + SETDEFAULT
            + setColorHighLow + "| $$  | $$ | $$ | $$  \\ $| $$  | $$        /$$/          | $$     | $$  | $| $$$/ \\  $$$" + SETDEFAULT
            + setColorHighLow + "| $$  | $$/$$$$$|  $$$$$$| $$  | $$       /$$/           | $$$$$$$|  $$$$$$| $$/   \\  $$" + SETDEFAULT
            + setColorHighLow + "|__/  |__|______/\\______/|__/  |__/      |__/            |________/\\______/|__/     \\__/" + SETDEFAULT
            + setColorHighLow + "********************************* WHO CAN GET HIGHER??? ********************************" + SETDEFAULT
            + " \n";
    private String outOfFundsStr = setColorOutOfFunds + "******************************** YOU ARE OUT OF FUNDS ******************************" + SETDEFAULT
            + setColorOutOfFunds + "  __  _.-\"` `'-.                                                          _.-\"` `'-." + SETDEFAULT
            + setColorOutOfFunds + " /||\\'._ __{}_(    _______  ______ _   _ ____  _____   __  __ _____      '._ __{}_(" + SETDEFAULT
            + setColorOutOfFunds + " ||||  |'--.__\\   | ____\\ \\/ / ___| | | / ___|| ____| |  \\/  | ____|       |'--.__\\" + SETDEFAULT
            + setColorOutOfFunds + " |  L.(   ^_\\^    |  _|  \\  / |   | | | \\___ \\|  _|   | |\\/| |  _|        (   ^_\\^" + SETDEFAULT
            + setColorOutOfFunds + " \\ .-' |   _ |    | |___ /  \\ |___| |_| |___) | |___  | |  | | |___        |   _ |" + SETDEFAULT
            + setColorOutOfFunds + " | |   )\\___/     |_____/_/\\_\\____|\\___/|____/|_____| |_|  |_|_____|       )\\___/" + SETDEFAULT
            + setColorOutOfFunds + " |  \\-'`:._]                                                           .--'`:._]" + SETDEFAULT
            + setColorOutOfFunds + " \\__/;      '-.                                                       /  \\      '-." + SETDEFAULT
            + setColorOutOfFunds + "**************************** PLEASE BUY MORE CHIPS OR GTFO *************************" + SETDEFAULT
            + " \n";

    public String getCasinoStr(){
        return this.casinoStr;
    }

    public String getBlackJackStr(){
        return this.blackJackStr;
    }

    public String getCrapsStr(){
        return this.crapsStr;
    }

    public String getGoFishStr() {
        return this.goFishStr;
    }

    public String getHighLowStr() { return this.highLowStr; }

    public String getOutOfFundsStr(){
        return this.outOfFundsStr;
    }

}
