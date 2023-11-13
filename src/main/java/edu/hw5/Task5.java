package edu.hw5;

public class Task5 {
    private Task5() {
    }

    private static final String TAG_PATTERN =
            "[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}(186|17[3478]|19[0679]|16[134]|15[0249]|142|13[468]"
                    + "|12[13456]|11[36]|102|777|799|977|750|716|797|0[1-9]|1[0-9]|2[1-9]|[3-9][0-9])";

    public static boolean isValidTag(String tag) {
        if (tag == null) {
            throw new IllegalArgumentException("tag is null");
        }
        return tag.matches(TAG_PATTERN);
    }
}
