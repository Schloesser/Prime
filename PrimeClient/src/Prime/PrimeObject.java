package Prime;

import java.io.Serializable;

/**
 * This class represents a Prime. The serialVersionUID has to be the same as the serialVersionUID on the server!!!
 * CHANGING THIS CLASS WITHOUT SYNCHRONIZE ON SERVER WILL RISE AN EXCEPTION !!!!!!!!!!!
 */
public class PrimeObject implements Serializable{

    private static final long serialVersionUID = 20120431155421L;

    private int prime;

    public PrimeObject(int prime)
    {
        this.prime = prime;
    }

    public int getPrime()
    {
        return prime;
    }
    public void setPrime(int prime)
    {
        this.prime = prime;
    }

    @Override
    public String toString()
    {
        return "[ " + String.valueOf(prime) + " ]";
    }
}
