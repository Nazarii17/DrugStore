package main.java.nararii.tkachuk.com.project.csvFiles;

import java.util.List;

public final class CSVFormatterUtil {

    private CSVFormatterUtil() {
        throw new RuntimeException();
    }

    public static String toCSVString(List<? extends CSVSerializable> list) {
        StringBuilder stringBuilder = new StringBuilder();

        for (CSVSerializable item : list) {
            stringBuilder.append(item.toCSVString());
        }

        return stringBuilder.toString();
    }
}
