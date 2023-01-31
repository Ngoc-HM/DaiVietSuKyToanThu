import java.awt.Color;
import javax.swing.JButton;

public class Cell extends JButton {
   private int i, j;

   public Cell(int x, int y) {
      this.i = x;
      this.j = y;
      this.setBackground(Color.WHITE);
   }

   public int getI() {
      return i;
   }

   public int getJ() {
      return j;
   }

   public void setValue(int num) {
      super.setText(num + "");
   }
}
