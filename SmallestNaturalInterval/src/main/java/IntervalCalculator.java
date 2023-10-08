/*
Tehtävänannossa jäi hieman tulkinnanvaraiseksi, saako palauttaa nollan. Esim. jos syöte on [1,2,4,10] tai [100,1,3,10],
pienin määrä on 0, koska [1,2]:n ja [100,1]:n väliin ei mahdu yhtään lukua luonnollisessa järjestyksessä.

Tässä on oletettu, että palautusarvon pitää olla nollaa suurempi eli väliin pitää mahtua ainakin yksi
luonnollinen luku.
*/

public class IntervalCalculator {
    public static Integer shortestNaturalInterval(int[] numbers) {
        if (numbers.length < 2) {
            // palautetaan null jos taulukko on alamittainen
            return null;
        }

        int minimum = Integer.MAX_VALUE;

        for (int i = 1; i < numbers.length; i++) {
            int freeSpaceInBetween = numbers[i] - numbers[i - 1] - 1;
            if (freeSpaceInBetween > 0 && freeSpaceInBetween < minimum) {
                minimum = freeSpaceInBetween;
            }
        }

        if (minimum == Integer.MAX_VALUE) {
            // palautetaan null jos ei löydy yhtään väliä johon mahtuisi ainakin yksi luonnollinen luku
            return null;
        } else {
            return minimum;
        }
    }
}
