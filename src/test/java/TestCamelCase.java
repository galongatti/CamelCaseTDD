/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.gabriel.atividadecamelcasetdd.CadeiaCaracter;
import br.com.gabriel.atividadecamelcasetdd.CaractereEspecialException;
import br.com.gabriel.atividadecamelcasetdd.IniciaComNumeroException;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TestCamelCase {

    CadeiaCaracter c;

    @Before
    public void inicializaCadeia() {

        c = new CadeiaCaracter();
        c.setPalavra("nome10Composto");
    }

   
    @Test
    @DisplayName("Verificando se a cadeia de caracter não está vazia")    
    public void testePalavraVazia() {

        boolean estaVazia = c.palavraEstaVazia();
        assertEquals(estaVazia, false);

    }

    @Test(expected = CaractereEspecialException.class)
    @DisplayName("Verificando se existem caracteres especiais")
    public void testaCaracteresEspeciais() {

        boolean contemCaracterEspecial = false;

        contemCaracterEspecial = c.caracterEspecial(c.getPalavra());

        assertEquals(contemCaracterEspecial, false);
    }

    @Test(expected = IniciaComNumeroException.class)
    @DisplayName("Verificando se inicia com número")
    public void testaIniciaComNumero() {

        boolean iniciaComNumero = false;

        iniciaComNumero = c.verificaSeIniciaComNumero(c.getPalavra());

        assertEquals(iniciaComNumero, false);

    }

    @Test
    @DisplayName("Teste de quebra de String")
    public void testaQuebraDeString() {

        List<String> listaDePalavras = c.converterCamelCase(c.getPalavra());      

        for (String s : listaDePalavras) {
            
            assertEquals(c.verificaElementosMinusculo(s), true);
            
        }
        
        System.out.println(listaDePalavras.toString());

    }

}
