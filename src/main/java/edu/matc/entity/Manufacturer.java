package edu.matc.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Manufacturer")
@Table(name = "manufacturer")
@Data


public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "mfg_id")
    public Integer manufacturerId;
    @Column(name = "mfg_code")
    public String manufacturerCode;
    @Column(name = "mfg_name")
    public String manufacturerName;


}

