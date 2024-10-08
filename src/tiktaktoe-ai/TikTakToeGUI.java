
// Imports
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// Main class extends JPanel (swing)
public class TikTakToeGUI extends JPanel {
  // Instance variables
  char playerSign = 'X';
  int cells = 9;
  int rows = 3;
  int columns = 3;
  JButton[] btns = new JButton[cells];

  // Main constructor of the class
  public TikTakToeGUI() {
    // Create a new grid for tic-tac-toe
    GridLayout ticTacToeGridLayout = new GridLayout(rows, columns);
    setLayout(ticTacToeGridLayout);
    createButtons();
  }

  // createButtons() method
  public void createButtons() {
    // For loop that creates each of the nine buttons
    for (int i = 0; i < cells; i++) {
      JButton btn = new JButton();
      btn.setBackground(Color.WHITE);
      btn.setBorder(new LineBorder(Color.BLACK));
      btns[i] = btn;

      btns[i].setText("");

      btns[i].addActionListener(e -> {
        JButton btnClicked = (JButton) e.getSource();
        btnClicked.setBackground(Color.BLACK);
        btnClicked.setForeground(Color.WHITE);
        btnClicked.setBorder(new LineBorder(Color.WHITE));
        btnClicked.setText(String.valueOf(playerSign));
        /*
         * try {
         * Image img = (playerSign == 'X') ?
         * ImageIO.read(getClass().getResource("X.png")) :
         * ImageIO.read(getClass().getResource("O.jpg"));
         * clickedBtn.setIcon(new ImageIcon(img));
         * } catch (Exception ex) {
         * System.out.println(ex);
         * }
         **/
        btnClicked.setEnabled(false);

        if (playerSign == 'X')
          playerSign = 'O';
        else
          playerSign = 'X';

        showWinner();
      });

      add(btns[i]);
    }
  }

  public void showWinner() {
    if (existsWinner()) {
      if (playerSign == 'X')
        playerSign = 'O';
      else
        playerSign = 'x';

      JOptionPane jOptionPane = new JOptionPane();
      int dialog = JOptionPane.showConfirmDialog(jOptionPane,
          "Game Over. "
              + "The winner is " + playerSign + " ",
          "Result", JOptionPane.DEFAULT_OPTION);

      if (dialog == JOptionPane.OK_OPTION)
        System.exit(0);

    } else if (isDraw()) {
      JOptionPane jOptionPane = new JOptionPane();
      int dialog = JOptionPane.showConfirmDialog(
          jOptionPane, "Game Draw", "Result", JOptionPane.DEFAULT_OPTION);

      if (dialog == JOptionPane.OK_OPTION)
        System.exit(0);
    }
  }

  public boolean isDraw() {
    boolean gridsFull = true;
    for (int i = 0; i < cells; i++) {
      if (btns[i].getText().equals("")) {
        gridsFull = false;
      }
    }
    return gridsFull;
  }

  public boolean existsWinner() {
    return checkRows() || checkColumns() || checkDiagonals();
  }

  public boolean checkRows() {
    int i = 0;
    for (int j = 0; j < 3; j++) {
      if (btns[i].getText().equals(btns[i + 1].getText())
          && btns[i].getText().equals(btns[i + 2].getText())
          && !btns[i].getText().equals("")) {
        return true;
      }
      i = i + 3;
    }
    return false;
  }

  public boolean checkColumns() {
    int i = 0;
    for (int j = 0; j < 3; j++) {
      if (btns[i].getText().equals(btns[i + 3].getText())
          && btns[i].getText().equals(btns[i + 6].getText())
          && !btns[i].getText().equals("")) {
        return true;
      }
      i++;
    }
    return false;
  }

  public boolean checkDiagonals() {
    if (btns[0].getText().equals(btns[4].getText())
        && btns[0].getText().equals(btns[8].getText()) && !btns[0].getText().equals(""))
      return true;
    else
      return btns[2].getText().equals(btns[4].getText())
          && btns[2].getText().equals(btns[6].getText())
          && !btns[2].getText().equals("");
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Tic Tac Toe Game");

    frame.getContentPane().add(new TikTakToeGUI());
    frame.setBounds(500, 500, 600, 550);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
  }
}
