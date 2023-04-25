package com.todo.models.enums;

public enum Status {

	ASSIGNED(1),
	RECEIVED(2),
	STARTED(3),
	PENDING(4),
	FINISHED(5),
	OUT_OF_SCOPE(6);

	private int code;

	private Status(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static Status valueOf(int code) {
		for(Status value : Status.values()) {
			if(value.getCode() == code)
				return value;
		}
		throw new IllegalArgumentException("Invalid Order Status code");
	}

}