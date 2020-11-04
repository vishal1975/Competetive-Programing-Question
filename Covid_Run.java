import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class Covid_Run {
	
	public static boolean Are_You_Covid_safe(boolean c[],int x,int y,int k,int n) {
		if(c[x]) {
			return true;
		}
		else if(x==y) {
			return false;
			
		}
		c[x]=true;
		return Are_You_Covid_safe(c,(x+k)%n,y,k,n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Scanner sc=new Scanner(System.in);
		InputReader in=new InputReader(System.in);    
        StringBuffer str=new StringBuffer();
		int t = 0;
		if(in.hasNext()) {
			t=in.nextInt();
		}
		for(int i=0;i<t;i++) {
			int n=0,k=0,x=0,y=0;
			if(in.hasNext()) {
			 n=in.nextInt();
			 k=in.nextInt();
			 x=in.nextInt();
			 y=in.nextInt();
			}
			if(y==x) {
				System.out.println("YES");
			}
			else if(k==0) {
				if(y==x) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
			else {
//			int distance=y-x;
//			if(distance%k==0) {
//				System.out.println("YES");
//			}
//			else {
//				System.out.println("NO");
//			}
				boolean c[]=new boolean[n];
				for(int j=0;j<n;j++) {
					c[j]=false;
				}
				if(Are_You_Covid_safe(c,x,y,k,n)) {
					System.out.println("NO");
				}
				else {
					System.out.println("YES");
				}
			}
			
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



