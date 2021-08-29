package org.sisoftware;

public class ExceptionHandling {

	/**
	 * Exceptions
	 **/

	public static void main(String[] args) {

		/**
		 * ExceptionHandling with MethodOverriding
		 */
		
		ExceptionParent p = new ExceptionChild(); 
        p.method(); 

    }
	
}
