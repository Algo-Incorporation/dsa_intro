import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TikTakToeGUI extends JPanel {
  char playerSign = 'O';
  int totalCells = 9;
  int totalRows = 3;
  int totalColumns = 3;
  JButton[] jButtons = new JButton[totalCells];

  public TikTakToeGUI() {
    GridLayout ticTacToeGridLayout = new GridLayout(totalRows, totalColumns);
    setLayout(ticTacToeGridLayout);

    createButtons();
  }

  public void createButtons() {
    for (int i = 0; i <= 8; i++) {
      JButton btn = new JButton();
      btn.setBackground(Color.WHITE);
      jButtons[i] = btn;

      jButtons[i].setText("");

      jButtons[i].addActionListener(e -> {
        JButton clickedBtn = (JButton) e.getSource();
        clickedBtn.setBackground(Color.BLACK);
        clickedBtn.setForeground(Color.WHITE);
        clickedBtn.setText(String.valueOf(playerSign));
        /**try {
          Image img = (playerSign == 'O') ? ImageIO.read(getClass().getResource("X.png")) : ImageIO.read(getClass().getResource("O.jpg"));
          clickedBtn.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
          System.out.println(ex);
        }**/
        clickedBtn.setEnabled(false);

        if (playerSign == 'O')
          playerSign = 'X';
        else
          playerSign = 'O';

        showWinner();
      });

      add(jButtons[i]);
    }
  }

  public void showWinner() {
    if (checkForWinner()) {
      if (playerSign == 'O')
        playerSign = 'X';
      else
        playerSign = 'O';

      JOptionPane jOptionPane = new JOptionPane();
      int dialog = JOptionPane.showConfirmDialog(jOptionPane,
          "Game Over. "
              + "The winner is " + playerSign + " ",
          "Result", JOptionPane.DEFAULT_OPTION);

      if (dialog == JOptionPane.OK_OPTION)
        System.exit(0);

    } else if (checkIfMatchDraw()) {
      JOptionPane jOptionPane = new JOptionPane();
      int dialog = JOptionPane.showConfirmDialog(
          jOptionPane, "Game Draw", "Result", JOptionPane.DEFAULT_OPTION);

      if (dialog == JOptionPane.OK_OPTION)
        System.exit(0);
    }
  }

  public boolean checkIfMatchDraw() {
    boolean gridsFull = true;
    for (int i = 0; i < totalCells; i++) {
      if (jButtons[i].getText().equals("")) {
        gridsFull = false;
      }
    }
    return gridsFull;
  }

  public boolean checkForWinner() {
    return checkAllRows() || checkAllColumns() || checkTheDiagonals();
  }

  public boolean checkAllRows() {
    int i = 0;
    for (int j = 0; j < 3; j++) {
      if (jButtons[i].getText().equals(jButtons[i + 1].getText())
          && jButtons[i].getText().equals(jButtons[i + 2].getText())
          && !jButtons[i].getText().equals("")) {
        return true;
      }
      i = i + 3;
    }
    return false;
  }

  public boolean checkAllColumns() {
    int i = 0;
    for (int j = 0; j < 3; j++) {
      if (jButtons[i].getText().equals(jButtons[i + 3].getText())
          && jButtons[i].getText().equals(jButtons[i + 6].getText())
          && !jButtons[i].getText().equals("")) {
        return true;
      }
      i++;
    }
    return false;
  }

  public boolean checkTheDiagonals() {
    if (jButtons[0].getText().equals(jButtons[4].getText())
        && jButtons[0].getText().equals(jButtons[8].getText()) && !jButtons[0].getText().equals(""))
      return true;
    else
      return jButtons[2].getText().equals(jButtons[4].getText())
          && jButtons[2].getText().equals(jButtons[6].getText())
          && !jButtons[2].getText().equals("");
  }

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Tic Tac Toe Game");

    jFrame.getContentPane().add(new TikTakToeGUI());
    jFrame.setBounds(500, 500, 600, 550);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setVisible(true);
    jFrame.setLocationRelativeTo(null);
  }
}
