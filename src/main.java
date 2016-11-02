import java.io.File;

import javax.swing.JFileChooser;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class main {

	public static void main(String args[]) {

		JFileChooser fc = new JFileChooser();
		File file = null;

		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
		}

		try {
			Workbook wb = null;
			wb = Workbook.getWorkbook(file);
			Sheet sheet = wb.getSheet(0);

			int rowCount = sheet.getRows(); // 시트의 총 행수
			int colCount = sheet.getColumns(); // 시트의 총 열수

			String[][] data = new String[rowCount][colCount];

			for (int i = 0; i < rowCount; i++) {
				for (int n = 0; n < colCount; n++) {
					Cell cell = sheet.getCell(n, i);
					if (cell == null)
						continue;
					data[i][n] = cell.getContents(); // 해당 쉘의 데이타 가져오기
				}
			}

			// 데이타 출력 구문
			for (int r = 0; r < data.length; r++) {
				for (int h = 0; h < data[r].length; h++) {
					System.out.print(data[r][h] + " ");
				}
				System.out.println("");
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
