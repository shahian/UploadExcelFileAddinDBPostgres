package com.haytech.kosarinsurance.model.entity;

import com.haytech.kosarinsurance.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@Table(name = "nonlifeInsurance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class NonlifeInsurance extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "debt_index")
    private String debtIndex;

    @Column(name = "debt_group")
    private String debtGroup;

    @Column(name = "unit_code")
    private String unitCode;

    @Column(name = "asset_code")
    private String assetCode;

    @Column(name = "insurance_unit_code")
    private String insuranceUnitCode;

    @Column(name = "insurance_unit_name")
    private String insuranceUnitName;

    @Column(name = "insurance_policy_number")
    private String insurancePolicyNumber;

    @Column(name = "field_title")
    private String fieldTitle;

    @Column(name = "field_code")
    private String fieldCode;

    @Column(name = "insurance_date")
    private String insuranceDate;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "insurer_name")
    private String insurerName;

    @Column(name = "insurer_last_name")
    private String insurerLastName;

    @Column(name = "insurer_national_code")
    private String insurerNationalCode;

    @Column(name = "payer_name")
    private String payerName;

    @Column(name = "payer_last_name")
    private String payerLastName;
    @Column(name = "payer_personal_code")
    private String payerPersonnelCode;
    @Column(name = "payer_national_code")
    private String payerNationalCode;
    @Column(name = "employment_status")
    private String employmentStatus;
    @Column(name = "insurance_amount")
    private double insuranceAmount;
    @Column(name = "insurance_balance")
    private double insuranceBalance;
    @Column(name = "installment_amount")
    private double installmentAmount;
    @Column(name = "installment_count")
    private int installmentCount;
    @Column(name = "insurer_mobile_number")
    private String insurerMobileNumber;

}
//    شماره قرارداد: Contract Number
//        شاخص بدهی: Debt Index
//        گروه بدهی: Debt Group
//        کد یگان: Unit Code
//        کد دارایی: Asset Code
//        کد واحد صدور: Issuance Unit Code
//        نام واحد صدور: Issuance Unit Name
//        شماره بیمه نامه: Insurance Policy Number
//        عنوان رشته: Field Title
//        کد رشته: Field Code
//        تاریخ صدور: Issuance Date
//        تاریخ شروع: Start Date
//        تاریخ پایان: End Date
//        نام بیمه گذار: Insurer Name
//        نام خانوادگی بیمه گذار: Insurer Last Name
//        کد ملی بیمه گذار: Insurer National Code
//        نام متعهد پرداخت: Payer Name
//        نام خانوادگی متعهد پرداخت: Payer Last Name
//        کد پرسنلی متعهد پرداخت: Payer Personnel Code
//        کد ملی متعهد پرداخت: Payer National Code
//        وضعیت شغلی: Employment Status
//        مبلغ حق بیمه: Insurance Amount
//        مانده حق بیمه: Insurance Balance
//        مبلغ قسط: Installment Amount
//        تعداد اقساط: Installment Count
//        تلفن همراه بیمه گذار: Insurer Mobile Number
