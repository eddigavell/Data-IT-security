package JAVA.RSA_Exercise;

import java.io.Serial;
import java.math.BigInteger;

public class KeyPair implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 4L;
    private final BigInteger key;
    private final BigInteger n;


    public KeyPair(BigInteger key, BigInteger n) {
        this.key = key;
        this.n = n;
    }

    public BigInteger getN() {
        return this.n;
    }

    public BigInteger getKey() {
        return this.key;
    }
}
