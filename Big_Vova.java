import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

import java.util.*;

public class Big_Vova {
	public static int gcd(int a,int b) {
		if(a%b==0)
			return b;
		return gcd(b,a%b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InputReader in=new InputReader(System.in);    
        StringBuffer str=new StringBuffer();
        int t=in.nextInt();
        for(int i=0;i<t;i++) {
        	int n=in.nextInt();
        	int a[]=new int[n];
        	int b[]=new int[n];
        	Queue<Integer> ll=new LinkedList<Integer>();
        	int max=0;
        	int pos=0;
        	for(int j=0;j<n;j++) {
        		int h=in.nextInt();
        		a[j]=h;
        		if(h>max) {
        			max=h;
        			pos=j;
        		}
        	}
        	ll.add(max);
        	b[pos]=1;
        	int gcd=max;
        	while(ll.size()<n) {
        		
        	  max=0;
        	  pos=0;
        	  
        	  for(int j=0;j<n;j++) {
        		  if(b[j]==1)
        			  continue;
        		  int h=a[j];
        		  int c=gcd(gcd,h);
        		  if(c!=1) {
        			  if(c>max) {
        				  max=c;
        				  pos=j;
        				  //gcd=c;
        			  }
//        			  else if(b==max) {
//        				  if(h>pk.get(j)) {
//        					  max=b;
//        					  pos=j;
//        				  }
//        			  }
        		  }
        	  }
        	  if(max==0)
        		  break;
        	  else {
        		  b[pos]=1;
        		  ll.add(a[pos]);
        		  gcd=max;
        		 // System.out.println(gcd+" "+pos);
        	  }
        	}
        //	Collections.sort(pk,Collections.reverseOrder());
        	for(int j=0;j<n;j++) {
        		if(b[j]!=1)
        		ll.add(a[j]);
        	}
        	
        	while(!ll.isEmpty()) {
        		System.out.print(ll.poll()+" ");
        	}
        	System.out.println();
        	
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
