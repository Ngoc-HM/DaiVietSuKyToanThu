
// Finish the board immidiately by delete "if(answer[i][j]..." :)
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

public class Minesweeper extends JFrame {
   private static int height = 0, width = 0, mines = 0, openCell = 0;
   private static String mode;
   private static JTextField mineCounter, timerField;
   private int[][] gameBoard, answerBoard;
   private Cell[][] cellBoard;
   private static boolean firstClick = true, setTimer = false;
   private static Timer timer = new Timer();

   public void open(int[][] board, int[][] answer, int i, int j) {
      if (i < 0 || i >= height)
         return;
      if (j < 0 || j >= width)
         return;
      if (board[i][j] == 1)
         return;
      if (answer[i][j] != 0) {
         cellBoard[i][j].setValue(answer[i][j]);
         cellBoard[i][j].setBackground(Color.gray);
         return;
      }
      if (cellBoard[i][j].getText().equals(answer[i][j] + ""))
         return;
      cellBoard[i][j].setValue(answer[i][j]);
      cellBoard[i][j].setBackground(Color.gray);
      open(board, answer, i - 1, j - 1);
      open(board, answer, i - 1, j);
      open(board, answer, i - 1, j + 1);
      open(board, answer, i, j - 1);
      open(board, answer, i, j + 1);
      open(board, answer, i + 1, j - 1);
      open(board, answer, i + 1, j);
      open(board, answer, i + 1, j + 1);
   }

