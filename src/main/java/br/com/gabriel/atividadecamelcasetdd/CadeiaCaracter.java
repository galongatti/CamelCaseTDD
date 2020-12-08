package br.com.gabriel.atividadecamelcasetdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CadeiaCaracter {

    private ArrayList<String> listaDePalavras = new ArrayList<String>();
    private List<String> listaDePalavrasAux = new ArrayList<String>();
    private String palavra = "";

    public ArrayList<String> getListaDePalavras() {
        return listaDePalavras;
    }

    public void setListaDePalavras(ArrayList<String> listaDePalavras) {
        this.listaDePalavras = listaDePalavras;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public ArrayList<String> getCadeiaCaracter() {
        return this.listaDePalavras;
    }

    public boolean palavraEstaVazia() {

        boolean estaVazia = false;

        if (palavra.equals("")) {
            estaVazia = true;
        }

        return estaVazia;

    }

    public void adicionaPalavra(String palavra) {

        listaDePalavras.add(palavra);

    }

    public boolean caracterEspecial(String palavra) {

        boolean temCaracterEspecial = false;

        for (char c : palavra.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                throw new CaractereEspecialException("Não é permitido caracteres especiais");
            }
        }

        return temCaracterEspecial;
    }

    public static boolean verificaSeIniciaComNumero(String s) {

        boolean inicia = false;

        if (Character.isDigit(s.charAt(0))) {
            throw new IniciaComNumeroException("Não é permitido iniciar com numeros");

        }

        return inicia;

    }

    public static List<String> quebrarTexto(String texto) {
        String palavras[] = texto.split("(?<!(^|[A-Z0-9]))(?=[A-Z0-9])|(?<!(^|[^A-Z]))(?=[0-9])|(?<!(^|[^0-9]))(?=[A-Za-z])|(?<!^)(?=[A-Z][a-z])");

        for (int i = 0; i < palavras.length; i++) {
            palavras[i] = verificaPalavraMinusculo(palavras[i]);
        }

        List<String> lista = Arrays.asList(palavras);
        return lista;
    }

    public static List<String> converterCamelCase(String original) {

        List<String> palavras = new ArrayList<>();
        palavras = quebrarTexto(original);
        return palavras;

    }

    public static String verificaPalavraMinusculo(String palavra) {
        if (palavra.matches("^[A-Z][a-z].*")) {
            palavra = palavra.substring(0, 1).toLowerCase() + palavra.substring(1);
        }
        return palavra;
    }

    public boolean verificaElementosMinusculo(String palavra) {

        boolean isMinusculo = false;

        for (int i = 0; i < palavra.length(); i++) {

            if (Character.isLetter(palavra.charAt(i)) && !Character.isLowerCase(i)) {

                isMinusculo = true;

            } else if (Character.isDigit(palavra.charAt(i))) {

                isMinusculo = true;

            }

        }

        return isMinusculo;

    }

}
