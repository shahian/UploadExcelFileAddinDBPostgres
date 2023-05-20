package com.haytech.kosarinsurance.model.entity;

import com.haytech.kosarinsurance.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "retireOrgan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class RetireOrgan extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codc")
    private String codc;

    @Column(name = "shah")
    private String shah;

    @Column(name = "shkh")
    private String shkh;

    @Column(name = "codv")
    private String codv;

    @Column(name = "namv")
    private String namv;

    @Column(name = "the")
    private String the;

    @Column(name = "tarb")
    private String tarb;

    @Column(name = "mghe")
    private String mghe;

    @Column(name = "kasr")
    private String kasr;

    @Column(name = "mabv")
    private String mabv;

    @Column(name = "albv")
    private String albv;

    @Column(name = "mahp")
    private String mahp;

    @Column(name = "tks")
    private String tks;

    @Column(name = "ellat")
    private String ellat;

    @Column(name = "codm")
    private String codm;

    @Column(name = "act")
    private String act;

    @Column(name = "csab")
    private String csab;

    @Column(name = "tavg")
    private String tavg;

    @Column(name = "shvam")
    private String shvam;

    @Column(name = "dfot")
    private String dfot;

    @Column(name = "elat")
    private String elat;
}
