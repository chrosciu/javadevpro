1. Create a simple `StringCalculator` class with a static method `int add(String numbers)`
2. The method can take 0, 1 or 2 numbers (separated with commas), and will return their sum (for an empty string it will return 0)
For example `` or `1` or `1,2` 
3. Allow the `add` method to handle an unknown amount of numbers
4. Allow the `add` method to handle new lines between numbers (instead of commas). The following input is ok: `1\n2,3` (will equal `6`)
5. Support different delimiters. 
To change a delimiter, the beginning of the string will contain a separate line that looks like this:
`//[delimiter]\n[numbers…]`
For example `//;\n1;2` should return `3` where the default delimiter is `;`
*The first line is optional. All existing scenarios should still be supported*
6. Calling `add` with a negative number will throw an exception with message `negatives not allowed` – and the negative that was passed. 
7. If there are multiple negatives, show all of them in the exception message
8. Numbers bigger than `1000` should be ignored, so adding `2 + 1001 = 2`
9. Delimiters can be of any length with the following format: `//[delimiter]\n` for example: `//[—]\n1—2—3` should return `6`
10. Allow multiple delimiters like this: `//[delim1][delim2]\n` for example `//[-][%]\n1-2%3` should return `6`
11. Make sure you can also handle multiple delimiters with length longer than one char