   public int[][] getAroundCells(int i, int j) {
      if (i == 0 && j == 0)
         return new int[][] { { 1, 0 }, { 0, 1 }, { 1, 1 } };
      else if (i == 0 && j == width - 1)
         return new int[][] { { 0, -1 }, { 1, -1 }, { 1, 0 } };
      else if (i == height - 1 && j == 0)
         return new int[][] { { -1, 0 }, { -1, 1 }, { 0, 1 } };
      else if (i == height - 1 && j == width - 1)
         return new int[][] { { -1, -1 }, { 0, -1 }, { -1, 0 } };
      else if (i == 0 && j < width - 1)
         return new int[][] { { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
      else if (i == height - 1 && j < width - 1)
         return new int[][] { { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
      else if (j == 0 && i < height - 1)
         return new int[][] { { -1, 0 }, { 1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } };
      else if (j == width - 1 && i < height - 1)
         return new int[][] { { -1, 0 }, { 1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 } };
      else
         return new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
   }

   public void countMine(int[][] board, int[][] answer) {
      for (int i = 0; i < height; i++)
         for (int j = 0; j < width; j++) {
            int[][] aroundCells = getAroundCells(i, j);
            for (int[] ks : aroundCells)
               answer[i][j] += board[i + ks[0]][j + ks[1]];
         }
   }

   public Minesweeper(boolean firstStart) {
      if (firstStart) {
         Container cp = getContentPane();
         cp.setLayout(new GridLayout(5, 1));
         JTextField text = new JTextField("Choose a difficulty level: beginner, medium, expert or custom");
         Font f36 = new Font(text.getFont().getName(), text.getFont().getStyle(), 36);
         text.setFont(f36);
         text.setEditable(false);
         cp.add(text);
         JButton easy = new JButton("Beginner - 9 x 9 / 10");
         easy.setFont(f36);
         easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               height = 9;
               width = 9;
               mines = 10;
               mode = "Beginner";
               dispose();
               new Minesweeper(false);
            }
         });
         JButton medium = new JButton("Medium - 16 x 16 / 40");
         medium.setFont(f36);
         medium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               height = 16;
               width = 16;
               mines = 40;
               mode = "Medium";
               dispose();
               new Minesweeper(false);
            }
         });
         JButton hard = new JButton("Expert - 16 x 30 / 99");
         hard.setFont(f36);
         hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               height = 16;
               width = 30;
               mines = 99;
               mode = "Expert";
               dispose();
               new Minesweeper(false);
            }
         });
         JButton custom = new JButton("Custom");
         custom.setFont(f36);
         custom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
               cp.remove(text);
               cp.remove(easy);
               cp.remove(medium);
               cp.remove(hard);
               cp.remove(custom);
               cp.setLayout(new GridLayout(4, 2));
               JTextField heightField = new JTextField("Height:"), widthField = new JTextField("Width:"),
                     mineField = new JTextField("Mines:"), heightInput = new JTextField(),
                     widthInput = new JTextField(), mineInput = new JTextField();
               heightField.setEditable(false);
               heightField.setFont(f36);
               widthField.setFont(f36);
               widthField.setEditable(false);
               mineField.setEditable(false);
               mineField.setFont(f36);
               JButton b = new JButton("Play");
               b.setFont(f36);
               b.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                     boolean error = false;
                     try {
                        height = Integer.parseInt(heightInput.getText());
                        width = Integer.parseInt(widthInput.getText());
                        mines = Integer.parseInt(mineInput.getText());
                     } catch (Exception e1) {
                        error = true;
                        JOptionPane.showMessageDialog(null, "ERROR: Input is not an positive integer");
                     }
                     if (!error) {
                        if (mines < height * width && width < 39 && height < 51 && width > 1 && height > 1) {
                           dispose();
                           mode = "Custom";
                           new Minesweeper(false);
                        } else
                           JOptionPane.showMessageDialog(null,
                                 "Cannot make board " + height + " x " + width + " / " + mines);
                     }
                  }
               });
               JButton backButton = new JButton("Go back");
               backButton.setFont(f36);
               backButton.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                     dispose();
                     new Minesweeper(true);
                  }
               });
               cp.add(heightField);
               cp.add(heightInput);
               cp.add(widthField);
               cp.add(widthInput);
               cp.add(mineField);
               cp.add(mineInput);
               cp.add(b);
               cp.add(backButton);
               setTitle("Custom");
               setVisible(true);
            }
         });
         cp.add(easy);
         cp.add(medium);
         cp.add(hard);
         cp.add(custom);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setTitle("Choose game mode");
         setSize(1000, 500);
         setLocationRelativeTo(null);
         setVisible(true);
      } else {
         int needOpen = height * width - mines;
         Random r = new Random();
         gameBoard = new int[height][width];
         answerBoard = new int[height][width];
         cellBoard = new Cell[height][width];
         for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
               Cell tmp = new Cell(i, j);
               tmp.addMouseListener(new MouseAdapter() {
                  boolean pressed;

                  @Override
                  public void mousePressed(MouseEvent e) {
                     pressed = true;
                  }

                  @Override
                  public void mouseReleased(MouseEvent e) {
                     if (pressed) {
                        if (firstClick && !setTimer) {
                           setTimer = true;
                           timer.schedule(new TimerTask() {
                              @Override
                              public void run() {
                                 if (timerField != null && !firstClick) {
                                    int time = Integer.parseInt(timerField.getText()) + 1;
                                    timerField.setText(time + "");
                                 }
                              }
                           }, 0, 1000);
                        }
                        if (SwingUtilities.isRightMouseButton(e)) {
                           if (tmp.getBackground().equals(Color.white)) {
                              tmp.setText("F");
                              tmp.setBackground(Color.red);
                              mineCounter.setText((Integer.parseInt(mineCounter.getText()) - 1) + "");
                           } else if (tmp.getBackground().equals(Color.red)) {
                              tmp.setText("");
                              tmp.setBackground(Color.white);
                              mineCounter.setText((Integer.parseInt(mineCounter.getText()) + 1) + "");
                           }
                           firstClick = false;
                        } else {
                           if (tmp.getBackground().equals(Color.white)) {
                              int x = tmp.getI(), y = tmp.getJ();
                              if (gameBoard[x][y] == 1) {
                                 if (firstClick) {
                                    while (gameBoard[x][y] == 1) {
                                       for (int k = 0; k < height; k++)
                                          for (int l = 0; l < width; l++)
                                             gameBoard[k][l] = 0;
                                       makeBoard(r);
                                    }
                                    countMine(gameBoard, answerBoard);
                                    open(gameBoard, answerBoard, x, y);
                                    checkWin(needOpen);
                                 } else {
                                    timer.cancel();
                                    tmp.setText("*");
                                    JOptionPane.showMessageDialog(null, "You lose!");
                                    System.exit(0);
                                 }
                              } else {
                                 openCell = 0;
                                 open(gameBoard, answerBoard, x, y);
                                 checkWin(needOpen);
                              }
                              firstClick = false;
                           } else if (tmp.getBackground().equals(Color.gray)) {
                              int i = tmp.getI(), j = tmp.getJ(), redFlag = 0;
                              int[][] aroundCells = getAroundCells(i, j);
                              for (int[] ks : aroundCells)
                                 if (cellBoard[i + ks[0]][j + ks[1]].getBackground().equals(Color.red))
                                    redFlag++;
                              if (answerBoard[i][j] == redFlag) {
                                 for (int[] ks : aroundCells) {
                                    if (cellBoard[i + ks[0]][j + ks[1]].getBackground().equals(Color.white)) {
                                       if (gameBoard[i + ks[0]][j + ks[1]] == 1) {
                                          timer.cancel();
                                          cellBoard[i + ks[0]][j + ks[1]].setText("*");
                                          JOptionPane.showMessageDialog(null, "You lose!");
                                          System.exit(0);
                                       } else
                                          open(gameBoard, answerBoard, i + ks[0], j + ks[1]);
                                    }
                                 }
                                 checkWin(needOpen);
                              }
                           }
                        }
                     }
                     pressed = false;
                  }

                  @Override
                  public void mouseExited(MouseEvent e) {
                     pressed = false;
                  }

                  @Override
                  public void mouseEntered(MouseEvent e) {
                     pressed = true;
                  }
               });
               cellBoard[i][j] = tmp;
            }
         }
         makeBoard(r);
         countMine(gameBoard, answerBoard);
         Container cp = getContentPane();
         JPanel header = new JPanel();
         header.setLayout(new FlowLayout());
         cp.setLayout(new BorderLayout());
         JTextField textField1 = new JTextField("Mines: ", 6), textField2 = new JTextField("Timer: ", 12);
         timerField = new JTextField("0", 15);
         mineCounter = new JTextField("" + mines, 10);
         textField1.setEditable(false);
         textField2.setEditable(false);
         timerField.setEditable(false);
         mineCounter.setEditable(false);
         JButton newGame = new JButton("New game");
         newGame.setBackground(Color.green);
         newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               timerField.setText("0");
               firstClick = true;
               for (int k = 0; k < height; k++)
                  for (int l = 0; l < width; l++) {
                     cellBoard[k][l].setText("");
                     cellBoard[k][l].setBackground(Color.white);
                  }
               for (int k = 0; k < height; k++)
                  for (int l = 0; l < width; l++) {
                     gameBoard[k][l] = 0;
                     answerBoard[k][l] = 0;
                  }
               makeBoard(r);
               countMine(gameBoard, answerBoard);
            }
         });
         header.add(newGame);
         header.add(textField1);
         header.add(mineCounter);
         header.add(textField2);
         header.add(timerField);
         cp.add(header, BorderLayout.NORTH);
         JPanel board = new JPanel();
         board.setLayout(new GridLayout(height, width));
         for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
               board.add(cellBoard[i][j]);
         cp.add(board, BorderLayout.CENTER);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setTitle("Minesweeper");
         setExtendedState(JFrame.MAXIMIZED_BOTH);
         setVisible(true);
      }
   }

   private void makeBoard(Random r) {
      for (int i = 0; i < mines; i++) {
         int x = r.nextInt(0, height), y = r.nextInt(0, width);
         if (gameBoard[x][y] == 0)
            gameBoard[x][y] = 1;
         else
            i--;
      }
   }

   public void checkWin(int needOpen) {
      openCell = 0;
      for (int k = 0; k < height; k++)
         for (int l = 0; l < width; l++)
            if (isInteger(cellBoard[k][l].getText()))
               openCell++;
      if (openCell == needOpen) {
         timer.cancel();
         JOptionPane.showMessageDialog(null,
               "You win!\n" + mode + " - " + (timerField.getText().equals("") ? "0" : timerField.getText()) + " s");
         System.exit(0);
      }
   }

   public static boolean isInteger(String str) {
      if (str == null)
         return false;
      int length = str.length();
      if (length == 0)
         return false;
      int i = 0;
      if (str.charAt(0) == '-') {
         if (length == 1)
            return false;
         i = 1;
      }
      for (; i < length; i++) {
         char c = str.charAt(i);
         if (c < '0' || c > '9')
            return false;
      }
      return true;
   }

   public static void main(String[] args) {
      new Minesweeper(true);
   }
}