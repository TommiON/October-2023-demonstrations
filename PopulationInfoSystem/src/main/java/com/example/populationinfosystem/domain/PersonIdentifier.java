package com.example.populationinfosystem.domain;

import com.example.populationinfosystem.utilities.PersonIdentifierCheckCharacter;

// tämä luokka on oikeastaan vain glorifioitu String, sisältää toiminnallisuutta sen varmistamiseen, että
// merkkijono on validi henkilötunnus
public class PersonIdentifier {

    private String identifier;

    public PersonIdentifier(String candidate) throws IllegalArgumentException {
        if (isValid(candidate)) {
            this.identifier = candidate;
        } else {
            throw new IllegalArgumentException("Henkilötunnus ei ole validi");
        }
    }

    @Override
    public String toString() {
        return this.identifier;
    }

    private boolean isValid(String candidate) {
        // onko väärän mittainen?
        if (candidate.length() != 11) {
            return false;
        }

        // sisältääkö alkuosa muita kuin numeroita?
        String birthComponent = candidate.substring(0,6);
        if (!isAllDigits(birthComponent)) {
            return false;
        }

        // onko erotinosa muu kuin -, + tai A?
        String separator = candidate.substring(6,7);
        if (!(separator.equals("-") || separator.equals("+") || separator.equals("A"))) {
            return false;
        }

        // sisältääkö yksilöosa muita kuin numeroita?
        String uniqueComponent = candidate.substring(7,10);
        if (!isAllDigits(uniqueComponent)) {
            return false;
        }

        // täsmääkö tarkistusmerkki?
        if (!validCheckCharacter(candidate)) {
            return false;
        }

        return true;
    }

    private boolean validCheckCharacter(String candidate) {
        String trunk = candidate.substring(0,6) + candidate.substring(7,10);

        int trunkAsInt;
        try {
            trunkAsInt = Integer.parseInt(trunk);
        } catch (Exception e) {
            // tänne ei pitäisi kylläkään koskaan joutua, validoitu jo aiemmin
            return false;
        }

        int modulo = trunkAsInt % 31;

        String searchKey = "_" + String.valueOf(modulo);
        char checkCharacter = PersonIdentifierCheckCharacter.valueOf(searchKey).getCheck();

        char lastCharacterInCandidate = candidate.substring(10).charAt(0);

        if (lastCharacterInCandidate != checkCharacter) {
            return false;
        }

        return true;
    }

    private boolean isAllDigits(String string) {
        char[] stringAsCharArray = string.toCharArray();
        for (char c : stringAsCharArray) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}
