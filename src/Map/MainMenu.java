
public class MainMenu {

    int option = 1;

    boolean isInOptions = false;

    boolean visibleBrackets = false;
    boolean inputDetection = true;
    boolean hardDifficulty = false;

    public MainMenu() {
    }

    public int getOption() {
        return(option);
    }

    public boolean getvisibleBrackets() {
        return(visibleBrackets);
    }

    public boolean getinputDetection() {
        return(inputDetection);
    }


    public void step(int amount) {
        if ((option + amount <= 3) && (option + amount >= 1) && (isInOptions == false)) {
            option += amount;
        }
        if ((option + amount <= 4) && (option + amount >= 1) && (isInOptions)) {
            option += amount;
        }
    }

    public void displayMenu() {
        if (isInOptions == false) {
            clear();
            System.out.println("\u001B[37m" + "\u001B[40m");
            System.out.println("\u001B[32m" + " -------------------------------" + "\u001B[37m");
            System.out.println("\u001B[32m" + "|" + "\u001B[96m" + "         Console Craft         " + "\u001B[32m" + "|" + "\u001B[37m");
            System.out.println("\u001B[32m" + " -------------------------------" + "\u001B[37m");

            if (option == 1) {
                System.out.println("\u001B[33m" + "          Singleplayer          " + "\u001B[37m");
                System.out.println("\u001B[34m" + "          Multi-player          " + "\u001B[37m");
                System.out.println("\u001B[34m" + "            Options             " + "\u001B[37m");
            }
            if (option == 2) {
                System.out.println("\u001B[34m" + "          Singleplayer          " + "\u001B[37m");
                System.out.println("\u001B[33m" + "          Multi-player          " + "\u001B[37m");
                System.out.println("\u001B[34m" + "            Options             " + "\u001B[37m");
            }
            if (option == 3) {
                System.out.println("\u001B[34m" + "          Singleplayer          " + "\u001B[37m");
                System.out.println("\u001B[34m" + "          Multi-player          " + "\u001B[37m");
                System.out.println("\u001B[33m" + "            Options             " + "\u001B[37m");
            }
        }
        else {
            clear();
            System.out.println("\u001B[37m" + "\u001B[40m");
            System.out.println("\u001B[32m" + " -------------------------" + "\u001B[37m");
            System.out.println("\u001B[32m" + "|" + "\u001B[96m" + "         Options         " + "\u001B[32m" + "|" + "\u001B[37m");
            System.out.println("\u001B[32m" + " -------------------------" + "\u001B[37m");

            if (option == 1) {
                System.out.println("\u001B[33m" + "Visible Brackets: [" + getColor(visibleBrackets) + visibleBrackets + "\u001B[33m" + "]" + "\u001B[37m");
                System.out.println("\u001B[34m" + "Input Detection: [" + getColor(inputDetection) + inputDetection + "\u001B[34m" + "]" + "\u001B[37m");
                System.out.println("\u001B[34m" + "Hard Mode: [" + getColor(hardDifficulty) + hardDifficulty + "\u001B[34m" + "]" + "\u001B[37m");
                System.out.println("\u001B[34m" + "Back" + "\u001B[37m");
            }
            if (option == 2) {
                System.out.println("\u001B[34m" + "Visible Brackets: [" + getColor(visibleBrackets) + visibleBrackets + "\u001B[34m" + "]" + "\u001B[37m");
                System.out.println("\u001B[33m" + "Input Detection: [" + getColor(inputDetection) + inputDetection + "\u001B[33m" + "]" + "\u001B[37m");
                System.out.println("\u001B[34m" + "Hard Mode: [" + getColor(hardDifficulty) + hardDifficulty + "\u001B[34m" + "]" + "\u001B[37m");
                System.out.println("\u001B[34m" + "Back" + "\u001B[37m");
            }
            if (option == 3) {
                System.out.println("\u001B[34m" + "Visible Brackets: [" + getColor(visibleBrackets) + visibleBrackets + "\u001B[34m" + "]" + "\u001B[37m");
                System.out.println("\u001B[34m" + "Input Detection: [" + getColor(inputDetection) + inputDetection + "\u001B[34m" + "]" + "\u001B[37m");
                System.out.println("\u001B[33m" + "Hard Mode: [" + getColor(hardDifficulty) + hardDifficulty + "\u001B[33m" + "]" + "\u001B[37m");
                System.out.println("\u001B[34m" + "Back" + "\u001B[37m");
            }
            if (option == 4) {
                System.out.println("\u001B[34m" + "Visible Brackets: [" + getColor(visibleBrackets) + visibleBrackets + "\u001B[34m" + "]" + "\u001B[37m");
                System.out.println("\u001B[34m" + "Input Detection: [" + getColor(inputDetection) + inputDetection + "\u001B[34m" + "]" + "\u001B[37m");
                System.out.println("\u001B[34m" + "Hard Mode: [" + getColor(hardDifficulty) + hardDifficulty + "\u001B[34m" + "]" + "\u001B[37m");
                System.out.println("\u001B[33m" + "Back" + "\u001B[37m");
            }
        }
    }

    public String getColor(boolean check) {
        if (check == true) {
            return("\u001B[36m");
        }
        else {
            return("\u001B[31m");
        }
    }

    public void select() {
        if (option == 1 && isInOptions == false) {
            isInOptions = false;
            option = 0;
        }
        if (option == 3 && isInOptions == false) {
            isInOptions = true;
            option = 1;
        }
        if (option == 4 && isInOptions == true) {
            isInOptions = false;
            option = 1;
        }
        if (option == 1 && isInOptions == true) {
            visibleBrackets = !(visibleBrackets);
        }
        if (option == 2 && isInOptions == true) {
            inputDetection = !(inputDetection);
        }
        if (option == 3 && isInOptions == true) {
            hardDifficulty = !(hardDifficulty);
        }
    }

    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
