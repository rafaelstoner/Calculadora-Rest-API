package operacao;

import java.math.BigDecimal;

public interface Operacao {
    BigDecimal calcular(BigDecimal valor1, BigDecimal valor2);
}
