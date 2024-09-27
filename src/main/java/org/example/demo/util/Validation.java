package org.example.demo.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Validation {
    /**
     * Ensures a given value is an integer
     * @param val value to be evaluated
     * @param field field name of value
     */
    public void isInteger(String val, String field) {
        try {
            Integer.parseInt(val);
        } catch (NumberFormatException e) {
            throw new RuntimeException(field + " must be a number");
        }
    }

    /**
     * Ensures a given integer is greater than a value
     * @param val value to be evaluated
     * @param min minimum allowed value
     * @param field field name of value
     */
    public void isInteger(String val, int min, String field) {
        try {
            isInteger(val, field);
            int parsed = Integer.parseInt(val);

            if (parsed < min) {
                throw new RuntimeException(field + " must be greater than " + min);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Ensures a given integer is between two values
     * @param val value to be evaluated
     * @param min minimum allowed value
     * @param max maximum allowed value
     * @param field field name of value
     */
    public void isInteger(String val, int min, int max, String field) {
        try {
            isInteger(val, min, field);
            int parsed = Integer.parseInt(val);

            if (parsed > max) {
                throw new Exception(field + "must be less than " + max);
            }
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Ensures a given value is a double
     * @param val value to be evaluated
     * @param field field name of value
     */
    public void isDouble(String val, String field) {
        try {
            Double.parseDouble(val);
        } catch (NumberFormatException e) {
            throw new RuntimeException(field + " must be a number");
        }
    }

    /**
     * Ensures a double is less than a given number
     * @param val value to be evaluated
     * @param min minimum allowed value
     * @param field field name of value
     */
    public void isDouble(String val, int min, String field) {
        try {
            isDouble(val, field);
            double parsed = Double.parseDouble(val);
            if (parsed < min) {
                throw new Exception(field + "must be greater than " + min);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Ensures a double is between two given numbers
     * @param val value to be evaluated
     * @param min minimum allowed value
     * @param max maximum allowed value
     * @param field field name of value
     */
    public void isDouble(String val, int min, int max, String field) {
        try {
            isDouble(val, min, field);
            double parsed = Double.parseDouble(val);

            if (parsed > max) {
                throw new Exception(field + "must be less than " + max);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Ensures a value is a date
     * @param val value to be evaluated
     * @param field field name of value
     */
    public void isDate(String val, String field) {
        try {
            LocalDate.parse(val);
        } catch (DateTimeParseException e) {
            throw new RuntimeException(field + "must be a valid date");
        }
    }

    /**
     * Ensures a date is greater than a given date
     * @param val value to be evaluated
     * @param min minimum allowed date
     * @param field field name of value
     */
    public void isDate(String val, LocalDate min, String field) {
        try {
            isDate(val, field);
            LocalDate parsed = LocalDate.parse(val);
            if (parsed.isBefore(min)) {
                throw new Exception(field + "must be before " + min);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Ensures a date is between 2 given dates
     * @param val value to be evaluated
     * @param min minimum allowed date
     * @param max maximum allowed date
     * @param field field name of value
     */
    public void isDate(String val, LocalDate min, LocalDate max, String field) {
        try {
            isDate(val, min, field);
            LocalDate parsed = LocalDate.parse(val);

            if (parsed.isAfter(LocalDate.of(max.getYear(), max.getMonthValue(), max.getDayOfMonth()))) {
                throw new Exception(field + "must be after " + max);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Ensures a string is less than a given length
     * @param val value to be evaluated
     * @param max max number of allowed characters
     * @param field field name of value
     */
    public void isLessThan(String val, int max, String field) {
        try {
            if (val.length() > max) {
                throw new Exception(field + "must be less than " + max + " characters");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
