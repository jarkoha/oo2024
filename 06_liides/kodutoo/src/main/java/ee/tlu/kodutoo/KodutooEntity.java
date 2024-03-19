package ee.tlu.kodutoo;


import lombok.Getter;

@Getter
class KodutooEntity {
    String nimetus;
    int number;
    boolean paaris;

    public KodutooEntity(String nimetus, int number, boolean paaris) {
        this.nimetus = nimetus;
        this.number = number;
        this.paaris = paaris;
    }

    public int getNumber() {
        return this.number;
    }
}
