import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFormatConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Date: ");
            String userInput = scanner.nextLine();

            // Check if the input matches either format
            if (isValidFormatMDY(userInput)) {
                String isoDate = convertToISO(userInput);
                System.out.println(isoDate);
                break;
            } else if (isValidFormatMDYYYY(userInput)) {
                String isoDate = convertMDYYYYToISO(userInput);
                System.out.println(isoDate);
                break;
            } else {
                System.out.println("Invalid date format. Please try again.");
            }
        }
    }

    // Check if the input matches month/day/year format
    private static boolean isValidFormatMDY(String input) {
        Pattern pattern = Pattern.compile("^(\\d{1,2})/(\\d{1,2})/(\\d{4})$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    // Convert month/day/year format to ISO format (YYYY-MM-DD)
    private static String convertToISO(String input) {
        String[] parts = input.split("/");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    // Check if the input matches month name day, year format
    private static boolean isValidFormatMDYYYY(String input) {
        Pattern pattern = Pattern.compile("^(\\w+) (\\d{1,2}), (\\d{4})$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    // Convert month name day, year format to ISO format (YYYY-MM-DD)
    private static String convertMDYYYYToISO(String input) {
        String[] parts = input.split(" ");
        String monthStr = parts[0];
        int day = Integer.parseInt(parts[1].replace(",", ""));
        int year = Integer.parseInt(parts[2]);

        // Mapping month names to their respective numbers
        String[] monthNames = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        int month = 0;
        for (int i = 0; i < monthNames.length; i++) {
            if (monthNames[i].equalsIgnoreCase(monthStr)) {
                month = i + 1; // Months are 1-indexed
                break;
            }
        }

        return String.format("%04d-%02d-%02d", year, month, day);
    }
}

//OUTPUT
//Date: December 14, 2003
//2003-12-14
