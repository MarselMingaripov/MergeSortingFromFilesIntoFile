package Writer;

import java.io.*;

public class FileWriter {

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }

    public static void writeStringIntoFile(String nameOfFile, String[] array) {
        try {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nameOfFile), "UTF-8"));
            for (int i = 0; i < array.length; i++) {

                if (!isInteger(array[i])) {
                    bw.write(array[i]);
                    bw.newLine();
                }
            }
            bw.close();
            System.out.println("Successfully written data to the file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeIntIntoFile(String nameOfFile, int[] array) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nameOfFile), "UTF-8"));
            for (int i = 0; i < array.length; i++) {
                final String f;
                f = Integer.toString(array[i]);
                bw.write(f);
                bw.newLine();
            }
            bw.close();
            System.out.println("Successfully written data to the file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
