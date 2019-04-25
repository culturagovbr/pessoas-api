package br.gov.cultura.sistema.pessoa.exception;

import java.util.LinkedHashMap;
import java.util.Map;

public class NegocioException extends Exception {
    private static final long serialVersionUID = 1L;

    public NegocioException(String message) {
        super(message);
    }

    public Map<String, String> getErroMap() {
        Map<String, String> toReturn = new LinkedHashMap(1);
        toReturn.put("erro", this.getMessage());
        return toReturn;
    }
}
