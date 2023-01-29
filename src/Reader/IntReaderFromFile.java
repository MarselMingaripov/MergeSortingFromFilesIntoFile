package Reader;

import java.io.*;
import java.util.ArrayList;

public class IntReaderFromFile {

    public static int[] parseInt(String nameOfFile) {
        ArrayList<String> arrayIntList = new ArrayList<>();
        {
            try {
                String str = null;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(nameOfFile), "UTF-8"));
                while ((str = bufferedReader.readLine()) != null) {
                    if (!str.isEmpty() && !str.equals(" ")) {
                        arrayIntList.add(str);
                    } else {
                        break;
                    }
                }
                bufferedReader.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            String[] stringArray = new String[arrayIntList.size()];
            stringArray = arrayIntList.toArray(new String[0]);
            int[] intArray = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {
                intArray[i] = Integer.parseInt(stringArray[i]);
            }
            return intArray;
        }
    }

    public static void print(String[] strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
