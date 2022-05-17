package com.chrosciu.debugger.tasks;

class Task3 {
    /**
     * Return position of given string (pattern) as part of another string (source)
     * @param pattern pattern to be found
     * @param source source to be searched for pattern
     * @return position of first pattern character in source or -1 if not found
     */
    static int findSubstringIndex(String pattern, String source) {
        boolean found = true;
        for (int i = 0; i < source.length() - pattern.length(); i++) {
            found = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (source.charAt(i + j) != pattern.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}
