package com.dw.ngms.cis.uam.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by swaroop on 2019/03/24.
 */

@Entity
@Table(name = "ExternalUserRoles")
@Data
@Getter
@Setter
@ToString
public class ExternalUserRoles implements Serializable {

	private static final long serialVersionUID = 1098484893268694655L;

    @Column(name = "USERID", nullable = true, length = 50, insertable = false, updatable = false)
    private Long userId;

    @Id
    @Column(name = "USERROLECODE", nullable = true, length = 50)
    @NotEmpty(message = "USER ROLE CODE must not be empty")
    private String userRoleCode;


    @Column(name = "USERROLENAME", nullable = true, length = 50)
    @NotEmpty(message = "USER ROLE NAME must not be empty")
    private String userRoleName;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="USERID", nullable=false)
    @JsonBackReference
    private User externalUserRole;

    @Column(name = "USERCODE", nullable = true, length = 50)
    @NotEmpty(message = "USER CODE must not be empty")
    private String userCode;
    
    @Column(name = "USERNAME", nullable = true, length = 255)
    @NotEmpty(message = "USER NAMEmust not be empty")
    private String userName;
    
    @Column(name = "USERPROVINCECODE", nullable = true, length = 100)
    @NotEmpty(message = "USER PROVINCE CODE must not be empty")
    private String userProvinceCode;

    @Column(name = "USERPROVINCENAME", nullable = true, length = 50)
    @NotEmpty(message = "USER PROVINCE NAME must not be empty")
    private String userProvinceName;

    @Column(name = "ISACTIVE", nullable = true, length = 10)
    @NotEmpty(message = "Active status must not be empty")
    private String isActive = "Y";

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATEDDATE", nullable = true)
    Date createdDate = new Date();

//    @Column(name = "SIGNEDACCESSFILEPATH")
//    private String signedaccessfilepath;

//    @Column(name = "USERID", nullable = true)
//    private Long userid;

    @Column(name = "EXTERNALROLECODE",length = 50)
    private String externalRoleCode;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userRoleCode == null) ? 0 : userRoleCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExternalUserRoles other = (ExternalUserRoles) obj;
		if (userRoleCode == null) {
			if (other.userRoleCode != null)
				return false;
		} else if (!userRoleCode.equals(other.userRoleCode))
			return false;
		return true;
	}
    
}
