package com.haytech.kosarinsurance.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
@Entity
@Table(name = "lifeInsurance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class LifeInsurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shobeh_cod")
    private String shobehCod;

    @Column(name = "shobeh_name")
    private String shobehName;

    @Column(name = "bimeh_no")
    private String bimehNo;

    @Column(name = "shts")
    private String shts;

    @Column(name = "shts_code")
    private String shtsCode;

    @Column(name = "date_sodor")
    private String dateSodor;

    @Column(name = "date_start")
    private String dateStart;

    @Column(name = "date_ens")
    private String dateEns;

    @Column(name = "name_bimeh_gozar")
    private String nameBimehGozar;

    @Column(name = "family_bimeh_gozar")
    private String familyBimehGozar;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "prs_no")
    private String prsNo;

    @Column(name = "code_yegan")
    private String codeYegan;

    @Column(name = "code_daraei")
    private String codeDaraei;

    @Column(name = "cod_meli")
    private String codMeli;

    @Column(name = "vaziat")
    private String vaziat;

    @Column(name = "code_kosor")
    private String codeKosor;

    @Column(name = "hag_bimeh")
    private double hagBimeh;

    @Column(name = "mandeh")
    private double mandeh;

    @Column(name = "ghest")
    private double ghest;

    @Column(name = "ghest_no")
    private double ghestNo;

    @Column(name = "date_ghest")
    private String dateGhest;

    @Column(name = "telh")
    private String telh;

    @Column(name = "bill_cod")
    private String billCod;

    @Column(name = "payment_cod")
    private String paymentCod;

    @Column(name = "tghe")
    private int tghe;

    @Column(name = "tghe_type")
    private String tgheType;

    @Column(name = "movafeghta_nameh")
    private String movafeghtaNameh;

    // Constructors, getters, and setters

    // ...
}
