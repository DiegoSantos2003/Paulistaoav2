package model;

import java.time.LocalDate;

public class Jogo {
		private String NomeTimeA;
		private String NomeTimeB;
		private int GolsTimeA;
		private int GolsTimeB;
		private LocalDate Data;
		
		public String getNomeTimeA() {
			return NomeTimeA;
		}
		public void setNomeTimeA(String codigoTimeA) {
			NomeTimeA = codigoTimeA;
		}
		public String getNomeTimeB() {
			return NomeTimeB;
		}
		public void setNomeTimeB(String codigoTimeB) {
			NomeTimeB = codigoTimeB;
		}
		public int getGolsTimeA() {
			return GolsTimeA;
		}
		public void setGolsTimeA(int golsTimeA) {
			GolsTimeA = golsTimeA;
		}
		public int getGolsTimeB() {
			return GolsTimeB;
		}
		public void setGolsTimeB(int golsTimeB) {
			GolsTimeB = golsTimeB;
		}
		public LocalDate getData() {
			return Data;
		}
		public void setData(LocalDate localDate) {
			Data = localDate;
		}
		@Override
		public String toString() {
			return "Jogo [NomeTimeA=" + NomeTimeA + ", NomeTimeB=" + NomeTimeB + ", GolsTimeA=" + GolsTimeA
					+ ", GolsTimeB=" + GolsTimeB + ", Data=" + Data + "]";
		}
		
		
}
