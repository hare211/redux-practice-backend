package com.sist.web.entity;

import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "busan_food")
@Getter @Setter @ToString
@DynamicUpdate
public class BusanFoodEntity {
	@Id
	private int fno;
	private String name, type, phone, address, poster, images, time, parking, content, price, theme;
	private int hit, jjimcount, likecount, replycount;
	private double score;
}

