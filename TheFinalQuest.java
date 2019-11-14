import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TheFinalQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        List<String> words = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            words.add(input[i]);
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            String[] temp = command.split("\\s+");
            String firstCommand = temp[0];

            if (firstCommand.equals("Delete")) {
                if (Integer.parseInt(temp[1]) >= -1 && Integer.parseInt(temp[1]) < words.size() -1) {
                    words.remove(Integer.parseInt(temp[1]) + 1);
                }
            }

            if (firstCommand.equals("Swap")) {
                    if (words.contains(temp[1]) && words.contains(temp[2])) {
                        for (int i = 0; i < words.size(); i++) {
                            if (words.get(i).equals(temp[1])) {
                                words.set(i, temp[2]);
                            } else if (words.get(i).equals(temp[2])) {
                                words.set(i, temp[1]);
                            }
                        }
                    }
            }

            if (firstCommand.equals("Put")) {
                if (Integer.parseInt(temp[2]) > 0 && Integer.parseInt(temp[2]) <= words.size() + 1) {
                        words.add(Integer.parseInt(temp[2]) -1, temp[1]);
                }
            }

            if (firstCommand.equals("Sort")) {
                Collections.sort(words);
                Collections.reverse(words);
            }

            if (firstCommand.equals("Replace")) {
                if (words.contains(temp[2])) {
                    for (int i = 0; i < words.size(); i++) {
                        if (words.get(i).equals(temp[2])) {
                            words.set(i, temp[1]);
                        }
                    }
                }
            }

            command = scanner.nextLine();
        }

        for (String word : words) {
            System.out.print(word + " ");
        }


    }
}
