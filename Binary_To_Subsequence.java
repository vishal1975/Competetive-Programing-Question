import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.*;;

public class Binary_To_Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		InputReader in=new InputReader(System.in);    
        StringBuffer str=new StringBuffer();
        int t=in.nextInt();
        for(int i=0;i<t;i++) {
        	Map<Integer,String> pk=new TreeMap<Integer,String>();
        	int n=in.nextInt();
        	String s=in.next();
        	int h=0;
        	int k=0;
        	if(n>0) {
        	 k=1;
        	}
        	int count=0;
        	if(n==0) {
        		count=1;
        		System.out.println(count);
        		System.out.println("1");
        	}
        	else {
        		while(h<s.length()&&k<s.length()) {
        			if(s.charAt(k)!=s.charAt(k-1)) {
        				k++;
        			}
        			else if(s.charAt(k)==s.charAt(k-1)) {
        				count++;
        				pk.put(count,s.substring(h,k));
        				h=k;
        				k=h+1;
        				
        			}
        		}
        		pk.put(count+1,s.substring(h,k));
        	}
        	//System.out.println(pk.values());
        	
        	
        	ArrayList<Integer> lol=new ArrayList<Integer>(pk.keySet());
        	for(int j=0;j<lol.size();j++) {
        		int p=lol.get(j);
        		char c=pk.get(p).charAt(0);
        		for(int m=j+1;m<lol.size();m++) {
        			char x=pk.get(lol.get(m)).charAt(0);
        			
        			if(c!=x) {
        				pk.put(p,pk.get(p)+pk.get(lol.get(m)));
        				lol.remove(m);
        				
        			}
        		}
        	}
        	for(int z:lol) {
        		System.out.print(z+" "+pk.get(z));
        		System.out.println();
        	}
//        	Set ll=pk.entrySet();
//        	Iterator itr=ll.iterator();
//        	while(itr.hasNext()) {
//        		Map.Entry me=(Map.Entry) itr.next();
//        		System.out.print(me.getKey()+" : "+me.getValue());
//        		System.out.println();
//        	}
        	
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
