package SituationFamiliale;

import javax.persistence.Id;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table
public class SituationFamiliale {
    @Id
    private long id;
    private String situation;

    public SituationFamiliale(long id, String situation) {
        this.id = id;
        this.situation = situation;
    }

    public SituationFamiliale() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }
}
