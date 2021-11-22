package hu.me.iit.haladojava.SpringMVC.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SzamologepRequestDTO {

	@NotNull // @Valid annotation in Controller
	private Integer a;
	@NotNull
	private Integer b;
	@NotBlank
	@Size(min = 1, max = 1)
	private String operator;

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public Integer getB() {
		return b;
	}

	public void setB(Integer b) {
		this.b = b;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

}
