package com.dw.ngms.cis.im.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by swaroop on 2019/04/19.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "IMREQUESTS")
public class Requests implements Serializable {

	private static final long serialVersionUID = 8311145174688482135L;

	@Id
    @Column(name = "REQUESTID")
    @SequenceGenerator(name = "generator", sequenceName = "REQUESTS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generator")
    private Long requestId;

    @OneToMany(mappedBy="requestItems",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<RequestItems> requestItems;

    @Column(name = "REQUESTCODE")
    private String requestCode;

    @Column(name = "USERCODE", length = 100, unique = true)
    private String userCode;

    @Column(name = "PROVINCECODE", length = 100, unique = true)
    private String provinceCode;

    @Column(name = "SECTIONCODE", length = 100, unique = true)
    private String sectionCode;

    @Column(name = "USERNAME", length = 200)
    private String userName;

    @Column(name = "EMAIL", length = 200)
    private String email;


    @Column(name = "REQUESTTYPENAME", length = 100, unique = true)
    private String requestTypeName;


    @Column(name = "REQUESTKINDNAME")
    private String requestKindName;

    @Column(name = "REQUESTTITLE", length = 100, unique = true)
    private String requestTitle;

    @Column(name = "ORGANISATION", length = 200)
    private String organisation;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "POSTALADDRESS1", length = 100)
    private String postalAddress1;

    @Column(name = "POSTALADDRESS2", length = 100)
    private String postalAddress2;

    @Column(name = "POSTALADDRESS3", length = 100)
    private String postalAddress3;

    @Column(name = "POSTALADDRESS4", length = 100)
    private String postalAddress4;

    @Column(name = "DELIVERYMETHOD", length = 200)
    private String deliveryMethod;

    @Column(name = "MEDIATYPE", length = 200)
    private String mediaType;

    @Column(name = "FORMATTYPE", length = 200)
    private String formatType;

    @Column(name = "PAYMENTCURRENCY", length = 200)
    private String paymentCurrency;

    @Column(name = "TOTALPAYMENTAMOUNT", length = 200)
    private String totalPaymentAmount;

    @Column(name = "TOTALPAYMENTVAT", length = 200)
    private String totalPayment;

    @Column(name = "TOTALAMOUNT", length = 200)
    private String totalAmount;

    @Column(name = "INVOICENUMBER", length = 200)
    private String invoiceNumber;

    @Column(name = "INVOICEFILEPATH", length = 200)
    private String invoiceFilePath;

    @Column(name = "POPFILEPATH", length = 200)
    private String popFilePath;

    @Column(name = "PAYMENTSTATUS", length = 10)
    private String paymentStatus;


    @Column(name = "REFERENCENUMBER", length = 200)
    private String referenceNumber;


    @Column(name = "MODIFIEDUSERCODE", length = 200)
    private String modifiedUserCode;


    @Column(name = "ISACTIVE", length = 200)
    private String isActive;

    @Column(name = "ISDELETED", length = 200)
    private String isDeleted;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATEDDATE", nullable = true)
    private Date createdDate = new Date();

    @Temporal(TemporalType.DATE)
    @Column(name = "REQUESTDATE", nullable = true)
    private Date requestDate = new Date();

    @Temporal(TemporalType.DATE)
    @Column(name = "DELETEDDATE")
    private Date deletedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFIEDDATE")
    private Date modifiedDate;


    @Transient
    private String processId;
    
}
