package org.alalgo.usc.dos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Menu {
	 private int id 		;	
	 private int parentId   ;
	 private String title 		;
	 private int rank		;
	 private String iconUrl 	;
	 private String url 		;
	 private Date createDate ;
	 private Date updateDate ;

}
