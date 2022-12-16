package uk.ac.rhul.cs2800;
/**
 * An interface for the Calculator. 
 * 
 * @author zkac152
 */
public interface Calculator{
    /**
     * Method used by the classes that implement this interface to evaluate String expressions.
     * 
     * @param p0 The string to be evaluated.
     * @return The float result of evaluating the expression.
     * @throws InvalidExpressionException if the string cannot be evaluated properly.
     */
    float evaluate(final String p0) throws InvalidExpressionException;
}