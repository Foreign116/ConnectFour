package countfour;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class board extends JFrame {
	private holes[][] cone = new holes[7][7];
	private char player = 'x';

	public board() throws IOException {
		this.setTitle("Connect Four");
		this.setVisible(true);
		this.setSize(1000, 1000);
		JPanel jp = new JPanel(new GridLayout(7, 7, 0, 0));
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				holes h = new holes();
				cone[i][j] = h;
				h.setrc(i, j);
				h.setid(0);
				h.settype(0);
				jp.add(h);
			}
		}
		this.add(jp);
		this.validate();
	}

	public void setspot(ImageIcon j, int col, int type) {
		if (cone[6][col].returnid() == 0) {
			cone[6][col].jlr().setIcon(j);
			cone[6][col].setid(1);
			cone[6][col].settype(type);

		} else if (cone[5][col].returnid() == 0) {
			cone[5][col].jlr().setIcon(j);
			cone[5][col].setid(1);
			cone[5][col].settype(type);

		} else if (cone[4][col].returnid() == 0) {
			cone[4][col].jlr().setIcon(j);
			cone[4][col].setid(1);
			cone[4][col].settype(type);

		} else if (cone[3][col].returnid() == 0) {
			cone[3][col].jlr().setIcon(j);
			cone[3][col].setid(1);
			cone[3][col].settype(type);

		} else if (cone[2][col].returnid() == 0) {
			cone[2][col].jlr().setIcon(j);
			cone[2][col].setid(1);
			cone[2][col].settype(type);

		} else if (cone[1][col].returnid() == 0) {
			cone[1][col].jlr().setIcon(j);
			cone[1][col].setid(1);
			cone[1][col].settype(type);

		} else if (cone[0][col].returnid() == 0) {
			cone[0][col].jlr().setIcon(j);
			cone[0][col].setid(1);
			cone[0][col].settype(type);
		}

	}

	public boolean ifwin4col(int col) {
		int q = 0;
		boolean worl = false;
		for (int i = 0; i < 7; i++) {
			if (cone[i][col].returntype() == 4) {
				q++;
			}
		}
		if (q == 4) {
			worl = true;
		}
		return worl;
	}

	public boolean ifwin6col(int col) {
		int q = 0;
		boolean worl = false;
		for (int i = 0; i < 7; i++) {
			if (cone[i][col].returntype() == 6) {
				q++;
			}
		}
		if (q == 4) {
			worl = true;
		}
		return worl;
	}

	public boolean ifwin4row() {
		int q = 0;
		int t = 0;
		String s = "";
		boolean worl = false;
		for (int i = 0; i < 7; i++) {
			for (int ii = 0; ii < 7; ii++) {
				s += cone[i][ii].returntype() + "";

			}
		}
		for (int p = 0; p < s.length(); p++) {
			if (s.charAt(p) == '4') {
				q++;
			} else {
				q = 0;
			}
			if (q == 4) {
				t = 1;
				break;
			}
		}

		if (t == 1) {
			worl = true;
		}
		return worl;
	}

	public boolean ifwin6row() {
		int q = 0;
		int t = 0;
		String s = "";
		boolean worl = false;
		for (int i = 0; i < 7; i++) {
			for (int ii = 0; ii < 7; ii++) {
				s += cone[i][ii].returntype() + "";

			}
		}
		for (int p = 0; p < s.length(); p++) {
			if (s.charAt(p) == '6') {
				q++;
			} else {
				q = 0;
			}
			if (q == 4) {
				t = 1;
				break;
			}
		}

		if (t == 1) {
			worl = true;
		}
		return worl;
	}

	public boolean d1L() {
		int t = 0;
		int p = 0;
		boolean tt = false;
		if (cone[0][3].returntype() == 4) {
			t++;
		} else if (cone[0][3].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (cone[1][4].returntype() == 4) {
			t++;
		} else if (cone[1][4].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (cone[2][5].returntype() == 4) {
			t++;
		} else if (cone[2][5].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (cone[3][6].returntype() == 4) {
			t++;
		} else if (cone[3][6].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		return tt;

	}

	public boolean d2L() {
		int t = 0;
		int p = 0;
		boolean tt = false;
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[0][2].returntype() == 4) {
			t++;
		} else if (cone[0][2].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[1][3].returntype() == 4) {
			t++;
		} else if (cone[1][3].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[2][4].returntype() == 4) {
			t++;
		} else if (cone[2][4].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[3][5].returntype() == 4) {
			t++;
		} else if (cone[3][5].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[4][6].returntype() == 4) {
			t++;
		} else if (cone[4][6].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}

		return tt;

	}

	public boolean d3L() {
		int t = 0;
		int p = 0;
		boolean tt = false;
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[0][1].returntype() == 4) {
			t++;
		} else if (cone[0][1].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[1][2].returntype() == 4) {
			t++;
		} else if (cone[1][2].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[2][3].returntype() == 4) {
			t++;
		} else if (cone[2][3].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[3][4].returntype() == 4) {
			t++;
		} else if (cone[3][4].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[4][5].returntype() == 4) {
			t++;
		} else if (cone[4][5].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[5][6].returntype() == 4) {
			t++;
		} else if (cone[5][6].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}

		return tt;

	}

	public boolean d4L() {
		int t = 0;
		int p = 0;
		boolean tt = false;
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[0][0].returntype() == 4) {
			t++;
		} else if (cone[0][0].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[1][1].returntype() == 4) {
			t++;
		} else if (cone[1][1].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[2][2].returntype() == 4) {
			t++;
		} else if (cone[2][2].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}

		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[3][3].returntype() == 4) {
			t++;
		} else if (cone[3][3].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[4][4].returntype() == 4) {
			t++;
		} else if (cone[4][4].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[5][5].returntype() == 4) {
			t++;
		} else if (cone[5][5].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[6][6].returntype() == 4) {
			t++;
		} else if (cone[6][6].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}

		return tt;

	}

	public boolean d5L() {
		int t = 0;
		int p = 0;
		boolean tt = false;
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[1][0].returntype() == 4) {
			t++;
		} else if (cone[1][0].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[2][1].returntype() == 4) {
			t++;
		} else if (cone[2][1].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[3][2].returntype() == 4) {
			t++;
		} else if (cone[3][2].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[4][3].returntype() == 4) {
			t++;
		} else if (cone[4][3].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[5][4].returntype() == 4) {
			t++;
		} else if (cone[5][4].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[6][5].returntype() == 4) {
			t++;
		} else if (cone[6][5].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		return tt;

	}

	public boolean d6L() {
		int t = 0;
		int p = 0;
		boolean tt = false;
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[2][0].returntype() == 4) {
			t++;
		} else if (cone[2][0].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[3][1].returntype() == 4) {
			t++;
		} else if (cone[3][1].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[4][2].returntype() == 4) {
			t++;
		} else if (cone[4][2].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[5][3].returntype() == 4) {
			t++;
		} else if (cone[5][3].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[6][4].returntype() == 4) {
			t++;
		} else if (cone[6][4].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}

		return tt;
	}

	public boolean d7L() {
		int t = 0;
		int p = 0;
		boolean tt = false;

		if (cone[3][0].returntype() == 4) {
			t++;
		} else if (cone[3][0].returntype() == 6) {
			p++;
		} else {
			t = 0;
			p = 0;
		}
		if (cone[4][1].returntype() == 4) {
			t++;
		} else if (cone[4][1].returntype() == 6) {
			p++;
		} else {
			t = 0;
			p = 0;
		}
		if (cone[5][2].returntype() == 4) {
			t++;
		} else if (cone[5][2].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (cone[6][3].returntype() == 4) {
			t++;
		} else if (cone[6][3].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}

		return tt;

	}

	public boolean d1() {
		int t = 0;
		int p = 0;
		boolean tt = false;
		if (cone[0][3].returntype() == 4) {
			t++;
		} else if (cone[0][3].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (cone[1][2].returntype() == 4) {
			t++;
		} else if (cone[1][2].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (cone[2][1].returntype() == 4) {
			t++;
		} else if (cone[2][1].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (cone[3][0].returntype() == 4) {
			t++;
		} else if (cone[3][0].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		return tt;

	}

	public boolean d2() {
		int t = 0;
		int p = 0;
		boolean tt = false;
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[0][4].returntype() == 4) {
			t++;
		} else if (cone[0][4].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[1][3].returntype() == 4) {
			t++;
		} else if (cone[1][3].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[2][2].returntype() == 4) {
			t++;
		} else if (cone[2][2].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[3][1].returntype() == 4) {
			t++;
		} else if (cone[3][1].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[4][0].returntype() == 4) {
			t++;
		} else if (cone[4][0].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}

		return tt;

	}

	public boolean d3() {
		int t = 0;
		int p = 0;
		boolean tt = false;
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[0][5].returntype() == 4) {
			t++;
		} else if (cone[0][5].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[1][4].returntype() == 4) {
			t++;
		} else if (cone[1][4].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[2][3].returntype() == 4) {
			t++;
		} else if (cone[2][3].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[3][2].returntype() == 4) {
			t++;
		} else if (cone[3][2].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[4][1].returntype() == 4) {
			t++;
		} else if (cone[4][1].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[5][0].returntype() == 4) {
			t++;
		} else if (cone[5][0].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}

		return tt;

	}

	public boolean d4() {
		int t = 0;
		int p = 0;
		boolean tt = false;
		if (cone[0][6].returntype() == 4) {
			t++;
		} else if (cone[0][6].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[1][5].returntype() == 4) {
			t++;
		} else if (cone[1][5].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[2][4].returntype() == 4) {
			t++;
		} else if (cone[2][4].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[3][3].returntype() == 4) {
			t++;
		} else if (cone[3][3].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[4][2].returntype() == 4) {
			t++;
		} else if (cone[4][2].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[5][1].returntype() == 4) {
			t++;
		} else if (cone[5][1].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[6][0].returntype() == 4) {
			t++;
		} else if (cone[6][0].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}

		return tt;

	}

	public boolean d5() {
		int t = 0;
		int p = 0;
		boolean tt = false;
		if (cone[1][6].returntype() == 4) {
			t++;
		} else if (cone[1][6].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[2][5].returntype() == 4) {
			t++;
		} else if (cone[2][5].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[3][4].returntype() == 4) {
			t++;
		} else if (cone[3][4].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[4][3].returntype() == 4) {
			t++;
		} else if (cone[4][3].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[5][2].returntype() == 4) {
			t++;
		} else if (cone[5][2].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[6][1].returntype() == 4) {
			t++;
		} else if (cone[6][1].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		return tt;

	}

	public boolean d6() {
		int t = 0;
		int p = 0;
		boolean tt = false;
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[2][6].returntype() == 4) {
			t++;
		} else if (cone[2][6].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[3][5].returntype() == 4) {
			t++;
		} else if (cone[3][5].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[4][4].returntype() == 4) {
			t++;
		} else if (cone[4][4].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}

		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[5][3].returntype() == 4) {
			t++;
		} else if (cone[5][3].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}
		if (cone[6][2].returntype() == 4) {
			t++;
		} else if (cone[6][2].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}

		return tt;
	}

	public boolean d7() {
		int t = 0;
		int p = 0;
		boolean tt = false;
		if (cone[3][6].returntype() == 4) {
			t++;
		} else if (cone[3][6].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (cone[4][5].returntype() == 4) {
			t++;
		} else if (cone[4][5].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (cone[5][4].returntype() == 4) {
			t++;
		} else if (cone[5][4].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (cone[6][3].returntype() == 4) {
			t++;
		} else if (cone[6][3].returntype() == 6) {
			p++;
		} else {
			p = 0;
			t = 0;
		}
		if (t == 4 || p == 4) {
			tt = true;
		}

		return tt;

	}

	public class holes extends JPanel {
		private JLabel jl;
		private int id;
		private int Row;
		private int Col;
		private int type;

		public holes() throws IOException {
			jl = new JLabel();
			this.setBackground(Color.black);
			jl.setSize(new Dimension(this.getWidth(), this.getHeight()));
			jl.setVisible(true);
			java.net.URL url = holes.class.getResource("/resources/cf.png");
			jl.setIcon(new ImageIcon(url));
			add(jl);
			this.setVisible(true);
			this.setBorder(new LineBorder(Color.black, 1));
			addMouseListener(new MyMouseListener());
		}

		public int returnid() {
			return id;
		}

		public JLabel jlr() {
			return jl;
		}

		public void setid(int i) {
			id = i;
		}

		public void setrc(int row, int col) {
			Col = col;
			Row = row;
		}

		public int rrow() {
			return Row;
		}

		public int rcol() {
			return Col;
		}

		public void settype(int r) {
			type = r;
		}

		public int returntype() {
			return type;
		}

		private class MyMouseListener extends MouseAdapter {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (returnid() == 0) {
					if (player == 'x') {
						java.net.URL url = MyMouseListener.class.getResource("/resources/cfy.png");
						ImageIcon i = new ImageIcon(url);
						int p = rcol();
						setspot(i, p, 6);
						player = 'o';
					} else if (player == 'o') {
						java.net.URL url = MyMouseListener.class.getResource("/resources/cfr.png");
						ImageIcon i = new ImageIcon(url);
						int p = rcol();
						setspot(i, p, 4);
						player = 'x';
					}
				}
				if (ifwin4col(rcol())) {
					player = 'P';
					System.out.println("yay red won");
				}
				if (ifwin6col(rcol())) {
					player = 'w';
					System.out.println("Yay yellow won");
				}
				if (ifwin4row()) {
					player = 'P';
					System.out.println("Yay red won");
				}
				if (ifwin6row()) {
					player = 'w';
					System.out.println("Yay yellow won");
				}
				if (d1() || d2() || d3() || d4() || d5() || d6() || d7()) {
					player = 'Y';
					System.out.println("Winner");
				}
				if (d1L() || d2L() || d3L() || d4L() || d5L() || d6L() || d7L()) {
					player = 'Y';
					System.out.println("Winner");
				}

			}

		}

	}

}
