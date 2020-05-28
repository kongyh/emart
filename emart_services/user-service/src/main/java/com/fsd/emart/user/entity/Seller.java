package com.fsd.emart.user.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
@Entity
public class Seller {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long seller_id;
	private String s_name;
	private String s_password;
	private String s_email;
	private String s_mobile;
	private String s_company;
	private String s_brief_company;
	private String s_address;
	private String s_website;
	@CreatedDate
    @Column(updatable = false, nullable = false)
    private Date seller_created_time;

	@Override 
	public String toString() {
		return "seller{ " +
	           "seller_id:"+ seller_id+
	           ",s_name:"+s_name+
	           ",s_password:"+s_password+
	           ",s_email:"+s_email+
	           ",s_mobile:"+s_mobile+
	           ",s_company:"+s_company+
	           ",s_brief_company:"+s_brief_company+
	           ",s_address:"+s_address+
	           ",s_website:"+s_website+
	           "}" ;
	}

}
