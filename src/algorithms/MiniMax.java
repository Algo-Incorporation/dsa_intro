public class MiniMax {
    public static int max(boolean istX, int tiefe) {
        if(tiefe == 0 /* || keine Züge mehr */) {
            return 0/* Spielbrett-wertung */;
        }
        // Wenn keine züge mehr da sind, ist das unendlich schlecht
        int wertungDesBestenSpielbretts = -Integer.MAX_VALUE; 
        
        Object[] alleMoeglichenZüge = null/* Alle möglichen züge hier generieren */;
        
        // Über alle züge rübergehen
        for(Object zug : alleMoeglichenZüge) {
            // Hier wird der zug auf dem spielbrett ausgeführt

            // Dann wird der zug an den nächsten spieler weitergegeben
            int wertungDesNeuenSpielbretts = min(!istX, tiefe-1);

            // Hier wird der oben gemachte zug rückgängig gemacht

            // Ist dieser zug besser als der davor?
            if(wertungDesNeuenSpielbretts > wertungDesBestenSpielbretts) {
                wertungDesBestenSpielbretts = wertungDesNeuenSpielbretts;
            }
        }

        // Besten wert zurückgeben
        return wertungDesBestenSpielbretts;
    }

    public static int min(boolean istX, int tiefe) {
        if(tiefe == 0 /* || keine Züge mehr */) {
            return 0/* Spielbrett-wertung */;
        }

        // Weil hier als der gegner gespielt wird, wird als MAX_VALUE initialisiert, 
        // damit jeder zug der schlechteste für den gegner ist.
        // Oben wird -MAX_VALUE benutzt, um für uns den besten Zug auszusuchen.
        int wertungDesBestenSpielbretts = Integer.MAX_VALUE;

        Object[] alleMoeglichenZüge = null/* Alle möglichen züge hier generieren */;
        
        // Über alle züge rübergehen
        for(Object zug : alleMoeglichenZüge) {
            // Hier wird der zug auf dem spielbrett ausgeführt

            // Dann wird der zug an den nächsten spieler weitergegeben
            int wertungDesNeuenSpielbretts = max(!istX, tiefe-1);

            // Hier wird der oben gemachte zug rückgängig gemacht

            // Ist dieser zug besser als der davor?
            if(wertungDesNeuenSpielbretts > wertungDesBestenSpielbretts) {
                wertungDesBestenSpielbretts = wertungDesNeuenSpielbretts;
            }
        }

        // Bester zug für den gegner
        return wertungDesBestenSpielbretts;
    }

    public static void ausfueheren() {
        Object spielbrett = null;
        
        // X ist am Zug
        boolean istX = true;

        int tiefe = 10;

        int wertungDesBestenSpielbretts = Integer.MAX_VALUE;
        Object[] alleMoeglichenZüge = null/* Alle möglichen züge hier generieren */;
        Object besterZug = null;
        
        // Über alle züge rübergehen
        for(Object zug : alleMoeglichenZüge) {
            // Hier wird der zug auf dem spielbrett ausgeführt

            // Dann wird der zug an den nächsten spieler weitergegeben
            int wertungDesNeuenSpielbretts = max(!istX, tiefe-1);

            // Hier wird der oben gemachte zug rückgängig gemacht

            // Ist dieser zug besser als der davor?
            if(wertungDesNeuenSpielbretts > wertungDesBestenSpielbretts) {
                wertungDesBestenSpielbretts = wertungDesNeuenSpielbretts;

                // Besten zug zwischenspeichen, damit er nach der suche gespielt werden kann.
                besterZug = zug;
            }
        }

        if(besterZug == null) {
            // Das spiel ist bereits vorbei.
        }

        // besterZug ist nun der zug, welcher der gegebenen seite den größten vorteil erhält,
        // auch wenn der gegner "perfekt" spielt.
    }
}
