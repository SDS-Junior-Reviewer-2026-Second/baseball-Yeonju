import static org.junit.jupiter.api.Assertions.*;

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

    @Test void throwExceptionWhenInputIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            game.guess(null);
        });
    }

    @Test
    void throwExceptinoWhenInputLengthIsUnmatched() {
        try {
            game.guess("12");
            fail();
        }
        catch (IllegalArgumentException e){

        }
    }

}
