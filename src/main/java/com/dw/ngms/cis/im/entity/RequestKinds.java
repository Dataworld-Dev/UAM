package com.dw.ngms.cis.im.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by swaroop on 2019/04/16.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "IMREQUESTKINDS")
public class RequestKinds {


    @Id
    @Column(name = "REQUESTKINDCODE")
    private String requestKindCode;

    @Column(name = "REQUESTKINDNAME", length = 100, unique = true)
    private String requestKindName;


    @Column(name = "DESCRIPTION", length = 200)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATEDDATE", nullable = true)
    private Date createdDate = new Date();



}
