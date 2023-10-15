package com.example.populationinfosystem.domain;

public class DeathDate {
    private String day;
    private String month;
    private String year;

    public DeathDate(String day, String month, String year, String centuryMarker) throws IllegalArgumentException {
        // pitäisi tietysti olla huolellisempi validointi - eri pituiset kuukaudet, karkausvuodet jne - mutta ei nyt ehdi...

        if (!validDay(day)) {
            throw new IllegalArgumentException("Virheellinen päivä");
        } else {
            this.day = day;
        }

        if (!validMonth(month)) {
            throw new IllegalArgumentException("Virheellinen kuukausi");
        } else {
            this.month = month;
        }
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }

    private boolean validDay(String candidate) {
        if (candidate.length() != 2) {
            return false;
        }

        int asInt;
        try {
            asInt = Integer.parseInt(candidate);
        } catch (Exception e) {
            return false;
        }

        if (asInt < 1 || asInt > 31) {
            return false;
        }

        return true;
    }

    private boolean validMonth(String candidate) {
        if (candidate.length() != 2) {
            return false;
        }

        int asInt;
        try {
            asInt = Integer.parseInt(candidate);
        } catch (Exception e) {
            return false;
        }

        if (asInt < 1 || asInt > 12) {
            return false;
        }

        return true;
    }
}
