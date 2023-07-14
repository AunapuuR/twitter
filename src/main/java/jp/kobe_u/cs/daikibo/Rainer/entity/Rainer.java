package jp.kobe_u.cs.daikibo.Rainer.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Data
@Entity
public class Rainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;  // Tweet entity identifier
    String name ;     // name
    String comment ;  // comment
    @Temporal(TemporalType.TIMESTAMP)
    Date createdAt ;
}
