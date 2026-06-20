import java.util.ArrayList;
import java.util.Collections;

public class Leaderboard {

    private ArrayList<Integer> scores;

    public Leaderboard() {
        scores = new ArrayList<Integer>();
    }

    public void addScore(int score) {
        scores.add(score);
        bubbleSort();
    }

    private void bubbleSort() {

        for (int i = 0; i < scores.size() - 1; i++) {

            for (int j = 0; j < scores.size() - i - 1; j++) {

                if (scores.get(j) < scores.get(j + 1)) {

                    Collections.swap(scores, j, j + 1);

                }

            }

        }

    }

    public String getScores() {

        String text = "Leaderboard\n\n";

        for (int i = 0; i < scores.size(); i++) {

            text += (i + 1) + ". " + scores.get(i) + "\n";

        }

        return text;
    }

}