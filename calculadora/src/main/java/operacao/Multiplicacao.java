package operacao;

import java.math.BigDecimal;

public class Multiplicacao implements Operacao{
    @Override
    public BigDecimal calcular(BigDecimal valor1, BigDecimal valor2) {
        return valor1.multiply(valor2);
    }
}
