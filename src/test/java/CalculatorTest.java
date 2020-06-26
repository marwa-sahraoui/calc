import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private static Instant startedTime;
    private Calculator calculateInit;

    @BeforeAll
    public static void initStarTime() {
        System.out.println("appel avant tous les tests");
        startedTime = Instant.now();
    }

    @AfterAll
    public static void showTestDuration() {
        System.out.println("appel aprés tout les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedTime, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0}ms", duration));
    }

    @BeforeEach
    public void initCal() {
      calculateInit = new Calculator();
        System.out.println("avant chaque test");
    }

    @AfterEach
    public void Aftercalc() {
        calculateInit = null;
        System.out.println("apres chaque test");
    }

    @Test
    public void testAddTwoPositivNB() {
        int a = 2;
        int b = 8;
        Calculator calculator = new Calculator();

        int somme = calculator.add(a, b);

        assertEquals(10, somme);
    }

    @Test
    public void testmultiply() {
        //arrange
        int c = 3;
        int d = 5;
        Calculator calculator = new Calculator();
        //act
        int result = calculator.multiply(c,d);
        //assert
        assertEquals(15,result);
    }

    @ParameterizedTest(name = "{0} * 0 doit etre egal 0")
    @ValueSource(ints = {1, 2, 8987,163})
    public void multilyByZero(int arg) {
        int actualResult = calculateInit.multiply(arg, 0);
        assertEquals(0, actualResult);
    }
}