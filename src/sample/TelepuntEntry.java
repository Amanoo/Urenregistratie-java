package sample;

public class TelepuntEntry {
        private String omschrijving;
        private String tijd;

        public TelepuntEntry(String omschrijving, String tijd) {
            this.omschrijving = omschrijving;
            this.tijd = tijd;
        }

        public String getOmschrijving() {
            return omschrijving;
        }

        public String getTijd() {
            return tijd;
        }

    public void setOmschrijving(String newValue) {
            this.omschrijving =newValue;
    }

    public void setTijd(String newValue) {
            tijd =newValue;
    }
}
