import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;



public class Sky_Jumper {
	public static boolean possible(int i,int j,int a[]) {
		if(i+1==j)
			return true;
		int x=Math.max(a[i],a[j]);
		int y=Math.min(a[i],a[j]);
		int max=0;
		int min=Integer.MAX_VALUE;
		for(int h=i+1;h<j;h++) {
			if(a[h]>max)
				max=a[h];
			if(a[h]<min)
				min=a[h];
		}
		if(max<y)
			return true;
		if(x<min)
			return true;
		return false;
	}
	
	public static int jumper(int i,int j,int a[],int dp[]) {
		if(j>=a.length&&i==a.length-1)
			return 0;
		else if(j>=a.length&&i!=a.length-1)
			return a.length+1;
		if(dp[i]!=-1)
			return dp[i];
		int count1=a.length+1;
		int count2=0;
		if(possible(i,j,a)) {
			count1=1+jumper(j,j+1,a,dp);
		}
		count2=jumper(i,j+1,a,dp);
		int z=Math.min(count1,count2);
		dp[i]=z;
		return z;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in=new InputReader(System.in);    
        StringBuffer str=new StringBuffer();
        int n=in.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        	a[i]=in.nextInt();
		int dp[]=new int[a.length+1];
		for(int j=0;j<=a.length;j++) {
			dp[j]=-1;
		}
		int result=jumper(0,1,a,dp);
		System.out.println(result);
		

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
