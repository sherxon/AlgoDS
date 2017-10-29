package cryptography.des.java;

public class DES {

	private String key;

	private String message;

	private String[] keys = new String[17];

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = Converter.convertToBinaryCode(key);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = Converter.convertToBinaryCode(message);
	}

	public String encrypt() {
		String messageAfterPermutation = messagePermutation(message);

		String[] L = new String[17];
		String[] R = new String[17];
		String[] Rtemp = new String[17];

		L[0] = messageAfterPermutation.substring(0, 32);
		R[0] = messageAfterPermutation.substring(32);

		String[] B = new String[9];

		generateKeys(key);

		for (int i = 1; i <= 16; i++) {
			L[i] = R[i-1];
			String Er = E(R[i-1]);

			Rtemp[i] = xor(Er, keys[i]);
			B[1] = Rtemp[i].substring(0, 6);
			B[2] = Rtemp[i].substring(6, 12);
			B[3] = Rtemp[i].substring(12, 18);
			B[4] = Rtemp[i].substring(18, 24);
			B[5] = Rtemp[i].substring(24, 30);
			B[6] = Rtemp[i].substring(30, 36);
			B[7] = Rtemp[i].substring(36, 42);
			B[8] = Rtemp[i].substring(42);

			String[] C = new String[9];

			for (int j = 1; j < 9; j++) {
				C[j] = sBox(j, B[j]);

				if (C[j].length() == 3) {
					C[j] = "0" + C[j];
				} else if (C[j].length() == 2) {
					C[j] = "00" + C[j];
				} else if (C[j].length() == 1) {
					C[j] = "000" + C[j];
				} else if (C[j].length() == 0) {
					C[j] = "0000" + C[j];
				}
			}

			String cFinal = "";
			for (int j = 1; j < C.length; j++) {
				cFinal += C[j];
			}

			cFinal = cPermute(cFinal);

			R[i] = xor(L[i-1], cFinal);
		}

		return lastInverse(R[16]+L[16]);
	}

	private String messagePermutation(String input) {
		int[] positionTable = { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4,
								62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8,
								57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3,
								61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 };

		StringBuilder newMessage = new StringBuilder();

		for (int position : positionTable) {
			newMessage.append(input.substring(position - 1, position));
		}

		return newMessage.toString();
	}

	private void generateKeys(String key) {
		key = beginKeyPermutation(key);

		String c = key.substring(0, 28);
		String d = key.substring(28, key.length());

		for (int i = 1; i < 17; i++) {
			c = leftShiftBits(c, i);
			d = leftShiftBits(d, i);
			keys[i] = finishKeyPermutation(c + d);
		}
	}

	private String beginKeyPermutation(String input) {
		int[] positionTable = { 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18,
								10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36,
								63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22,
								14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4 };

		StringBuilder newKey = new StringBuilder();

		for (int position : positionTable) {
			newKey.append(input.substring(position - 1, position));
		}

		return newKey.toString();
	}

	private String leftShiftBits(String input, int step) {
		int[] shift = { 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 };
		String shifted = input;

		for (int j = 0; j < shift[step - 1]; j++) {
			shifted = shifted.substring(1, shifted.length()) + shifted.substring(0, 1);
		}

		return shifted;
	}

	private String finishKeyPermutation(String input) {
		int[] positionTable = { 14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4,
								26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40,
								51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32 };

		StringBuilder newKey = new StringBuilder();

		for (int position : positionTable) {
			newKey.append(input.substring(position - 1, position));
		}
		return newKey.toString();
	}

	private String E(String input) {
		int[] positionTable = { 32, 1, 2, 3, 4, 5,
								4, 5, 6, 7, 8, 9,
								8, 9, 10, 11, 12, 13,
								12, 13, 14, 15, 16, 17,
								16, 17, 18, 19, 20, 21,
								20, 21, 22, 23, 24, 25,
								24, 25, 26, 27, 28, 29,
								28, 29, 30, 31, 32, 1 };

		StringBuilder newR = new StringBuilder();

		for (int position : positionTable) {
			newR.append(input.substring(position - 1, position));
		}

		return newR.toString();
	}

	private static String xor(String x1, String x2) {
		StringBuilder out = new StringBuilder();
		int len;
		int start;

		if (x1.length() < x2.length()) {
			len = x1.length();
			start = x2.length() - x1.length();
			out.append(x2.substring(0, start));
			x2 = x2.substring(start);
		} else {
			len = x2.length();
			start = x1.length() - x2.length();
			out.append(x1.substring(0, start));
			x1 = x1.substring(start);
		}

		for (int i = 0; i < len; i++) {
			String s1 = x1.substring(i, i + 1);
			String s2 =x2.substring(i, i + 1);
			out.append(Integer.parseInt(x1.substring(i, i + 1)) ^ Integer.parseInt(x2.substring(i, i + 1)));
		}

		return out.toString();
	}

	private String sBox(int boxNumber, String b) {
		int[] sbox1 = { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7,
						0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8,
						4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0,
						15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 };

		int[] sBox2 = { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10,
						3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5,
						0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15,
						13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 };

		int[] sBox3 = { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8,
						13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1,
						13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7,
						1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 };

		int[] sBox4 = { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15,
						13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9,
						10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4,
						3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 };

		int[] sBox5 = { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9,
						14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6,
						4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14,
						11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 };

		int[] sBox6 = { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11,
						10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8,
						9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6,
						4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 };

		int[] sBox7 = { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1,
						13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6,
						1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2,
						6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 };

		int[] sBox8 = { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7,
						1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2,
						7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8,
						2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 };

		String temp = b.substring(0, 1) + b.substring(5);
		int row = Integer.parseInt(temp,2);
		int col = Integer.parseInt(b.substring(1, 5), 2);

		row = row * 16;

		switch (boxNumber) {
			case 1:
				return Integer.toBinaryString(sbox1[(row + col)]);
			case 2:
				return Integer.toBinaryString(sBox2[(row + col)]);
			case 3:
				return Integer.toBinaryString(sBox3[(row + col)]);
			case 4:
				return Integer.toBinaryString(sBox4[(row + col)]);
			case 5:
				return Integer.toBinaryString(sBox5[(row + col)]);
			case 6:
				return Integer.toBinaryString(sBox6[(row + col)]);
			case 7:
				return Integer.toBinaryString(sBox7[(row + col)]);
			case 8:
				return Integer.toBinaryString(sBox8[(row + col)]);
		}

		return null;
	}

	private String cPermute(String input) {
		int[] positionTable = { 16, 7, 20, 21, 29, 12, 28, 17,
					1, 15, 23, 26, 5, 18, 31, 10,
					2, 8, 24, 14, 32, 27, 3, 9,
					19, 13, 30, 6, 22, 11, 4, 25 };

		StringBuilder newC = new StringBuilder();

		for (int position : positionTable) {
			newC.append(input.substring(position - 1, position));
		}

		return newC.toString();
	}

	private String lastInverse(String input) {
		int[] positionTable = { 40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31,
								38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29,
								36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27,
								34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25 };

		StringBuilder inverse = new StringBuilder();

		for (int position : positionTable) {
			inverse.append(input.substring(position - 1, position));
		}

		return inverse.toString();
	}

}
