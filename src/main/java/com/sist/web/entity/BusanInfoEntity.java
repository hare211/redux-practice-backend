package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "busan_info")
@Getter @Setter
public class BusanInfoEntity {
	@Id
	private int no;
	private int cno;
	private String title, address, phone, info;
}
