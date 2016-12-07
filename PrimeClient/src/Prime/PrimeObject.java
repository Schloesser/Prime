package Prime;

import java.io.Serializable;

/**
 * This class represents a Prime. The serialVersionUID has to be the same as the serialVersionUID on the server!!!
 * CHANGING THIS CLASS WITHOUT SYNCHRONIZE THE SERVER WILL RISE AN EXCEPTION !!!!!!!!!!!
 * If you don't know exactly what this class is doing, don't think about playing god.
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
