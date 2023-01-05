1. Create a simple `StringCalculator` class with a static method `int add(String numbers)`
2. The `add` method can take 0, 1 or 2 numbers (separated with commas). For example: `` or `1` or `1,2`
3. For an empty string method should return 0
4. Method should return sum of passed numbers
5. Allow  method to handle an unknown amount of numbers
6. Allow method to handle new lines between numbers (instead of commas). The following input is ok: `1\n2,3` (will equal `6`)
7. Support different delimiters. 
To change a delimiter, the beginning of the string will contain a separate line that looks like this:
`//[delimiter]\n[numbers…]`
For example `//;\n1;2` should return `3` where the default delimiter is `;`
*The first line is optional. All existing scenarios should still be supported*
8. Calling `add` with a negative number will throw an exception with message `negatives not allowed` – and the negative that was passed. 
If there are multiple negatives, show all of them in the exception message
9. Numbers bigger than `1000` should be ignored, so adding `2 + 1001 = 2`
10. Delimiters can be of any length with the following format: `//[delimiter]\n` for example: `//[—]\n1—2—3` should return `6`
11. Allow multiple delimiters like this: `//[delim1][delim2]\n` for example `//[-][%]\n1-2%3` should return `6`
12. Make sure you can also handle multiple delimiters with length longer than one char