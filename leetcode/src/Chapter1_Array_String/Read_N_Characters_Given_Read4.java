package Chapter1_Array_String;

/**
 * 15. Read N Characters Given Read4
 * 
 * Question:
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. 
 * For example, it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * Note: The read function will only be called once for each test case.
 */
public class Read_N_Characters_Given_Read4 {

	/*public int read(char[] buf, int n) {
		char[] buffer = new char[4];
		int readBytes = 0;
		boolean eof = false;
		while (!eof && readBytes < n) {
			int sz = read4(buffer);
			if (sz < 4)	eof = true;
			int bytes = Math.min(n - readBytes, sz);
			System.arraycopy(buffer src, 0 srcPos, buf dest, 
					readBytes destPos, bytes length);
			readBytes += bytes;
		}
		return readBytes;
	}*/
}
/*
 * Follow up:
 * What if read could be called multiple times? 
 * See Question [16. Read N Characters Given Read4 – Call multiple times].
 */