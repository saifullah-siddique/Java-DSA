public class EarthAnimation {
    public static void main(String[] args) throws InterruptedException {
        String[] frames = {
            "*      \n   *   \n      *",
            "   *   \n      *\n*      ",
            "      *\n*      \n   *  ",
            "*      \n   *   \n      *"
        };

        while (true) {
            for (String frame : frames) {
                clearScreen();
                System.out.println(frame);
                Thread.sleep(30); // 300ms delay
            }
        }
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Could not clear screen");
        }
    }
}
