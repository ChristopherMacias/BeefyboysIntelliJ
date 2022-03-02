package christopher.macias.connect.model;


public class Board {
    public static final int Count_Rows = 6;
    public static final int Count_Columns = 7;
    private TokenColor[][] cells = new TokenColor[Count_Rows][Count_Columns];


    public void dropTokenColor(int col, TokenColor tokenColor) {
        int row = findAvailableRow(col);
        this.cells[row][col] = tokenColor;

    }

    private int findAvailableRow(int col) {
        for (int row = Count_Rows - 1; row >= 0; row--) {
            if (this.cells[row][col] == null) {
                return row;
            }
        }
        throw new ArrayIndexOutOfBoundsException("No available cells in column" + col);
    }

    public boolean checkForWin(TokenColor tokenColor, int row, int col) {

        return checkForRowWin(tokenColor, row, col) ||
                checkForColumnWin(tokenColor, row, col) ||
                checkForDiagonalWin(tokenColor, row, col);
    }

    private boolean checkForColumnWin(TokenColor tokenColor, int row, int col) {

        return checkForColumnClock2Win(tokenColor, row, col) ||
                checkForColumnClock4Win(tokenColor, row, col) ||
                checkForColumnClock8Win(tokenColor, row, col);
    }

    private boolean checkForRowWin(TokenColor tokenColor, int row, int col) {

        return checkForRowClock2Win(tokenColor, row, col) ||
                checkForRowClock4Win(tokenColor, row, col) ||
                checkForRowClock8Win(tokenColor, row, col);

    }

    private boolean checkForDiagonalWin(TokenColor tokenColor, int row, int col) {


        return checkForDiagonalClock2Win(tokenColor, row, col) ||
                checkForDiagonalClock4Win(tokenColor, row, col) ||
                checkForDiagonalClock8Win(tokenColor, row, col);

    }

    private boolean checkForRowClock2Win(TokenColor tokenColor, int placedAtRow, int placedAtCol) {
        int countConsecutiveTokens = 0;
        for (int row = placedAtRow; row < Count_Rows; row++) {
            for (int col = placedAtCol; col < Count_Columns; col++) {
                if (this.cells[row][col] == tokenColor) {
                    countConsecutiveTokens++;

                } else {
                    countConsecutiveTokens = 0;
                }
                if (countConsecutiveTokens >= 4) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean checkForRowClock4Win(TokenColor tokenColor, int placedAtRow, int placedAtCol) {
        int countConsecutiveTokens = 0;
        for (int row = placedAtRow; row < Count_Rows; row++) {
            for (int col = placedAtCol; col < Count_Columns; col++) {
                if (this.cells[row][col] == tokenColor) {
                    countConsecutiveTokens++;

                } else {
                    countConsecutiveTokens = 0;
                }
                if (countConsecutiveTokens >= 8) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean checkForRowClock8Win(TokenColor tokenColor, int placedAtRow, int placedAtCol) {
        int countConsecutiveTokens = 0;
        for (int row = placedAtRow; row < Count_Rows; row++) {
            for (int col = placedAtCol; col < Count_Columns; col++) {
                if (this.cells[row][col] == tokenColor) {
                    countConsecutiveTokens++;

                } else {
                    countConsecutiveTokens = 0;
                }
                if (countConsecutiveTokens >= 10) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean checkForColumnClock2Win(TokenColor tokenColor, int placedAtRow, int placedAtCol) {
        int countConsecutiveTokens = 0;
        for (int col = placedAtCol; col < Count_Columns; col++) {
            for (int row = placedAtRow; row < Count_Rows; row++) {
                if (this.cells[row][col] == tokenColor) {
                    countConsecutiveTokens++;

                } else {
                    countConsecutiveTokens = 0;
                }
                if (countConsecutiveTokens >= 4) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean checkForColumnClock4Win(TokenColor tokenColor, int placedAtRow, int placedAtCol) {
        int countConsecutiveTokens = 0;
        for (int col = placedAtCol; col < Count_Columns; col++) {
            for (int row = placedAtRow; row < Count_Rows; row++) {
                if (this.cells[row][col] == tokenColor) {
                    countConsecutiveTokens++;

                } else {
                    countConsecutiveTokens = 0;
                }
                if (countConsecutiveTokens >= 8) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean checkForColumnClock8Win(TokenColor tokenColor, int placedAtRow, int placedAtCol) {
        int countConsecutiveTokens = 0;
        for (int col = placedAtCol; col < Count_Columns; col++) {
            for (int row = placedAtRow; row < Count_Rows; row++) {
                if (this.cells[row][col] == tokenColor) {
                    countConsecutiveTokens++;

                } else {
                    countConsecutiveTokens = 0;
                }
                if (countConsecutiveTokens >= 10) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean checkForDiagonalClock2Win(TokenColor tokenColor, int placedAtRow, int placedAtCol) {
        int countConsecutiveTokens = 0;

        int r, c = 0; // walk back to the beginning of the diagonal
        for (r = placedAtRow, c = placedAtCol; r < Count_Rows && c >= 0; r++, c--) ;
        // start at the beginning
        for (int row = Count_Rows - 1, col = 0; row > 0 && col < Count_Columns + 1; row--, col++) {
            if (this.cells[row][col] == tokenColor) {
                countConsecutiveTokens++;
            } else {
                countConsecutiveTokens = 0;
            }
            if (countConsecutiveTokens >= 4) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForDiagonalClock4Win(TokenColor tokenColor, int placedAtRow, int placedAtCol) {
        int countConsecutiveTokens = 0;

        int r, c = 0;
        for (r = placedAtRow, c = placedAtCol; r < Count_Rows && c >= 0; r++, c--) ;

        for (int row = Count_Rows - 1, col = 0; row > 0 && col < Count_Columns + 1; row--, col++) {
            if (this.cells[row][col] == tokenColor) {
                countConsecutiveTokens++;

            } else {
                countConsecutiveTokens = 0;
            }
            if (countConsecutiveTokens >= 8) {
                return true;
            }
        }

        return false;

    }

    private boolean checkForDiagonalClock8Win(TokenColor tokenColor, int placedAtRow, int placedAtCol) {
        int countConsecutiveTokens = 0;

        int r, c = 0;
        for (r = placedAtRow, c = placedAtCol; r < Count_Rows && c >= 0; r++, c--) ;

        for (int row = Count_Rows - 1, col = 0; row > 0 && col < Count_Columns + 1; row--, col++) {
            if (this.cells[row][col] == tokenColor) {
                countConsecutiveTokens++;

            } else {
                countConsecutiveTokens = 0;
            }
            if (countConsecutiveTokens >= 10) {
                return true;
            }
        }

        return false;
    }


    @Override
    public String toString() {
        String myReturn = "";
        for (int row = 0; row < Count_Rows; row++) {
            for (int col = 0; col < Count_Columns; col++) {
                char output = '_';
                if (cells[row][col] == TokenColor.Red) {
                    output = 'R';
                } else if (cells[row][col] == TokenColor.Yellow) {
                    output = 'Y';
                }

                myReturn += (output + " ");

            }
            myReturn += "\n";
        }
        return myReturn;
    }

}

