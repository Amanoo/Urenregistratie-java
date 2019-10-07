package sample;

import java.time.LocalTime;

public class TelepuntEntry {
        private String omschrijving;
        private LocalTime tijd;

        public TelepuntEntry(String omschrijving, LocalTime tijd) {
            this.omschrijving = omschrijving;
            this.tijd = tijd;
        }

        public String getOmschrijving() {
            return omschrijving;
        }

        public LocalTime getTijd() {
            return tijd;
        }

    public void setOmschrijving(String newValue) {
            this.omschrijving =newValue;
    }

    public void setTijd(LocalTime newValue) {
            tijd =newValue;
    }
}
