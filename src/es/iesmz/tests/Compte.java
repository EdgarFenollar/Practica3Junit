package es.iesmz.tests;

import java.math.BigInteger;

public class Compte {
    private String cuenta;
    private String nombre;

    public Compte(String cuenta, String nombre) {
        this.cuenta = cuenta;
        this.nombre = nombre;
    }

    public boolean compruebaIBAN(String iban) {
        if (iban.length() != 24 || !iban.startsWith("ES")) {
            return false;
        }
        iban = iban.substring(4) + iban.substring(0, 4);
        StringBuilder ibanConvertido = new StringBuilder();
        for (int i = 0; i < iban.length(); i++) {
            char c = iban.charAt(i);
            if (Character.isDigit(c)) {
                ibanConvertido.append(c);
            } else {
                ibanConvertido.append(10 + c - 'A');
            }
        }
        return new java.math.BigInteger(ibanConvertido.toString()).mod(new java.math.BigInteger("97")).intValue() == 1;
    }


    public String generaIBAN(String entidad, String oficina, String dc, String cuenta) {
        String xxString = null;
        if (entidad.length() != 4 || oficina.length() != 4 || dc.length() != 2 || cuenta.length() != 10){
            return null;
        } else {
            String ibanFinal = entidad + oficina + dc + cuenta + "142800";
            try{
                BigInteger iban = new BigInteger(ibanFinal);
                BigInteger divisor = new BigInteger("97");
                BigInteger recordatorio = iban.mod(divisor);
                int xxInt = 98 - recordatorio.intValue();
                xxString = String.valueOf(xxInt);
                if (xxInt < 10){
                    xxString = "0" + xxString;
                }
            }catch (NumberFormatException e){
                return null;
            }
            return "ES" + xxString + entidad + oficina + dc + cuenta;
        }
    }
}
