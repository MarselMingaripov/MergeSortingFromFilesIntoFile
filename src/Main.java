import MergeSorter.IntMergeSort;
import MergeSorter.StringMergeSort;
import Reader.IntReaderFromFile;
import Reader.StringReaderFromFile;
import Writer.FileWriter;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.copyOf;

public class Main {
    public static void main(String[] args) {

        String[] myArray = new String[args.length];

        if (args[0].equals("-a") || args[0].equals("-d")) {
            System.arraycopy(args, 0, myArray, 0, args.length);

        } else {
            myArray = copyOf(myArray, myArray.length + 1);
            myArray[0] = "-a";
            System.arraycopy(args, 0, myArray, 1, args.length);
        }

        if (!myArray[1].equals("-s")){
            if (!myArray[1].equals("-i")) {
                System.err.println("Invalid arguments!");
                System.exit(1);
            }
        }

        String sortMode = "arise";
        String typeOfData = "";
        String outputFile = "";
        List<String> inputFileList = new ArrayList<>();
        int[] sortedIntArray = new int[0];
        String[] sortedStringArray = new String[0];

        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i].equals("-a") || myArray[i].equals("-d")) {
                if (myArray[i].equals("-a")) {
                    sortMode = "arise";
                } else {
                    sortMode = "decrease";
                }
            }

            if (myArray[i].equals("-s") || myArray[i].equals("-i")) {
                if (myArray[i].equals("-s")) {
                    typeOfData = "string";
                } else {
                    typeOfData = "int";
                }
            }

            if (i == 2) {
                outputFile = myArray[i];
            }

            if (i > 2) {
                inputFileList.add(myArray[i]);
            }

        }

        if (myArray[0].equals("-a")){
            if (myArray[1].equals("-i")){
                for (int i = 0; i < inputFileList.size(); i++) {

                    if (i != inputFileList.size()) {
                        if (i != 0) {
                            int[] testArray = sortedIntArray;
                            try {
                                sortedIntArray = copyOf(sortedIntArray, sortedIntArray.length + IntReaderFromFile.parseInt(inputFileList.get(i)).length);
                                sortedIntArray = IntMergeSort.mergeAriseIntArray(testArray,
                                        IntReaderFromFile.parseInt(inputFileList.get(i)));
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                System.err.println("Error in " + inputFileList.get(i));

                            }

                        } else {
                            try {
                                sortedIntArray = copyOf(sortedIntArray, IntReaderFromFile.parseInt(inputFileList.get(i)).length);
                                sortedIntArray = IntReaderFromFile.parseInt(inputFileList.get(i));
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                System.err.println("Error in " + inputFileList.get(i));
                            }
                        }
                    } else {
                        break;
                    }
                }

            } else {
                for (int i = 0; i < inputFileList.size(); i++) {

                    if (i != inputFileList.size()) {
                        if (i != 0) {
                            String[] testArray = sortedStringArray;
                            sortedStringArray = copyOf(sortedStringArray, sortedStringArray.length + StringReaderFromFile.parseString(inputFileList.get(i)).length);
                            sortedStringArray = StringMergeSort.AriseStringMergeSort(testArray, StringReaderFromFile.parseString(inputFileList.get(i)));

                        } else {
                            sortedStringArray = copyOf(sortedStringArray, StringReaderFromFile.parseString(inputFileList.get(i)).length);
                            sortedStringArray = StringReaderFromFile.parseString(inputFileList.get(i));
                        }
                    } else {
                        break;
                    }
                }
            }
        } else{
            if (myArray[1].equals("-i")){
                for (int i = 0; i < inputFileList.size(); i++) {

                    if (i != inputFileList.size()) {
                        if (i != 0) {
                            int[] testArray = sortedIntArray;
                            try {
                                sortedIntArray = copyOf(sortedIntArray, sortedIntArray.length + IntReaderFromFile.parseInt(inputFileList.get(i)).length);
                                sortedIntArray = IntMergeSort.mergeDecreaseIntArray(testArray,
                                        IntReaderFromFile.parseInt(inputFileList.get(i)));
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                System.err.println("Error in " + inputFileList.get(i));

                            }
                        } else {
                            try {
                                sortedIntArray = copyOf(sortedIntArray, IntReaderFromFile.parseInt(inputFileList.get(i)).length);
                                sortedIntArray = IntReaderFromFile.parseInt(inputFileList.get(i));
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                System.err.println("Error in " + inputFileList.get(i));

                            }
                        }
                    } else {
                        break;
                    }
                }
            } else{
                for (int i = 0; i < inputFileList.size(); i++) {

                    if (i != inputFileList.size()) {
                        if (i != 0) {
                            String[] testArray = sortedStringArray;
                            sortedStringArray = copyOf(sortedStringArray, sortedStringArray.length + StringReaderFromFile.parseString(inputFileList.get(i)).length);
                            sortedStringArray = StringMergeSort.DecreaseStringMergeSort(testArray, StringReaderFromFile.parseString(inputFileList.get(i)));

                        } else {
                            sortedStringArray = copyOf(sortedStringArray, StringReaderFromFile.parseString(inputFileList.get(i)).length);
                            sortedStringArray = StringReaderFromFile.parseString(inputFileList.get(i));
                        }
                    } else {
                        break;
                    }
                }
            }

        }
        if (myArray[1].equals("-s")){
            FileWriter.writeStringIntoFile(myArray[2], sortedStringArray);
        } else {
            FileWriter.writeIntIntoFile(myArray[2], sortedIntArray);
        }
    }
}
