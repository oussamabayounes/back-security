package com.dpc.Scolarity.param;

import java.util.List;

public class MessageParam {
	private Long fromU;
	private List<Long> toU;
	private String message;

	public Long getFromU() {
		return fromU;
	}

	public void setFromU(Long fromU) {
		this.fromU = fromU;
	}

	public List<Long> getToU() {
		return toU;
	}

	public void setToU(List<Long> toU) {
		this.toU = toU;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
