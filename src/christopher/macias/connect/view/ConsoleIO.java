package christopher.macias.connect.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConsoleIO {
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public String prompForString(String prompt) throws IOException {
        while (true) {
            System.out.println(prompt);
            String input = in.readLine();
            try {
                return input;

            } catch (IllegalArgumentException ex) {
                System.err.println("Input cannot be null or empty; you entered"+ input);

            }
        }
    }

    public int promptForInt () throws IOException{
        return promptForInt(Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public int promptForInt(int Min,int Max) throws IOException {

        do {
            String rawInput = in.readLine();
            try {
                int input = Integer.parseInt(rawInput);
                if(input <Min || input>Max){
                    throw new IllegalArgumentException("input must be between"+ Min+"and"+Max+".");
                }
                return input;
            } catch (NumberFormatException ex) {
                System.err.println(" you must enter a valid integer. ");
                System.err.println(" please try again. ");
            }catch(IllegalArgumentException ex){
                System.err.println("you have to enter an integer between "+ Min +"and "+ Max+".");
                System.err.println("please try again. ");
            }

        } while (true);




    }
    public LocalDate promptForDate() throws IOException {
        while (true){
            System.out.println("please enter you birth year: ");
        int year = promptForInt(1900, LocalDate.now().getYear());
        System.out.println(" please enter your birth Month");
        int month = promptForInt(1, 12);
        System.out.println("please enter the day of the month");
        int day = promptForInt(1, 31);
        LocalDate birthday = LocalDate.of(year, month, day);

        try {
            LocalDate birthDay = LocalDate.of(year, month, day);
            return birthDay;
        } catch (DateTimeException de) {
            System.err.println("that date is invalid; Please try again.");
        }
    }
    }


    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LocalDate promptForStringDate() throws IOException {
        System.out.println("please enter date as YYYY-MM-DD ");
        String RawInput = in.readLine();
        LocalDate date =LocalDate.parse(RawInput, fmt);
        return date;
    }

    public String prompForString() throws IOException{
        return in.readLine();
    }
}
