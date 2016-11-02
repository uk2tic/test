//import java.io.File;
//
//import javax.swing.JTable;
//
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;
//
//public class Handbook {
//
//	private String[] columns = new String[0];
//	private int[] widths = new int[0];
//	private Row[] rows = new Row[0];
//	public static int LecturTimeCol;
//	public static int lecturNameCol;
//	public static int lecturNumCol;
//	public static int lecturClassNumCol;
//	public static int lecturDayAndNight;
//
//	static TimeParser parser = new TimeParserV1();
//
//	public int[] getWidths() {
//		return this.widths;
//	}
//
//	public String[] getColumns() {
//		return this.columns;
//	}
//
//	public Row[] getRows() {
//		return this.rows;
//	}
//
//	public Handbook(String path) {
//		load(path);
//	}
//
//	public Handbook(File file) {
//		load(file);
//	}
//
//	public void load(File file) {
//		Workbook wb = null;
//		try {
//			wb = Workbook.getWorkbook(file);	//�������� ����
//			Sheet sheet = wb.getSheet(0);	//ù��° ��Ʈ�� ����.
//			this.columns = new String[sheet.getColumns() - 3]; //�����Ͱ� ��ϵ� column(����)�� ��
//			this.widths = new int[this.columns.length];	//this.columns[]�� ����
//			Cell[] cells = sheet.getRow(0);	//Ư�� ��ġ�� ���� ���´�.
//
//			for (int i = 0; i < this.columns.length; i++) {
//				this.columns[i] = cells[i].getContents().trim();
//				this.widths[i] = (this.columns[i].length() * 17);
//				if (this.columns[i].contains("���ǽð�")) {
//					LecturTimeCol = i;
//				}
//				if (this.columns[i].equals("�����")) {
//					lecturNameCol = i;
//					this.widths[i] = 110;
//				}
//				if (this.columns[i].contains("������ȣ")) {
//					lecturNumCol = i;
//					this.widths[i] = 50;
//				}
////				if (this.columns[i].contains("�й�")) {
////					lecturClassNumCol = i;
////				}
////				if (this.columns[i].contains("�־�")) {
////					lecturDayAndNight = i;
////				}
//			}
//
//			this.rows = new Row[sheet.getRows() - 1];
//			for (int i = 0; i < this.rows.length; i++) {
//				this.rows[i] = new Row(sheet.getRow(i + 1));
//			}
//			
//			wb.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void load(String path) {
//		load(new File(path));
//	}
//
//	public static void main(String[] args) {
//		Handbook handbook = new Handbook("�������.xls");
//		for (Row row : handbook.rows) {
//			System.out.println(row);
//		}
//		System.out.println(LecturTimeCol);
//	}
//
//	public static class Row {
//		private Object[] columns;
//
//		public Row(Cell[] cells) {
//			this.columns = new Object[cells.length];
//			for (int i = 0; i < cells.length; i++) {
//				this.columns[i] = cells[i].getContents();
//			}
//			this.columns[Handbook.LecturTimeCol] = Handbook.parser
//					.parse(this.columns[Handbook.lecturDayAndNight].toString()
//							+ this.columns[Handbook.LecturTimeCol].toString());
//		}
//
//		public Row(String[] columns) {
//			this.columns = new Object[columns.length];
//			for (int i = 0; i < columns.length; i++) {
//				this.columns[i] = columns[i];
//			}
//			this.columns[Handbook.LecturTimeCol] = Handbook.parser
//					.parse(columns[Handbook.lecturDayAndNight] + columns[Handbook.LecturTimeCol]);
//		}
//
//		public Row(JTable table, int row) {
//			this.columns = new Object[table.getColumnCount()];
//			for (int column = 0; column < this.columns.length; column++)
//				this.columns[column] = table.getValueAt(row, column);
//		}
//
//		public String toString() {
//			StringBuilder sb = new StringBuilder();
//			for (Object s : this.columns) {
//				sb.append(s).append(",");
//			}
//			sb.deleteCharAt(sb.length() - 1);
//			return sb.toString();
//		}
//
//		public Object[] getColumns() {
//			return this.columns;
//		}
//
//		public String[] toSimpleString() {
//			String[] strings = new String[2];
//			strings[0] = this.columns[Handbook.lecturNameCol].toString();
//			strings[1] = (this.columns[Handbook.lecturNumCol].toString() + "-"
//					+ this.columns[Handbook.lecturClassNumCol].toString());
//
//			return strings;
//		}
//	}
//
//}
