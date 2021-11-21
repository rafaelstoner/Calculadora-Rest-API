package com.example.calculadora.handler;

import com.example.calculadora.exception.CalculatorException;
import com.example.calculadora.operacao.Operacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public class ImplementacaoHandlerDeMensagens implements HandlerDeMensagens {
    @Override
    public String processarMensagem(String mensagem) {
        String resultado = null;
        try {
            String[] arrayMensagem = mensagem.split(",");

            Operacao ope = criarObjeto(arrayMensagem[0]);
            BigDecimal valor1 = new BigDecimal(arrayMensagem[1]);
            BigDecimal valor2 = new BigDecimal(arrayMensagem[2]);

            resultado = ope.calcular(valor1, valor2).toString();

        }
        catch (ArrayIndexOutOfBoundsException e) {
            String exceptionMessage = String.format("Mensagem mal formada! '%s'", mensagem);
            logger.error(exceptionMessage);
            throw new CalculatorException(exceptionMessage + " Uso: 'OPER,A,B'", e);
        }
        catch (ClassNotFoundException e) {
            String exceptionMessage = String.format("Operação desconhecida! '%s'", mensagem);
            logger.error(exceptionMessage);
            throw new CalculatorException(exceptionMessage, e);
        }
        catch (InstantiationException e) {
            String exceptionMessage = String.format("Não é possível instanciar a operação! %s", e.getMessage());
            logger.error(exceptionMessage);
            throw new CalculatorException(exceptionMessage, e);

        }
        catch (IllegalAccessException e) {
            logger.error(e.getMessage());
            throw new CalculatorException(e);
        } catch (InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return resultado;

    }

    private static Operacao criarObjeto(String nomeDaClasse) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String operPackage = "com.example.calculadora.operacao";
        Class<?> clazz = Class.forName(operPackage + "." + nomeDaClasse);
        return (Operacao) clazz.getDeclaredConstructor().newInstance();
    }

    private static final Logger logger = LoggerFactory.getLogger(ImplementacaoHandlerDeMensagens.class);
}
