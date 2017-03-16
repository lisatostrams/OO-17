package qtrees;

/**
 * Bitmap: A class for representing bitmap;
 * @author Sjaak Smetsers
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams
 * @version 15-03-2016
 */
public class Bitmap {
    // each bit is stored into an two dimensional array
    private final boolean[][] raster;
    private final int bmWidth, bmHeight;
    
    /**
     * Creates an empty bitmap of size width * height
     * @param width
     * @param height 
     */
    public Bitmap( int width, int height ) {
        raster   = new boolean[width][height];
        bmWidth  = width;
        bmHeight = height;
    }

    /**
     * Gets a bit at the specified position
     * @param x: x coordinate
     * @param y: y coordinate
     */
    public boolean getBit( int x, int y ) {
        return raster[x][y];
    }
    
    /**
     * Sets a bit at the specified position
     * @param x: x coordinate
     * @param y: y coordinate
     * @param val: the bit value 
     */
    public void setBit( int x, int y, boolean val ){
        raster[x][y] = val;
    }
    
    /**
     * Converts a bitmap into a string
     * 1 is represented by '*'; 0 by 'O'
     * @return the string representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < bmHeight; y++) {
            for (int x = 0; x < bmWidth; x++) {
               sb.append( raster[x][y] ?  '*' : 'O' );
            }
            sb.append( '\n' );
        }
        return sb.toString();
    }
    
    /**
     * @return the width of the bitmap
     */
    public int getWidth() {
        return bmWidth;
    }

    /**
     * @return the height of the bitmap
     */
    public int getHeight() {
        return bmHeight;
    }
    
    /**
     * Fills a square area of a bitmap with value val
     * @param x: x coordinate of upper-left corner
     * @param y: y coordinate of upper-left corner
     * @param size: size of the square
     * @param val: the bit value 
      */
    public void fillArea( int x, int y, int size, boolean val ){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                setBit(x+i, y+j, val);
            }
        }
    }
    
    /**
     * checks if the given area contains only black bits
     * @param x
     * @param y
     * @param width
     * @return 
     */
    public boolean allBlack(int x, int y, int width){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < width; j++){
                if(raster[x+i][y+j]==true)
                    return false;
            }
        }
        return true;
    }
    
    /**
     * checks if the given area contains only white bits
     * @param x
     * @param y
     * @param width
     * @return 
     */
    public boolean allWhite(int x, int y, int width){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < width; j++){
                if(raster[x+i][y+j]==false)
                    return false;
            }
        }
        return true;
    }
    

}
