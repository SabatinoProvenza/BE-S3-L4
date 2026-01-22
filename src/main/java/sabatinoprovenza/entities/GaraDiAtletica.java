package sabatinoprovenza.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gare_atletica")
public class GaraDiAtletica extends Evento {

    @ManyToMany
    @JoinTable(
            name = "gara_atleti",
            joinColumns = @JoinColumn(name = "id_gara"),
            inverseJoinColumns = @JoinColumn(name = "id_persona")
    )
    private Set<Persona> atleti = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_vincitore")
    private Persona vincitore;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione,
                          TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location,
                          Set<Persona> atleti, Persona vincitore) {

        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        if (atleti != null) this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}

