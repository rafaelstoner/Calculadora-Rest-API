package operacao;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Divisao implements Operacao{
    @Override
    public BigDecimal calcular(BigDecimal valor1, BigDecimal valor2) {
        if (valor2.equals(BigDecimal.ZERO)){
            throw new IllegalArgumentException("Divisão por 0");

        }
        return valor1.divide(valor2, 3, RoundingMode.CEILING);
    }
}
