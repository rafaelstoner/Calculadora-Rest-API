package operacao;

import java.math.BigDecimal;

public class Subtracao implements Operacao{
    @Override
    public BigDecimal calcular(BigDecimal valor1, BigDecimal valor2) {
        return valor1.subtract(valor2);
    }
}
