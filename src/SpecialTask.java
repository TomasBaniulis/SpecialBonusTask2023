import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class SpecialTask {

    Scanner scanner = new Scanner(System.in);

    void checkDates() {
        System.out.println("Enter beginning date");
        LocalDate dateOne = getDate();
        System.out.println("Enter end date");
        LocalDate dateTwo = getDate();
        runDates(dateOne, dateTwo);
    }

    private void runDates(LocalDate dateOne, LocalDate dateTwo) {
        for (LocalDate date = dateOne; date.isBefore(dateTwo); date = date.plusDays(1)) {
            String string = date.toString();

            if (isPalindrome(string)) {
                System.out.println(string);
            }
        }
    }

    private boolean isPalindrome(String string) {
        boolean palindrome;
        int numberOfCheckCycles;
        int numberOfEquals = 0;
        int character = 0;
        String date = string.replace("-", "");

        if (date.length() % 2 == 1) {
            numberOfCheckCycles = (date.length() - 1) / 2;
        } else {
            numberOfCheckCycles = date.length() / 2;
        }

        int numberOfCheckedCharCharacters = numberOfCheckCycles;

        while (numberOfCheckCycles > 0) {
            if (date.charAt(character) == date.charAt(date.length() - character - 1)) {
                numberOfEquals++;
            }
            character++;
            numberOfCheckCycles--;
        }
        palindrome = numberOfCheckedCharCharacters == numberOfEquals;

        return palindrome;
    }

    private LocalDate getDate() {
        while (true) {
            try {
                System.out.println("Date format yyyy-MM-dd :");
                String date = scanner.nextLine();
                LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                return localDate;
            } catch (DateTimeException e) {
                System.out.println("Wrong date format. Try again!");
            }
        }
    }
}
