import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

import java.util.*;

public class Maximum_Product {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in=new InputReader(System.in);    
        StringBuffer str=new StringBuffer();
        int t=in.nextInt();
        for(int i=0;i<t;i++) {
        	int n=in.nextInt();
        	int a[]=new int[n];
        	int count=0;
        	for(int j=0;j<n;j++) {
        		a[j]=in.nextInt();
        		if(a[j]>0)
        			count++;
        	}
        	Arrays.sort(a);
        	long product=1;
        	
        	if(count==0) {
        		if(a[n-1]==0)
        			product=0;
        		else {
        		for(int j=n-1;j>=n-5;j--)
        			product=product*a[j];
        		}
        	}
        	else if(count==1||count==2) {
        		product=product*a[n-1];
        		for(int j=0;j<4;j++)
        			product=product*a[j];
        	}
        	else if(count==3||count==4) {
        		long p1=1;
        		long p2=1;
        		p1=p1*a[n-1]*a[n-2]*a[n-3]*a[0]*a[1];
        		p2=p2*a[n-1]*a[0]*a[1]*a[2]*a[3];
        		product=Math.max(p1, p2);
        	}
        	else if(count>=5) {
        		long p1=1;
        		long p2=1;
        		long p3=1;
        		for(int j=n-1;j>=n-5;j--)
        			p3=p3*a[j];
        		p1=p1*a[n-1]*a[n-2]*a[n-3]*a[0]*a[1];
        		p2=p2*a[n-1]*a[0]*a[1]*a[2]*a[3];
        		product=Math.max(p1, Math.max(p2, p3));
        	}
        	System.out.println(product);
        }

	}
	
	static class InputReader{
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        public int read() {
            if (numChars == -1)
                throw new UnknownError();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        public int peek() {
            if (numChars == -1)
                return -1;
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar];
        }
 
        public void skip(int x) {
            while (x-- > 0)
                read();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
 
        public String nextString() {
            return next();
        }
 
        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public String nextLine() {
            StringBuffer buf = new StringBuffer();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r')
                    buf.appendCodePoint(c);
                c = read();
            }
            return buf.toString();
        }
 
        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
 
        public boolean hasNext() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1)
                read();
            return value != -1;
        }
        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }



}
