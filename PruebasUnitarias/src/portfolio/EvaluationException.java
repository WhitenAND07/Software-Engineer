/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portfolio;

/**
 *
 * @author Jordi Blanco
 */
class EvaluationException extends Exception {
    String message;
    /**
     * Constructor
     * @param message (String) 
     */
    public EvaluationException(String message){
        this.message = message;
    }
}
