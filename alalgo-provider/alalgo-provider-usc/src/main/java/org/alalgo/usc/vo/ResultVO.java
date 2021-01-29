package org.alalgo.usc.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class ResultVO implements Serializable{
	private int code;
	private String msg;
	public static ResultVO error(String errorMsg) {
		return new ResultVO(500,errorMsg);		
	}
	public static ResultVO ok() {
		return new ResultVO(200,"success");		
	}
	public static ResultVO ok(String msg) {
		return new ResultVO(200,msg);		
	}	
}
