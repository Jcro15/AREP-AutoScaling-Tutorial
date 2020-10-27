package edu.escuelaing.arep.math;

import java.math.BigInteger;

public class Fibonacci {
    public static BigInteger calculateFibonacci(BigInteger n){
        BigInteger result;
        if(n.compareTo(BigInteger.ZERO)==0){
            result=BigInteger.ZERO;
        }
        else if(n.compareTo(BigInteger.ONE)==0){
            result =BigInteger.ONE;
        }
        else {
            result=BigInteger.ONE;
            BigInteger prev=BigInteger.ONE;
            for (BigInteger i = new BigInteger("3"); i.compareTo(n)<1 ; i=i.add(BigInteger.ONE)) {
                result=result.add(prev);
                prev=result.subtract(prev);
            }
        }
        return result;
    }
}
