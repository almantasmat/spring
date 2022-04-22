package com.nortal.mega.persistence.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "building")
public class BuildingDbo {

    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "index")
    private String index;
    @Column(name = "sector_code")
    private String sectorCode;
    @Column(name = "energy_units")
    private Integer energyUnits;
    @Column(name = "energy_unit_max")
    private Integer energyUnitMax;

    public BuildingDbo() {
    }

    public BuildingDbo(String name, String address, String index, String sectorCode, Integer energyUnits, Integer energyUnitMax) {
        this.name = name;
        this.address = address;
        this.index = index;
        this.sectorCode = sectorCode;
        this.energyUnits = energyUnits;
        this.energyUnitMax = energyUnitMax;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public  Long getId(){
        return id;
    }


    public String getName() {
        return name;
    }



    public String getAddress() {
        return address;
    }



    public String getIndex() {
        return index;
    }



    public String getSectorCode() {
        return sectorCode;
    }



    public Integer getEnergyUnits() {
        return energyUnits;
    }



    public Integer getEnergyUnitMax() {
        return energyUnitMax;
    }


}
