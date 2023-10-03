package com.cursocleanarch.ms.ride.Ride.domain.person;

public record Cpf(String value) {
    public Cpf(String value) {
        if (!validate(value)) throw new IllegalArgumentException("Invalid cpf");
        this.value = value;
    }

    private boolean validate(String cpf) {
        cpf = clean(cpf);
        if (isValidLength(cpf)) return false;
        if (hasAllDigitsEqual(cpf)) return false;
        int dg1 = calculateDigit(cpf, 10);
        int dg2 = calculateDigit(cpf, 11);
        return extractCheckDigit(cpf).equals(String.format("%d%d", dg1, dg2));
    }

    private String clean(String cpf) {
        return cpf.replaceAll("\\D", "");
    }

    private boolean isValidLength(String cpf) {
        return cpf.length() != 11;
    }

    private boolean hasAllDigitsEqual(String cpf) {
        char firstDigit = cpf.charAt(0);
        for (char digit : cpf.toCharArray()) {
            if (digit != firstDigit) return false;
        }
        return true;
    }

    private int calculateDigit(String cpf, int factor) {
        int total = 0;
        for (char digit : cpf.toCharArray()) {
            if (factor > 1) total += Character.getNumericValue(digit) * factor--;
        }
        int rest = total % 11;
        return (rest < 2) ? 0 : 11 - rest;
    }

    private String extractCheckDigit(String cpf) {
        return cpf.substring(9);
    }
}
