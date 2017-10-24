import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch3_6_Test {
    @Test
    public void testSquareSequence() {
        Ch3_6.Sequence<BigInteger> sequence = new Ch3_6.SquareSequence();
        for (int i = 1; i <= 100; i++) {
            assertEquals(Integer.toString(i*i), sequence.next().toString());
        }
    }
}
