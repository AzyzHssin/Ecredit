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


}
