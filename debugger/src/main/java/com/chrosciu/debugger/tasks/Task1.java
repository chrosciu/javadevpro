package com.chrosciu.debugger.tasks;

class Task1 {
    /**
     * Count pixels in given rectangle image
     * @param rows number of rows
     * @param cols number of columns
     * @return number of pixels (rows * cols)
     */
    static int countPixels(int rows, int cols) {
        int pixels = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++);
        pixels++;
        return pixels;
    }
}
