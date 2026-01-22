package sabatinoprovenza.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "partite_calcio")
public class PartitaDiCalcio extends Evento {

    @Column(name = "squadra_casa")
    private String squadraCasa;

    @Column(name = "squadra_ospite")
    private String squadraOspite;

    // null se pareggio
    @Column(name = "squadra_vincente")
    private String squadraVincente;

    @Column(name = "gol_casa")
    private int golCasa;

    @Column(name = "gol_ospite")
    private int golOspite;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione,
                           TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location,
                           String squadraCasa, String squadraOspite, String squadraVincente,
                           int golCasa, int golOspite) {

        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.golCasa = golCasa;
        this.golOspite = golOspite;
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolCasa() {
        return golCasa;
    }

    public void setGolCasa(int golCasa) {
        this.golCasa = golCasa;
    }

    public int getGolOspite() {
        return golOspite;
    }

    public void setGolOspite(int golOspite) {
        this.golOspite = golOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "titolo='" + getTitolo() + '\'' +
                ", dataEvento=" + getDataEvento() +
                ", squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golCasa=" + golCasa +
                ", golOspite=" + golOspite +
                '}';
    }

}

