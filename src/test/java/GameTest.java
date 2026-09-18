import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void createGame() {
        assertNotNull(game);
    }

    @Test
    public void throwIllegalArgumentExceptionInvalidInput() {
        assertIllegalArgument(null);
        assertIllegalArgument("12");
        assertIllegalArgument("1234");
        assertIllegalArgument("12s");
        assertIllegalArgument("121");
    }

    @Test
    void returnSolvedResultIfMatchedNumber() {
        game.question = "123";
        assertMatchedNumber(game.guess("123"), true, 3, 0);
    }

    @Test
    public void returnSolvedResultIfUnMatchedNumber() {
        game.question = "123";
        assertMatchedNumber(game.guess("456"), false, 0, 0);
    }

    private void assertMatchedNumber(GuessResult result, boolean solved, int strikes, int balls) {
        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(solved);
        assertThat(result.getStrikes()).isEqualTo(strikes);
        assertThat(result.getBalls()).isEqualTo(balls);
    }

    private void assertIllegalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            org.junit.jupiter.api.Assertions.fail();
        } catch (IllegalArgumentException e) {

        }
    }


}
