package software.ulpgc.Kata5;

public class MeanCommand implements Command{
    @Override
    public Output execute(Input input) {
        try {
            int number1 = Integer.parseInt(input.get(":number1"));
            int number2 = Integer.parseInt(input.get(":number2"));
            return outputOf(number1, number2);
        } catch (NumberFormatException e) {
            return nanOutput();
        }
    }

    private Output nanOutput() {
        return new Output() {
            @Override
            public int responseCode() {
                return 405;
            }

            @Override
            public String result() {
                return "Not a number";
            }
        };
    }

    private Output outputOf(int number1, int number2) {
        return new Output() {
            @Override
            public int responseCode() {
                return 200;
            }

            @Override
            public String result() {
                return String.valueOf(meanOf(number1, number2));
            }
        };
    }

    private static double meanOf(int number1, int number2) {
        return (number1 + number2)/2.0;
    }
}
