package org.sisoftware;

import java.io.IOException;

public class ExceptionChild extends ExceptionParent {

	// void method() throws IOException{ // 1/a) example
	// void method() throws ArithmeticException{ // 1/b) example
	// void method() throws IOException{ // 2/a) example
	// void method() throws ArithmeticException{ // 2/b) example
	@Override
	void method() {
		System.out.println("Child Class");
	}
}
