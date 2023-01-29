package Reader;

import java.io.*;
import java.util.ArrayList;

public class StringReaderFromFile {

    public static String[] parseString(String nameOfFile) {
        ArrayList<String> arrayStringList = new ArrayList<>();
        {
            try {
                String str = null;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(nameOfFile), "UTF-8"));
                while ((str = bufferedReader.readLine()) != null) {
                    if (!str.isEmpty() && !str.equals(" ")) {
                        arrayStringList.add(str);
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
            }
            return arrayStringList.toArray(new String[0]);
        }
    }

    public static void print(String[] strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
