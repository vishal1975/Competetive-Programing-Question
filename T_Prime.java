import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;



public class T_Prime {
	
	
	
	static boolean isPerfectSquare(double x)  
    { 
          
        
        double sr = Math.sqrt(x); 
      
        
        return ((sr - Math.floor(sr)) == 0); 
    } 
	
	
	
	
	public static void check_Prime(boolean a[],int n) {
		
		a[1]=true;
		a[2]=true;
		for(int i=3;i<=n;i=i+2) {
			a[i]=true;
		}
		
		for(int i=2;i*i<=n;i++) {
			
			if(a[i]==true) {
				
				for(int j=i*i;j<=n;j=j+i) {
					a[j]=false;
				}
				
			}
			
		}
		
		
		
		
		
		
		
		
	}
	
	public static boolean final1(ArrayList<Integer> pk,int i,int j,int k) {
		if(i>j) {
			return false;
		}
		int mid=(i+j)/2;
		
		if(pk.get(mid)==k) {
			return true;
		}
		else if(pk.get(mid)>k) {
			return final1(pk,i,mid-1,k);
		}
		else {
			return final1(pk,mid+1,j,k);
		}
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		InputReader in=new InputReader(System.in);                     
        StringBuffer str=new StringBuffer();   
		int n=in.nextInt();
		long a1[]=new long[n];
		for(int j=0;j<n;j++) {
			a1[j]=in.nextLong();
		}
		
		boolean a[]=new boolean[1000000+1];
		
		check_Prime(a,1000000);
		ArrayList<Integer> pk=new ArrayList<>();
		for(int j=1;j<=1000000;j++) {
			if(a[j]==true)
			pk.add(j);
		}
		for(int i=0;i<n;i++) {
			if(a1[i]==1) {
				System.out.println("NO");
			}
			else {
			if(isPerfectSquare(a1[i])) {
				if(final1(pk,0,pk.size()-1,(int)Math.sqrt(a1[i]))) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
				
			}
			else {
				System.out.println("NO");
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
