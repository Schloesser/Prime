package Client;

/**
 * This class represents a Prime
 */
public class PrimeObject {
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
        return String.valueOf(prime);
    }
}
