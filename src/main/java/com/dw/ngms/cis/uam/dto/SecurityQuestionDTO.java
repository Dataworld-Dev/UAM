package com.dw.ngms.cis.uam.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by swaroop on 2019/03/27.
 */
@Data
@Getter
@Setter
@ToString
public class SecurityQuestionDTO implements Serializable {

	private static final long serialVersionUID = 8462144096554739452L;
	
	private String code;
    private String que;
    private String ans;

}