import java.util.*;

public class fourpicsoneword  {

    public static void main(String[] args) {
        List<String[]> words = new ArrayList<>();
        words.add(new String[]{"apple", "apple.jpg", "red.jpg", "green.jpg", "juice.jpg"});
        words.add(new String[]{"car", "car.jpg", "wheel.jpg", "road.jpg", "engine.jpg"});
        words.add(new String[]{"beach", "beach.jpg", "ocean.jpg", "sand.jpg", "sun.jpg"});

        Random random = new Random();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                int index = random.nextInt(words.size());
                String[] selectedWord = words.get(index);
                String answer = selectedWord[0];
                String[] pictureNames = new String[4];
                System.arraycopy(selectedWord, 1, pictureNames, 0, 4);

                System.out.println("Guess the word that these four pictures have in common:");
                for (String pictureName : pictureNames) {
                    System.out.println(pictureName);
                }

                // Generate a list of letters for the scrambled word
                List<Character> letters = new ArrayList<>();
                char[] answerChars = answer.toCharArray();
                for (char c : answerChars) {
                    letters.add(c);
                }
                while (letters.size() < 10) {
                    char randomChar = (char) (random.nextInt(26) + 'a');
                    if (!letters.contains(randomChar)) {
                        letters.add(randomChar);
                    }
                }
                Collections.shuffle(letters);

                // Display the scrambled word
                StringBuilder scrambledWord = new StringBuilder();
                for (char c : letters) {
                    scrambledWord.append(c);
                }
                System.out.println("Scrambled word: " + scrambledWord);

                boolean correct = false;
                while (!correct) {
                    System.out.print("Your guess: ");
                    String guess = scanner.nextLine();

                    if (guess.equalsIgnoreCase(answer)) {
                        System.out.println("Congratulations, you guessed the word!");
                        correct = true;
                    } else {
                        System.out.println("Sorry, that's incorrect. Please try again.");
                    }
                }
            }
        }
    }
}