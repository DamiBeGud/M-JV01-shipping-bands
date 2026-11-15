package study.apps;
import java.util.*;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class DomainTests{
 @Test void businessBoundariesAndConflicts(){Domain d=new Domain("EU");assertEquals(1,d.calculate(1000).band());assertEquals(2,d.calculate(1001).band());assertEquals(new java.math.BigDecimal("7.50"),d.calculate(5000).price());assertEquals(3,d.calculate(5001).band());assertThrows(Problem.class,()->d.calculate(0));assertEquals(new java.math.BigDecimal("2.00"),new Domain("LOCAL").calculate(500).price());}
}
