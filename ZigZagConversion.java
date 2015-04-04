package easy;

public class ZigZagConversion {
	public String convert(String s, int nRows) {	
		StringBuffer[] sb = new StringBuffer[nRows];
		for (int i = 0; i < sb.length; i++)	sb[i] = new StringBuffer();
		int len = s.length();
		int i = 0;
		while (i < len) {
			for (int j = 0; j < nRows && i < len; j++) {
				sb[j].append(s.charAt(i++));
			}
			for (int j = nRows - 2; j > 0 && i < len; j--) {
				sb[j].append(s.charAt(i++));
			}
		}
		for (int k = 1; k < nRows; k++)	sb[0].append(sb[k]);
		return sb[0].toString();
    }
	
	/*public static void main(String[] args) {
		ZigZagConversion zz = new ZigZagConversion();
		System.out.println(zz.convert("PAYPALISHIRING", 3));
	}*/
}
