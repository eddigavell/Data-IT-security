package JAVA.Lecture2;

import java.io.Serial;
import java.math.BigInteger;

public class KeyPair implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 4L;
    private BigInteger key;
    private BigInteger n;


    public KeyPair(BigInteger key, BigInteger n) {
        this.setKey(key);
        this.setN(n);
    }

    private void setN(BigInteger n) {
        this.n = n;
    }

    private void setKey(BigInteger key) {
        this.key = key;
    }

    public BigInteger getN() {
        return this.n;
    }

    public BigInteger getKey() {
        return this.key;
    }
}
