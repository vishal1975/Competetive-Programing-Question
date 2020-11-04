import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;



public class Mortal_Combat_Tower {
	
	//x=1,2   1st friend chance
	//x=3,4   2nd friend chance
	
	public static int tower(int a[],int i,int x,int n,int dp[][]) {
		if(i>=n)
			return 0;
		if(dp[i][x]!=-1)
			return dp[i][x];

		if(x==1) {

			int z=a[i]+tower(a,i+1,2,n,dp);
			dp[i][x]=z;
			return z;
		}
		else if(x==2) {
			int count1=a[i]+tower(a,i+1,3,n,dp);
			int count2=tower(a,i,3,n,dp);
			int z=Math.min(count1, count2);
			dp[i][x]=z;
			return z;
		}
		else if(x==3) {
			int z=tower(a,i+1,4,n,dp);
			dp[i][x]=z;
			return z;
		}
		else  {
			int count1=tower(a,i+1,1,n,dp);
			int count2=tower(a,i,1,n,dp);
			int z=Math.min(count1, count2);
			dp[i][x]=z;
			return z;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InputReader in=new InputReader(System.in);    
        StringBuffer str=new StringBuffer();
        int t=in.nextInt();
        for(int i=0;i<t;i++) {
        	int n=in.nextInt();
        	int a[]=new int[n];
        	for(int j=0;j<n;j++)
        		a[j]=in.nextInt();
        	int dp[][]=new int[n+1][5];
        	for(int j=0;j<=n;j++) {
        		for(int h=0;h<5;h++) {
        			dp[j][h]=-1;
        		}
        	}
        		
        	
        	int count=tower(a,0,1,n,dp);
        	System.out.println(count);
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
