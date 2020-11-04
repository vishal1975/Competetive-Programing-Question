import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;



public class Balanced_Bitstring {
	static String t1;
	public static int count(String s) {
		int count1=0;
	    int count2=0;
	    for(int i=0;i<s.length();i++) {
	    	if(s.charAt(i)=='0')
	    		count1++;
	    	else
	    		count2++;
	    }
	    if(count1==count2)
	    	return 1;
	    else 
	    	return 0;
	}
	
	public static int bitstring(String s,int i) {
		if(i>=s.length()) {
			int h=count(s);
			return h;
		}
		if(s.charAt(i)!='?')
			return bitstring(s,i+1);
		else {
			String str = s.substring(0, i) 
		              + '0'
		              + s.substring(i + 1);  
	        int z=bitstring(str,i+1);
	        if(z==1)
	        	return z;
	        else {
	        	String str1 = s.substring(0, i) 
			              + '1'
			              + s.substring(i + 1);  
	        	return bitstring(str1,i+1);
	        }
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InputReader in=new InputReader(System.in);    
        StringBuffer str=new StringBuffer();
        int t=in.nextInt();
        for(int i=0;i<t;i++) {
        	int n=in.nextInt();
        	int k=in.nextInt();
        	String s=in.next();
        	t1=s;
        	int h=k;
        	int flag=0;
        	for(int j=0;j<n&&h<=n;j++) {
        		String s1=t1.substring(j,h);
        		
        		int z=bitstring(t1,0);
        		if(z==0) {
        			flag=1;
        			break;
        		}
        		h++;
        		
        	}
        	if(flag==1)
        		System.out.println("NO");
        	else
        		System.out.println("YES");
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
