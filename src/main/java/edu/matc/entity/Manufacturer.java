package edu.matc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

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